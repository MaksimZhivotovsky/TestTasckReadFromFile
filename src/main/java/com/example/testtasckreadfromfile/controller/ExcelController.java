package com.example.testtasckreadfromfile.controller;

import com.example.testtasckreadfromfile.exaptions.InvalidNthMaxException;
import com.example.testtasckreadfromfile.service.ExcelService;
import com.example.testtasckreadfromfile.service.MaxNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ExcelController {
    private final ExcelService excelService;
    private final MaxNumberService maxNumberService;


    @GetMapping("/nth-max")
    public ResponseEntity<?> getNthMax2(@RequestParam String filePath, @RequestParam int n) {
        try {
            int[] numbers = excelService.readNumbersFromExcel(filePath);
            List<Integer> result = maxNumberService.findNthMax(numbers, n);
            return ResponseEntity.ok(result);
        } catch (InvalidNthMaxException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error: Cannot open the file. Check if the path or file format is correct.");
        }
    }
}
