package com.sahil.springjwt.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WarehouseDto {
	
	private long warehouseId;
	private String warehouseName;
	private String warehouseLocation;
	private Date createdAt;

}
