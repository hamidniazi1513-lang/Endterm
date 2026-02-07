package com.hamidniazi.endterm_project.patterns;

import org.springframework.stereotype.Component;

@Component
public class ReportFactory {

    public Report createReport(String type) {
        if ("PDF".equalsIgnoreCase(type)) {
            return new PdfReport();
        } else if ("CSV".equalsIgnoreCase(type)) {
            return new CsvReport();
        }
        throw new IllegalArgumentException("Unknown report type: " + type);
    }
}