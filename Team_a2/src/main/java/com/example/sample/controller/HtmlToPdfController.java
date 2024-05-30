package com.example.sample.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

	@GetMapping("/pdf")
	public String index() {
		return "templateedit";
	}

//	@GetMapping("/new")
//	public String index2() {
//		return "new";
//	}

	@PostMapping("/TestPdf")
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

		String fullContent = test_example_head;

		List<String> question = new ArrayList<>();
		question.add(content1);
		question.add(content2);
		fullContent += test_writing(1, question);
		question = delete_contents(question);
		question.add(content3);
		question.add(content4);
		question.add(content5);
		fullContent += test_writing(2, question);
		question = delete_contents(question);
		question.add(content6);
		question.add(content7);
		question.add(content8);
		question.add(content9);
		question.add(content10);
		fullContent += test_writing(3, question);
		question = delete_contents(question);
		question.add(content11);
		question.add(content12);
		question.add(content13);
		question.add(content14);
		fullContent += test_writing(4, question);
		question = delete_contents(question);
		question.add(content15);
		question.add(content16);
		question.add(content17);
		fullContent += test_writing(5, question);
		question.add(content18);
		question.add(content19);
		question.add(content20);
		fullContent += test_writing(6, question);
		fullContent += test_exmaple_body;
		List<String> answer = new ArrayList<>();
		answer.add("1.");
		answer.add("2.");
		fullContent += test_writing_answer(1, answer);
		answer = delete_contents(answer);
		answer.add("1.");
		answer.add("2.");
		answer.add("3.");
		fullContent += test_writing_answer(2, answer);
		answer = delete_contents(answer);
		answer.add("1.");
		answer.add("2.");
		answer.add("3.");
		answer.add("4.");
		answer.add("5.");
		fullContent += test_writing_answer(3, answer);
		fullContent += "         <br></br><br></br><br></br>   ";
		answer = delete_contents(answer);
		answer.add("1.");
		answer.add("2.");
		answer.add("3.");
		answer.add("4.");
		fullContent += test_writing_answer(4, answer);
		answer = delete_contents(answer);
		answer.add("1.");
		answer.add("2.");
		answer.add("3.");
		fullContent += test_writing_answer(5, answer);
		answer = delete_contents(answer);
		answer.add("1.");
		answer.add("2.");
		answer.add("3.");
		fullContent += test_writing_answer(6, answer);

		fullContent += test_exmaple_end;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ITextRenderer renderer = new ITextRenderer();

		// フォント設定
		ITextFontResolver fontResolver = renderer.getFontResolver();
		fontResolver.addFont("src/main/resources/fonts/ipaexg.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

		renderer.setDocumentFromString(fullContent);
		renderer.layout();
		renderer.createPDF(baos);

		filename = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
		String document = filename + ".pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + document);
		response.setContentLength(baos.size());

		ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
		org.apache.commons.io.IOUtils.copy(bis, response.getOutputStream());
		response.flushBuffer();

	}

	private List<String> delete_contents(List<String> list) {

		list.clear();
		return list;
	}

	private String test_writing(int number, List<String> question) {
		String text = "			<div class=\"question-group\">\n"
				+ "				<h3>Question" + number + "</h3>\n";
		for (int i = 0; i < question.size(); i++) {
			int count = i + 1;
			text += "				<div class=\"question\">" + count + "." + question.get(i) + "</div>\n";
		}
		text += "			</div>\n";

		return text;
	}

	private String test_writing_answer(int number, List<String> question) {
		String text = "			<h4>" + number + "</h4>\n";
		for (int i = 0; i < question.size(); i++) {
			text += "			<div class=\"answer-box\">" + question.get(i) + "</div>\n";
		}

		return text;
	}

	public String test_example_head = "<!DOCTYPE html>\n"
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
			+ "         width:700px;\n"
			+ "			margin-bottom: 10px;\n"
			+ "		}\n"
			+ "\n"
			+ "		.answer-box {\n"
			+ "			margin-bottom: 10px;\n"
			+ "			border: 1px solid #000;\n"
			+ "			padding: 10px;\n"
			+ "			height: 40px;\n"
			+ "		}\n"
			+ "		.name-box {\n"
			+ "			margin-bottom: 10px;\n"
			+ "			border: 1px solid #000;\n"
			+ "			padding: 10px;\n"
			+ "			height: 20px;\n"
			+ "		}\n"
			+ "	</style>\n"
			+ "</head>\n"
			+ "\n"
			+ "<body>\n"
			+ "\n"
			+ "	<div class=\"container\">\n"
			+ "		<div class=\"questions\">\n";

	public String test_exmaple_body = "		</div>\n"
			+ "     <br></br><br></br><br></br>"
			+ "		<div class=\"answers\">\n"
			+ "			<h4>Answer</h4>\n";

	public String test_exmaple_end = "         <br></br>" + "         <div class=\"name-box\">Name.</div>\n"
			+ "		</div>\n"
			+ "	</div>\n"
			+ "</body>\n"
			+ "\n"
			+ "</html>\n"
			+ "";

}

//buildgradleの追加
//implementation 'org.xhtmlrenderer:flying-saucer-pdf:9.1.20'
//implementation 'com.lowagie:itext:2.1.7'
//implementation 'commons-io:commons-io:2.11.0'
