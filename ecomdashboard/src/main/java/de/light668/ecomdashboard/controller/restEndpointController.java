/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.light668.ecomdashboard.controller;

import de.light668.ecomdashboard.entity.EmployeeInformation;
import de.light668.ecomdashboard.services.DashboardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Timo Radtke
 */
@RestController
public class restEndpointController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/employees")
    public List<EmployeeInformation> getAllEmp() {
        return dashboardService.getAllEmployee();
    }

    @PostMapping("/employee/add")
    public String saveEmployeeInfo(@RequestBody EmployeeInformation employeeInformation) {

        if (dashboardService.addEmployee(employeeInformation) != null) {
            return "Employee data saved successfully!";
        } else {
            return "Error saving employee info!";
        }
    }

    @PutMapping("/employee/delete")
    public String deleteEmp(@RequestParam(name = "empId", required = true) long pk) {
        try {
            dashboardService.deleteEmployee(dashboardService.getEmployee(pk));
            return "deleted";
        } catch (Exception e) {
            return "error";
        }
    }
}
