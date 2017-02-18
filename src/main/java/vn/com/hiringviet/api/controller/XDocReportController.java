package vn.com.hiringviet.api.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.hiringviet.api.dto.response.ExportApplyDTO;
import vn.com.hiringviet.api.dto.response.ExportApplysDTO;
import vn.com.hiringviet.api.dto.response.ExportEducationHistDTO;
import vn.com.hiringviet.api.dto.response.ExportEmployeeHistDTO;
import vn.com.hiringviet.api.dto.response.ExportMemberDTO;
import vn.com.hiringviet.api.dto.response.ExportProjectDTO;
import vn.com.hiringviet.api.dto.response.ExportSkillDTO;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.EducationHistory;
import vn.com.hiringviet.model.EmploymentHistory;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Project;
import vn.com.hiringviet.model.SkillResume;
import vn.com.hiringviet.service.ApplyService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.Utils;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

@Controller
public class XDocReportController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ApplyService applyService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/export/applyList")
	public void exportDocx(@RequestParam("jobId") Integer jobId,
			@RequestParam("companyId") Integer companyId,
			HttpServletResponse response) {

		Account account = getLoggedAccount();
		if (account != null && account.getCompany() != null
				&& account.getCompany().getId() == companyId) {

			try {
				// 1) Load Docx file by filling Velocity template engine and
				// cache it to the registry
				InputStream in = XDocReportController.class
						.getResourceAsStream("/exportApply.docx");
				IXDocReport report = XDocReportRegistry.getRegistry()
						.loadReport(in, TemplateEngineKind.Velocity);

				// 2) Create fields metadata to manage lazy loop (#forech
				// velocity)
				// for table row.
				// 1) Create FieldsMetadata by setting Velocity as template
				// engine
				FieldsMetadata fieldsMetadata = report.createFieldsMetadata();
				// 2) Load fields metadata from Java Class
				fieldsMetadata.load("exportApply", ExportApplyDTO.class);
				// Here load is called with true because model is a list of
				// Developer.
				fieldsMetadata
						.load("exportApplys", ExportApplysDTO.class, true);

				// 2) Create context Java model
				IContext context = report.createContext();

				String fileTitle = messageSource.getMessage(
						"message.export.apply.fileTitle", null, null);
				String headerTitle = messageSource.getMessage(
						"message.export.apply.headerTitle", null, null);
				String footerTitle = messageSource.getMessage(
						"message.export.apply.footerTitle", null, null);
				String nameTitle = messageSource.getMessage(
						"message.export.apply.nameTitle", null, null);
				String emailTitle = messageSource.getMessage(
						"message.export.apply.emailTitle", null, null);
				String curriculumVitaeTitle = messageSource
						.getMessage(
								"message.export.apply.curriculumVitaeTitle",
								null, null);
				ExportApplyDTO exportApplyDTO = new ExportApplyDTO(fileTitle,
						headerTitle, footerTitle, nameTitle, emailTitle,
						curriculumVitaeTitle);
				context.put("exportApply", exportApplyDTO);

				List<ApplyDTO> applyDTOs = applyService
						.getAllApplyByJobId(jobId);
				List<ExportApplysDTO> exportApplys = new ArrayList<ExportApplysDTO>();
				ExportApplysDTO exportApplysDTO = null;
				if (applyDTOs != null) {
					for (ApplyDTO applyDTO : applyDTOs) {
						exportApplysDTO = new ExportApplysDTO(
								applyDTO.getMemberName(),
								applyDTO.getMemberEmail(),
								applyDTO.getMemberPhoneNumber(),
								"localhost:8888/file/download/"
										+ applyDTO.getCurriculumVitae());
						exportApplys.add(exportApplysDTO);
					}
				}
				context.put("exportApplys", exportApplys);

				// 3) Generate report by merging Java model with the Docx
				OutputStream outputStream = Utils.exportDocx(response,
						"HiringViet_Export").getOutputStream();
				report.process(context, outputStream);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (XDocReportException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/export/CV")
	public void exportCVDocx(@RequestParam("memberId") Integer memberId,
			HttpServletResponse response) {

		Account account = getLoggedAccount();
		if (account != null && account.getMember() != null
				&& account.getMember().getId() == memberId) {

			try {
				// 1) Load Docx file by filling Velocity template engine and
				// cache
				// it to the registry
				InputStream in = XDocReportController.class
						.getResourceAsStream("/exportCV.docx");
				IXDocReport report = XDocReportRegistry.getRegistry()
						.loadReport(in, TemplateEngineKind.Velocity);

				FieldsMetadata fieldsMetadata = report.createFieldsMetadata();
				fieldsMetadata.load("member", ExportMemberDTO.class);
				fieldsMetadata.load("educations", ExportEducationHistDTO.class,
						true);
				fieldsMetadata.load("employees", ExportEmployeeHistDTO.class,
						true);
				fieldsMetadata.load("projects", ExportProjectDTO.class, true);
				fieldsMetadata.load("skills", ExportSkillDTO.class, true);

				// 2) Create context Java model
				IContext context = report.createContext();

				Member member = memberService.getMemberByID(memberId);
				String sex = null;
				if (member.getResume().isMaleGender()) {
					sex = "Male";
				} else {
					sex = "Female";
				}

				String address = member.getResume().getAddress().getDistrict()
						.getDistrictName()
						+ ", "
						+ member.getResume().getAddress().getDistrict()
								.getProvince().getProvinceName();
				ExportMemberDTO exportMemberDTO = new ExportMemberDTO(
						member.getFirstName() + " " + member.getLastName(),
						sex, member.getResume().getBirthDate().toString(),
						address, member.getAccount().getEmail(), member
								.getResume().getPhoneNumber(), member
								.getResume().getSummary());
				context.put("member", exportMemberDTO);

				Set<EducationHistory> educationHistories = member.getResume()
						.getEducationHistorySet();
				List<ExportEducationHistDTO> educationHistDTOs = new ArrayList<ExportEducationHistDTO>();
				ExportEducationHistDTO exportEducationHistDTO = null;
				if (educationHistories != null) {
					for (EducationHistory educationHistory : educationHistories) {
						exportEducationHistDTO = new ExportEducationHistDTO(
								educationHistory.getUniversityName(),
								educationHistory.getMajorName(),
								educationHistory.getBeginYear(),
								educationHistory.getEndYear(),
								educationHistory.getDegree(),
								educationHistory.getSocialActivity());
						educationHistDTOs.add(exportEducationHistDTO);
					}
				}
				context.put("educations", educationHistDTOs);

				Set<EmploymentHistory> employmentHistories = member.getResume()
						.getEmployeeHistorySet();
				List<ExportEmployeeHistDTO> exportEmployeeHistDTOs = new ArrayList<ExportEmployeeHistDTO>();
				ExportEmployeeHistDTO exportEmployeeHistDTO = null;
				List<ExportProjectDTO> exportProjectDTOs = new ArrayList<ExportProjectDTO>();
				if (employmentHistories != null) {
					for (EmploymentHistory employmentHistory : employmentHistories) {
						Set<Project> projects = employmentHistory.getProjects();
						ExportProjectDTO exportProjectDTO = null;
						for (Project project : projects) {
							exportProjectDTO = new ExportProjectDTO(
									project.getName(),
									project.getDescription(), project.getUrl());
							exportProjectDTOs.add(exportProjectDTO);
						}
						exportEmployeeHistDTO = new ExportEmployeeHistDTO(
								employmentHistory.getCompanyName(),
								employmentHistory.getPosition()
										.getDisplayName(), employmentHistory
										.getBeginDate().toString(),
								employmentHistory.getEndDate().toString(),
								employmentHistory.getDescription());
						exportEmployeeHistDTOs.add(exportEmployeeHistDTO);
					}
				}
				context.put("employees", exportEmployeeHistDTOs);
				context.put("projects", exportProjectDTOs);

				Set<SkillResume> skillResumes = member.getResume()
						.getSkillResumeSet();
				List<ExportSkillDTO> exportSkillDTOs = new ArrayList<ExportSkillDTO>();
				ExportSkillDTO exportSkillDTO = null;
				if (skillResumes != null) {
					for (SkillResume skillResume : skillResumes) {
						exportSkillDTO = new ExportSkillDTO(skillResume
								.getSkill().getDisplayName());
						exportSkillDTOs.add(exportSkillDTO);
					}
				}
				context.put("skills", exportSkillDTOs);

				// 3) Generate report by merging Java model with the Docx
				OutputStream outputStream = Utils.exportDocx(response,
						"HiringViet_Export_CV").getOutputStream();
				report.process(context, outputStream);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (XDocReportException e) {
				e.printStackTrace();
			}
		}

	}

	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}
}
