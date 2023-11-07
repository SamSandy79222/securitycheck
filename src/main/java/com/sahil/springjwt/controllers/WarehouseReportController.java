package com.sahil.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.WarehouseReport;
import com.sahil.springjwt.service.WarehouseReportService;


@RestController
@RequestMapping("/warehousereport")
public class WarehouseReportController {

	
	@Autowired
    private WarehouseReportService warehouseReportService;
	
	@GetMapping("/{warehouseId}")
    public List<WarehouseReport> generateWarehouseReport(@RequestParam Long warehouseId) {
        // Call the service to generate a list of reports based on the warehouseId
        List<WarehouseReport> warehouseReports = warehouseReportService.generateWarehouseReportForWarehouse(warehouseId);
        
        // Check if the list is empty and handle accordingly
        if (warehouseReports.isEmpty()) {
            // You can return an appropriate response or throw an exception
            // For example:
            // throw new WarehouseReportNotFoundException("Warehouse reports not found");
        }

        return warehouseReports;
    }
	
	
}
