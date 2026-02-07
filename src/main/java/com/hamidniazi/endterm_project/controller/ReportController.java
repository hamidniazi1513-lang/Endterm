package com.hamidniazi.endterm_project.controller;

import com.hamidniazi.endterm_project.patterns.Report;
import com.hamidniazi.endterm_project.patterns.ReportFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportFactory reportFactory;

    public ReportController(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    @GetMapping("/{type}")
    public String getReport(@PathVariable String type) {
        Report report = reportFactory.createReport(type);
        return report.generate();
    }
}