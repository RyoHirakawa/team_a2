package com.example.sample.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HtmlToPdfController {


	@GetMapping("/templateedit")
	public String edit() {
		return "templateedit";
	}

	@PostMapping("/generatePdf")
	public void generatePdf(
			@RequestParam("content1") String content1,
			@RequestParam("content2") String content2,
			@RequestParam("content3") String content3,
			@RequestParam("content4") String content4,
			@RequestParam("content5") String content5,
			@RequestParam("content6") String content6,
			@RequestParam("content7") String content7,
			@RequestParam("content8") String content8,
			@RequestParam("content9") String content9,
			@RequestParam("content10") String content10,
			@RequestParam("content11") String content11,
			@RequestParam("content12") String content12,
			@RequestParam("content13") String content13,
			@RequestParam("content14") String content14,
			@RequestParam("content15") String content15,
			@RequestParam("content16") String content16,
			@RequestParam("content17") String content17,
			@RequestParam("content18") String content18,
			@RequestParam("content19") String content19,
			@RequestParam("content20") String content20,
			@RequestParam("file") String filename,
			HttpServletResponse response) throws DocumentException, IOException {

		String fullContent = "<!DOCTYPE html>\n"
				+ "<html lang=\"ja\">\n"
				+ "\n"
				+ "<head>\n"
				+ "	<meta charset=\"UTF-8\" />\n"
				+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n"
				+ "	<title>テスト問題用紙</title>\n"
				+ "	<style>\n"
				+ "		body {\n"
				+ "			font-family: Arial, sans-serif;\n"
				+ "			margin: 0;\n"
				+ "			padding: 20px;\n"
				+ "		}\n"
				+ "\n"
				+ "		.container {\n"
				+ "			display: flex;\n"
				+ "		}\n"
				+ "\n"
				+ "		.questions {\n"
				+ "			flex: 2;\n"
				+ "		}\n"
				+ "\n"
				+ "		.answers {\n"
				+ "			flex: 1;\n"
				+ "			margin-left: 20px;\n"
				+ "			border-left: 2px solid #000;\n"
				+ "			padding-left: 20px;\n"
				+ "		}\n"
				+ "\n"
				+ "		.question-group {\n"
				+ "			margin-bottom: 30px;\n"
				+ "		}\n"
				+ "\n"
				+ "		.question {\n"
				+ "         width:200px;\n"
				+ "			margin-bottom: 10px;\n"
				+ "		}\n"
				+ "\n"
				+ "		.answer-box {\n"
				+ "			margin-bottom: 10px;\n"
				+ "			border: 1px solid #000;\n"
				+ "			padding: 10px;\n"
				+ "			height: 40px;\n"
				+ "		}\n"
				+ "	</style>\n"
				+ "</head>\n"
				+ "\n"
				+ "<body>\n"
				+ "\n"
				+ "	<div class=\"container\">\n"
				+ "		<div class=\"questions\">\n"
				+ "			<div class=\"question-group\">\n"
				+ "				<h3>Question1</h3>\n"
				+ "				<div class=\"question\">1." + content1 + "</div>\n"
				+ "				<div class=\"question\">2. " + content2 + "</div>\n"
				+ "			</div>\n"
				+ "			<div class=\"question-group\">\n"
				+ "				<h3>Question2</h3>\n"
				+ "				<div class=\"question\">3. " + content3 + "</div>\n"
				+ "				<div class=\"question\">4. " + content4 + "</div>\n"
				+ "				<div class=\"question\">5. " + content5 + "</div>\n"
				+ "			</div>\n"
				+ "			<div class=\"question-group\">\n"
				+ "				<h3>Question3</h3>\n"
				+ "				<div class=\"question\">6. " + content6 + "</div>\n"
				+ "				<div class=\"question\">7. " + content7 + "</div>\n"
				+ "				<div class=\"question\">8. " + content8 + "</div>\n"
				+ "				<div class=\"question\">9. " + content9 + "</div>\n"
				+ "				<div class=\"question\">10. " + content10 + "</div>\n"
				+ "			</div>\n"
				+ "			<div class=\"question-group\">\n"
				+ "				<h3>Question4</h3>\n"
				+ "				<div class=\"question\">11. " + content11 + "</div>\n"
				+ "				<div class=\"question\">12. " + content12 + "</div>\n"
				+ "				<div class=\"question\">13. " + content13 + "</div>\n"
				+ "				<div class=\"question\">14. " + content14 + "</div>\n"
				+ "			</div>\n"
				+ "			<div class=\"question-group\">\n"
				+ "				<h3>Question5</h3>\n"
				+ "				<div class=\"question\">15. " + content15 + "</div>\n"
				+ "				<div class=\"question\">16. " + content16 + "</div>\n"
				+ "				<div class=\"question\">17. " + content17 + "</div>\n"
				+ "			</div>\n"
				+ "			<div class=\"question-group\">\n"
				+ "				<h3>Question6</h3>\n"
				+ "				<div class=\"question\">18. " + content18 + "</div>\n"
				+ "				<div class=\"question\">19. " + content19 + "</div>\n"
				+ "				<div class=\"question\">20. " + content20 + "</div>\n"
				+ "			</div>\n"
				+ "		</div>\n"
				+ "     <br></br><br></br><br></br><br></br><br></br>"
				+ "		<div class=\"answers\">\n"
				+ "			<h4>Answer</h4>\n"
				+ "			<h4>Question1</h4>\n"
				+ "			<div class=\"answer-box\">1.</div>\n"
				+ "			<div class=\"answer-box\">2.</div>\n"
				+ "			<h4>Question2</h4>\n"
				+ "			<div class=\"answer-box\">3.</div>\n"
				+ "			<div class=\"answer-box\">4.</div>\n"
				+ "			<div class=\"answer-box\">5.</div>\n"
				+ "			<h4>Question3</h4>\n"
				+ "			<div class=\"answer-box\">6.</div>\n"
				+ "			<div class=\"answer-box\">7.</div>\n"
				+ "			<div class=\"answer-box\">8.</div>\n"
				+ "			<div class=\"answer-box\">9.</div>\n"
				+ "			<div class=\"answer-box\">10.</div>\n"
				+ "         <br></br><br></br><br></br>   "
				+ "			<h4>Question4</h4>\n"
				+ "			<div class=\"answer-box\">11.</div>\n"
				+ "			<div class=\"answer-box\">12.</div>\n"
				+ "			<div class=\"answer-box\">13.</div>\n"
				+ "			<div class=\"answer-box\">14.</div>\n"
				+ "			<h4>Question5</h4>\n"
				+ "			<div class=\"answer-box\">15.</div>\n"
				+ "			<div class=\"answer-box\">16.</div>\n"
				+ "			<div class=\"answer-box\">17.</div>\n"
				+ "			<h4>Question6</h4>\n"
				+ "			<div class=\"answer-box\">18.</div>\n"
				+ "			<div class=\"answer-box\">19.</div>\n"
				+ "			<div class=\"answer-box\">20.</div>\n"
				+ "		</div>\n"
				+ "	</div>\n"
				+ "</body>\n"
				+ "\n"
				+ "</html>\n"
				+ "";

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ITextRenderer renderer = new ITextRenderer();

		// フォント設定
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("src/main/resources/fonts/ipaexg.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

		renderer.setDocumentFromString(fullContent);
		renderer.layout();
		renderer.createPDF(baos);

		String document = filename + ".pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + document);
		response.setContentLength(baos.size());

		ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
		org.apache.commons.io.IOUtils.copy(bis, response.getOutputStream());
		response.flushBuffer();

	}

}
//buildgradleの追加
//implementation 'org.xhtmlrenderer:flying-saucer-pdf:9.1.20'
//implementation 'com.lowagie:itext:2.1.7'
//implementation 'commons-io:commons-io:2.11.0'