/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.light668.ecomdashboard.services;

import de.light668.ecomdashboard.entity.EmployeeInformation;
import de.light668.ecomdashboard.entity.OrderCollectionStatus;
import de.light668.ecomdashboard.entity.OrderRecieved;
import de.light668.ecomdashboard.entity.ProductCategory;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Timo Radtke
 */
@Service
public interface DashboardService {

    public HashMap<String, Object> getTodayRevenueDash();

    public HashMap<String, Object> getBestCategory();

    List<OrderRecieved> getAllOrderRecieved();
    
    public List<Integer> getOrdersRecieved(List<OrderRecieved> orders);
    
    public List<String> getOrderDates (List<OrderRecieved> orders);

    List<OrderCollectionStatus> getOrderCollection();

    List<EmployeeInformation> getAllEmployee();

    EmployeeInformation getEmployee(final long pk);

    EmployeeInformation addEmployee(EmployeeInformation employeeInformation);

    EmployeeInformation updateEmployee(EmployeeInformation employeeInformation);

    void deleteEmployee(EmployeeInformation employeeInformation);

}
