package com.example.sample.controller;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PdfController {

    @PostMapping("/generatePdfDemo")
    public ResponseEntity<InputStreamResource> generatePdf(
            @RequestParam("file") String fileName,
            @RequestParam Map<String, String> allParams) {

        if (fileName == null || fileName.trim().isEmpty()) {
            fileName = "default.pdf";
        } else {
            fileName = fileName + ".pdf";
        }

        fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

        // PDF生成ロジック（省略）
        byte[] pdfBytes = generatePdfBytes(allParams);

        ByteArrayInputStream bis = new ByteArrayInputStream(pdfBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + fileName);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(bis));
    }

    private byte[] generatePdfBytes(Map<String, String> params) {
        // PDF生成ロジックをここに実装
        return new byte[0]; // これはダミーです。実際のPDFバイト配列を返すように実装してください。
    }
}
