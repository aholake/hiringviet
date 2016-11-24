package vn.com.hiringviet.api.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.Utils;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

@Controller
public class XDocReportController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/CSV/export/odt")
	public @ResponseBody void exportOdt(HttpServletResponse response) {

		// 1) Load ODT file and set Velocity template engine and cache it to the registry           
		InputStream inputStream = XDocReportController.class.getResourceAsStream("/CV.odt");
		IXDocReport ixDocReport = null;
		try {
			ixDocReport = XDocReportRegistry.getRegistry().loadReport(inputStream, TemplateEngineKind.Velocity);
		} catch (IOException | XDocReportException e) {
			e.printStackTrace();
		}

		// 2) Create Java model context 
		IContext context = null;
		try {
			context = ixDocReport.createContext();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}

//		context.put("date", new DateTool());
		Member member = memberService.getMemberByID(1);
		context.put("member", member);

		// 3) Generate report by merging Java model with the ODT
		try {
			OutputStream outputStream = Utils.exportODT(response, "CV_" + member.getFullName()).getOutputStream();
			ixDocReport.process(context, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XDocReportException e) {
			e.printStackTrace();
		}
		
	}

	@RequestMapping(value = "/CSV/export/docx")
	public @ResponseBody void exportDocx(HttpServletResponse response) {

		 try {
		      // 1) Load Docx file by filling Velocity template engine and cache it to the registry
		      InputStream in = XDocReportController.class.getResourceAsStream("/CV.docx");
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Velocity);

		      // 2) Create context Java model
		      IContext context = report.createContext();
		      Member member = memberService.getMemberByID(1);
		      context.put("member", member);

		      // 3) Generate report by merging Java model with the Docx
		      OutputStream outputStream = Utils.exportDocx(response, "CV_" + member.getFullName()).getOutputStream();
		      report.process(context, outputStream);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }
		
	}
}
