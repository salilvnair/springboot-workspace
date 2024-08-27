package com.salilvnair.springboot.workspace.excel.reader.service;

import com.github.salilvnair.excelprocessor.v2.context.ExcelSheetContext;
import com.github.salilvnair.excelprocessor.v2.processor.factory.ExcelSheetReaderFactory;
import com.github.salilvnair.excelprocessor.v2.processor.validator.context.CellValidationMessage;
import com.github.salilvnair.excelprocessor.v2.service.ExcelSheetReader;
import com.salilvnair.springboot.workspace.excel.reader.bean.TestSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ExcelReaderTestService {

    @Autowired
    private ApplicationContext applicationContext;

    public void read() {
        ExcelSheetReader reader = ExcelSheetReaderFactory.generate();

        ExcelSheetContext sheetContext = ExcelSheetContext.builder()
                                        .excelFile(new File("/Users/salilvnair/workspace/git/salilvnair/springboot-workspace/src/main/resources/excel/Book1.xlsx"))
                                        .beanResolver(bean -> applicationContext.containsBean(bean) ? applicationContext.getBean(bean) : null)
                                        .build();


        List<TestSheet> testSheets = reader.read(TestSheet.class, sheetContext);
        List<CellValidationMessage> validationMessages = reader.validate(testSheets, sheetContext);
        System.out.println(validationMessages);
    }
}
