/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.light668.ecomdashboard.controller;

import de.light668.ecomdashboard.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Timo Radtke
 */
@Controller
public class ThymeleafController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public String getDashDetail(Model model) {

        model.addAttribute("cr", dashboardService.getTodayRevenueDash());

        model.addAttribute("ei", dashboardService.getAllEmployee());

        model.addAttribute("pc", dashboardService.getBestCategory());

        model.addAttribute("orderRecieved", dashboardService.getOrdersRecieved(dashboardService.getAllOrderRecieved()));
        
        model.addAttribute("orderDate", dashboardService.getOrderDates(dashboardService.getAllOrderRecieved()));

        return "/index";
    }
}
