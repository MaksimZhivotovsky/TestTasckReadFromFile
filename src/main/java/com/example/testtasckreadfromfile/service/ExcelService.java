package com.example.testtasckreadfromfile.service;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for working with Excel files.
 * Provides methods for reading data from Excel files.
 */
@Service
public class ExcelService {


    public int[] readNumbersFromExcel(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath))) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
        }

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
