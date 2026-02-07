package com.hamidniazi.endterm_project.patterns;

public class PdfReport implements Report {
    @Override
    public String generate() {
        return "Generating PDF Report for system...";
    }
}