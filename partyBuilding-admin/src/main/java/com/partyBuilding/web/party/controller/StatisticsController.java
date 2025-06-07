package com.partyBuilding.web.party.controller;

import com.partyBuilding.web.party.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private IStatisticsService statisticsService;

}
