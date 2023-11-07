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
@Table(name="purchaseReturn")
@Getter
@Setter
public class PurchaseReturn {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pRId;
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	private String supplierCompanyName;
	
	private long invoiceNumber;
	private String Date;
	private String DueDate;
	private String Type;
	private String taxType;
	
	@ManyToOne
	@JoinColumn(name="suppliersId")
	private Suppliers suppliers;
	
	private String shippingAddress;
	
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
	@JoinColumn(name="pRid")
	private List<PurchaseReturnItems> purchaseReturnItems;
}
