package com.sahil.springjwt.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseReport {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	    private Long id;
	    private String part_no;
	    private long quantity;
	    private long inward;
	    private long outward;
	    private long closingStock;
}
