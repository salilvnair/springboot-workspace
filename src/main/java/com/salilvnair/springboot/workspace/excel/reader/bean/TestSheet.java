package com.salilvnair.springboot.workspace.excel.reader.bean;

import com.github.salilvnair.excelprocessor.v2.annotation.Cell;
import com.github.salilvnair.excelprocessor.v2.annotation.CellValidation;
import com.github.salilvnair.excelprocessor.v2.annotation.Sheet;
import com.github.salilvnair.excelprocessor.v2.sheet.BaseSheet;
import com.salilvnair.springboot.workspace.excel.reader.bean.validator.TestSheetTaskValidator;
import lombok.Getter;
import lombok.Setter;

@Sheet(
        value = "Test",
        excelTaskValidatorBeanName = TestSheetTaskValidator.BEAN
)
@Getter
@Setter
public class TestSheet extends BaseSheet {
    @CellValidation(customTask = "randomTask")
    @Cell("Name")
    private String name;

    @Cell("Value")
    private String value;
}
