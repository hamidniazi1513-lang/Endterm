package com.hamidniazi.endterm_project.patterns;

public class CsvReport implements Report {
    @Override
    public String generate() {
        return "Generating CSV Report for system...";
    }
}