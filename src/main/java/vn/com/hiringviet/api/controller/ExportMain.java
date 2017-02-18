package vn.com.hiringviet.api.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import vn.com.hiringviet.api.dto.response.ExportApplyDTO;
import vn.com.hiringviet.api.dto.response.ExportApplysDTO;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class ExportMain {

	public static void genExportApply() throws XDocReportException,
			FileNotFoundException, IOException {
		// 1) Create FieldsMetadata by setting Velocity as template engine
		FieldsMetadata fieldsMetadata = new FieldsMetadata(
				TemplateEngineKind.Velocity.name());

		// 2) Load fields metadata from Java Class
		fieldsMetadata.load("exportApply", ExportApplyDTO.class);
		// Here load is called with true because model is a list of Developer.
		fieldsMetadata.load("exportApplys", ExportApplysDTO.class, true);

		// 3) Generate XML fields in the file "project.fields.xml".
		// Extension *.fields.xml is very important to use it with MS Macro
		// XDocReport.dotm
		// FieldsMetadata#saveXML is called with true to indent the XML.
		File xmlFieldsFile = new File("exportApply.fields.xml");
		fieldsMetadata.saveXML(new FileOutputStream(xmlFieldsFile), true);
		System.out.println("DONE");
	}

	public static void main(String[] args) throws XDocReportException,
			FileNotFoundException, IOException {
	}
}
