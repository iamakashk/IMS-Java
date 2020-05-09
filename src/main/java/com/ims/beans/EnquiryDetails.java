package com.ims.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enquiry_details")
public class EnquiryDetails {

	public EnquiryDetails() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "en_dtl_id")
	private int enquiryDetailId;

	@Column(name = "en_dtl_enquiry_id")
	private int enquiryId;

	@Column(name = "en_dtl_item_code")
	private int enquiryItemCode;

	@Column(name = "en_dtl_ts_created")
	private String enquiryDetailTsCreated;

	@Column(name = "en_dtl_item_name")
	private String itemName;
	@Column(name = "en_dtl_item_period")
	private String itemPeriod;
	@Column(name = "en_dtl_item_rate")
	private String itemRate;
	@Column(name = "en_dtl_item_qty")
	private String itemQty;

	@Column(name = "en_dtl_deleted_flg")
	private String deletedFlag;
	
	public int getEnquiryDetailId() {
		return enquiryDetailId;
	}

	public int getEnquiryId() {
		return enquiryId;
	}

	public int getEnquiryItemCode() {
		return enquiryItemCode;
	}

	public String getEnquiryDetailTsCreated() {
		return enquiryDetailTsCreated;
	}

	public void setEnquiryDetailId(int enquiryDetailId) {
		this.enquiryDetailId = enquiryDetailId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public void setEnquiryItemCode(int enquiryItemCode) {
		this.enquiryItemCode = enquiryItemCode;
	}

	public void setEnquiryDetailTsCreated(String enquiryDetailTsCreated) {
		this.enquiryDetailTsCreated = enquiryDetailTsCreated;
	}

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "IT_ITEM_CODE")
//	private Set<Item> items;

//	public Set<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(Set<Item> items) {
//		this.items = items;
//	}

	public String getItemName() {
		return itemName;
	}

	public String getItemPeriod() {
		return itemPeriod;
	}

	public String getItemRate() {
		return itemRate;
	}

	public String getItemQty() {
		return itemQty;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPeriod(String itemPeriod) {
		this.itemPeriod = itemPeriod;
	}

	public void setItemRate(String itemRate) {
		this.itemRate = itemRate;
	}

	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

}
