package com.smagin.financehelper.earningscalendar.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smagin.financehelper.earningscalendar.entity.EarningInfo;
import com.smagin.financehelper.earningscalendar.integration.ApiIntegrator;
import com.smagin.financehelper.earningscalendar.service.EarningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class EarningController {
    private final EarningService earningsService;
    private final ApiIntegrator apiIntegrator;

    @GetMapping("/earnings")
    public  List<EarningInfo> getEarnings() throws JsonProcessingException {
        return apiIntegrator.getEarningByCompanyNames();
    }

    @GetMapping("/hello")
    public String hello() throws JsonProcessingException {
        earningsService.saveAll(apiIntegrator.getEarningByCompanyNames());
        return "Success";
    }
}
