package com.salilvnair.springboot.workspace.excel.reader.bean.validator;

import com.github.salilvnair.excelprocessor.v2.processor.validator.context.CellValidatorContext;
import com.github.salilvnair.excelprocessor.v2.processor.validator.task.core.AbstractExcelTaskValidator;
import com.salilvnair.springboot.workspace.excel.reader.bean.TestSheet;
import org.springframework.stereotype.Component;

@Component(TestSheetTaskValidator.BEAN)
public class TestSheetTaskValidator extends AbstractExcelTaskValidator {
    public static final String BEAN = "TestSheetTaskValidator";

    public void randomTask(CellValidatorContext context) {
        TestSheet sheet = context.sheet(TestSheet.class);
        System.out.println(sheet);
    }

}
