package com.sahil.springjwt.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="purchase")
@Setter
@Getter
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pId;
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	@ManyToOne
	@JoinColumn(name="suppliersId")
	private Suppliers suppliers;
	
	private long invoiceNo;
	private String contactName;
	
	@CreationTimestamp
	@Column(updatable = true)
	private Date createdDate;
	
	private String dueDate;
	private String Type;
	
	@ManyToMany
	@JoinTable(name="ownerWithPurchase")
	private List<User> user;
	
	private String status;
	private String taxType;
	private String billingAddress;
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
	@JoinColumn(name="purchaseId")
	private List<PurchaseItem> purchaseItems;
	//if we want unique than use list instead of list

}
