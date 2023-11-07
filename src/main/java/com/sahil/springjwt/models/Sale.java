package com.sahil.springjwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sale")
@Setter
@Getter
public class Sale {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long saleId;
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	private String CustomerCompany;
	
	private long invoiceNo;
	private String contactName;
	private String date;
	private String dueDate;
	private String type;
	private long quotationNo;
	private String saleAgent;
	
	@ManyToMany
	@JoinTable(name="ownerWithSale")
	private List<User> users;
	
	private String deliveryDate;
	private String installationDate;
	private String taxType;
	private String referencedBy;
	private String remark;
	private String billingAddress;
	private String shippingAddress;
	private String installationAddress;
	
	private long soNo;
	
	private String soDate;
	private String delieveryDate;
	private String delieveryNote;
	private String supplierReference;
	private String buyerOrder;
	private String dispatchedDocumentNumber;
	private String dispatchThrough;
	private long ewayBillNumber;
	private String vehicleNumber;
	private String placeOfSupply;
	private String paymentTerm;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="saleId")
	private List<SaleItem> saleItem;
}
