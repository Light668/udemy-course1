/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.light668.ecomdashboard.services.Impl;

import de.light668.ecomdashboard.entity.CompanyRevenue;
import de.light668.ecomdashboard.entity.EmployeeInformation;
import de.light668.ecomdashboard.entity.OrderCollectionStatus;
import de.light668.ecomdashboard.entity.OrderRecieved;
import de.light668.ecomdashboard.entity.ProductCategory;
import de.light668.ecomdashboard.repositories.CompanyRevenueRepository;
import de.light668.ecomdashboard.repositories.EmployeeInformationRepository;
import de.light668.ecomdashboard.repositories.OrderCollectionStatusRepository;
import de.light668.ecomdashboard.repositories.OrderRecievedRepository;
import de.light668.ecomdashboard.repositories.ProductCategoryRepository;
import de.light668.ecomdashboard.services.DashboardService;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Timo Radtke
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private CompanyRevenueRepository companyRevenueRepository;
    @Autowired
    private EmployeeInformationRepository employeeInformationRepository;
    @Autowired
    private OrderCollectionStatusRepository orderCollectionStatusRepository;
    @Autowired
    private OrderRecievedRepository orderRecievedRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public HashMap<String, Object> getTodayRevenueDash() {
        HashMap<String, Object> populateCmpnyRev = new HashMap<>();

        List<CompanyRevenue> companyRevenueList = companyRevenueRepository.findAll();

        /**
         * Build Labels and Revenue
         */
        List<String> label = new ArrayList<>();
        List<String> _revenue = new ArrayList<>();
        double totalMargin = 0;
        double totalExpense = 0;
        double totalRevenue = 0;

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        for (CompanyRevenue companyRevenue : companyRevenueList) {
            label.add(companyRevenue.get_month());
            _revenue.add(String.valueOf(companyRevenue.getRevenue()));
            totalExpense = totalExpense + companyRevenue.getExpense();
            totalMargin = totalMargin + companyRevenue.getMargins();
            totalRevenue = totalRevenue + companyRevenue.getRevenue();

        }
        populateCmpnyRev.put("crLabels", label.toString());
        populateCmpnyRev.put("crRevenue", _revenue.toString());
        populateCmpnyRev.put("totalExpense", currencyFormatter.format(totalExpense));
        populateCmpnyRev.put("totalMargin", currencyFormatter.format(totalMargin));
        populateCmpnyRev.put("totalRevenue", currencyFormatter.format(totalRevenue));

        return populateCmpnyRev;
    }

    @Override
    public EmployeeInformation getEmployee(long pk) {
        return employeeInformationRepository.findByPk(pk);
    }

    @Override
    public List<EmployeeInformation> getAllEmployee() {
        return employeeInformationRepository.findAll();
    }

    @Override
    public HashMap<String, Object> getBestCategory() {
        HashMap<String, Object> populateBestPc = new HashMap<>();
        List<ProductCategory> productCategoryList = productCategoryRepository.findByBestCategory(true);

        List<String> labels = new ArrayList<>();
        List<Integer> bestProducts = new ArrayList<>();

        for (ProductCategory product : productCategoryList) {
            labels.add(product.getCategoryName());
            bestProducts.add(product.getPercentage());
        }
        populateBestPc.put("pcLabels", labels.toString());
        populateBestPc.put("pcPercentage", bestProducts.toString());
        return populateBestPc;
    }

    @Override
    public List<OrderRecieved> getAllOrderRecieved() {
        return orderRecievedRepository.findAll();
    }

    @Override
    public List<Integer> getOrdersRecieved(List<OrderRecieved> orders) {
        List<Integer> orderRecievedList = new ArrayList<>();
        for (OrderRecieved order : orders) {
            orderRecievedList.add(order.getOrderReceived());
        }
        return orderRecievedList;
    }

    @Override
    public List<String> getOrderDates(List<OrderRecieved> orders) {
        List<String> orderRecievedDate = new ArrayList<>();
        for (OrderRecieved order : orders) {
            orderRecievedDate.add(order.getDateReceived());
        }
        return orderRecievedDate;
    }

    @Override
    public List<OrderCollectionStatus> getOrderCollection() {
        return orderCollectionStatusRepository.findAll();
    }

    @Override
    public EmployeeInformation addEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }

    @Override
    public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }

    @Override
    public void deleteEmployee(EmployeeInformation employeeInformation) {
        employeeInformationRepository.delete(employeeInformation);
    }

}
