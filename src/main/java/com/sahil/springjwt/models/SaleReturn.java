package com.sahil.springjwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="saleReturn")
@Setter
@Getter
public class SaleReturn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long srid;
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	private long invoiceNo;
	private String Date;
	private String type;
	private String referenceBy;
	private String shippingAddress;
	private String installationAddress;
	//------------------------------
	private long poNo;
	private String poDate;
	private String deliveryDate;
	private String delieveryNote;
	
	private String supplierReference;
	private String buyerOrder;
	private long dispatchDocumentNo;
	private String dispatchThrough;
	private long ewayBillNo;
	private String vehicleNo;
	private String placeOfSupply;
	private String paymentTerm;
	private long accountNumber;
	private String bankName;
	private String branch;
	private String IfscCode;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="srid")
	private List<SaleReturnItem> saleReturnItems;
	

}
