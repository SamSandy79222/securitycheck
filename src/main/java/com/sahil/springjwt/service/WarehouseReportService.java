package com.sahil.springjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sahil.springjwt.models.WarehouseReport;
import com.sahil.springjwt.repository.WarehouseReportRepository;

@Service
public class WarehouseReportService {

	private final JdbcTemplate jdbcTemplate;
    private final WarehouseReportRepository warehouseReportRepository;
    @Autowired
    public WarehouseReportService(JdbcTemplate jdbcTemplate, WarehouseReportRepository warehouseReportRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.warehouseReportRepository = warehouseReportRepository;
    }
    
    public List<WarehouseReport> generateWarehouseReportForWarehouse(long warehouseId) {
        // Your SQL query to fetch the report data
        String sql = "SELECT product.part_no, opentock.quantity, " +
                "(sale_return_item.qty + purchase_items.qty) as inward, " +
                "(purchase_return_items.qty + sale_items.qty) as outward, " +
                "(opentock.quantity + ((sale_return_item.qty + purchase_items.qty) - " +
                "(purchase_return_items.qty + sale_items.qty))) as closingStock " +
                "FROM purchase_items " +
                "JOIN sale_return_item ON purchase_items.purchase_id = sale_return_item.sritemid " +
                "JOIN sale_items ON sale_return_item.sritemid = sale_items.sitem_id " +
                "JOIN purchase_return_items ON sale_items.sitem_id = purchase_return_items.pritemid " +
                "JOIN product ON purchase_return_items.pritemid = product.product_id " +
                "JOIN opentock ON product.product_id = opentock.stock_id " +
                "WHERE opentock.warehouses = ?";

        // Fetch data from the database using the SQL query and map it to WarehouseReport objects
        List<WarehouseReport> reports = jdbcTemplate.query(sql, new Object[]{warehouseId}, (rs, rowNum) -> {
            WarehouseReport report = new WarehouseReport();
            report.setPart_no(rs.getString("part_no"));
            report.setQuantity(rs.getLong("quantity"));
            report.setInward(rs.getLong("inward"));
            report.setOutward(rs.getLong("outward"));
            report.setClosingStock(rs.getLong("closingStock"));
            return report;
        });
        warehouseReportRepository.saveAll(reports);

        return reports;
    }
	
	
}
