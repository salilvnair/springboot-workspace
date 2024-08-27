package com.salilvnair.springboot.workspace.excel.controller;

import com.salilvnair.springboot.workspace.excel.reader.service.ExcelReaderTestService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelReaderTestService testService;

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        List<String> sheetNames = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                sheetNames.add(workbook.getSheetName(i));
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok(sheetNames);
    }

    @GetMapping("/readAndValidateExcel")
    public ResponseEntity<String> readAndValidateExcel() {
        testService.read();
        return ResponseEntity.ok("ok");
    }
}
