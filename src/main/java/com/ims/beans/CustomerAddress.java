package com.ims.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="cust_addr")
public class CustomerAddress implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAddress() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CSAD_ID")
	private int csadId;
	
	public int getCsadId() {
		return csadId;
	}

	public void setCsadId(int csadId) {
		this.csadId = csadId;
	}

	@Column(name="CSAD_ADDR_CODE")
	private int csadAddrCode;
	
	public int getCsadAddrCode() {
		return csadAddrCode;
	}

	public void setCsadAddrCode(int csadAddrCode) {
		this.csadAddrCode = csadAddrCode;
	}


	@Column(name="CSAD_CUST_SUPPLR_CODE")
	private int csadCustSupplrCode;
	
	@Column(name="CSAD_TYPE_OF_ADDRESS")
	private String csadTypeOfAddress;
	
	@Column(name="CSAD_ADDRESS")
	private String csadAddress;
	
	@Column(name="CSAD_CITY_CODE")
	private String csadCityCode;
	
	@Column(name="CSAD_CITY")
	private String csadCity;
	
	@Column(name="CSAD_PINCODE")
	private String csadPincode;
	
	@Column(name="CSAD_STATE_CODE")
	private String csadStateCode;
	
	@Column(name="CSAD_STATE")
	private String csadState;
	
	@Column(name="CSAD_COUNTRY_CODE")
	private String csadCountryCode;
	
	@Column(name="CSAD_TEL_NO1")
	private String csadTelNo1;
	
	@Column(name="CSAD_TEL_NO2")
	private String csadTelNo2;
	
	@Column(name="CSAD_MOBILE_NO")
	private String csadMobileNo;
	
	@Column(name="CSAD_EMAIL_1")
	private String csadEmail1;
	
	@Column(name="CSAD_EMAIL_2")
	private String csadEmail2;
	
	@Column(name="CSAD_TS_CREATED")
	private String csadTsCreated;
	
	@Column(name="CSAD_CREATED_BY")
	private String csadCreatedBy;
	
	@Column(name="CSAD_TS_EDITED")
	private String csadTsEdited;
	
	@Column(name="CSAD_DELETED_FLG")
	private String csadDeletedFlg;
	
	@Column(name="CSAD_EDITED_BY")
	private String csadEditedBy;
	
	@Column(name="CSAD_ADDRESS1")
	private String csadAddress1;
	
	@Column(name="CSAD_ADDRESS2")
	private String csadAddress2;
	
	@Column(name="CSAD_ADDRESS3")
	private String csadAddress3;
	
	@Column(name="CSAD_ADDRESS4")
	private String csadAddress4;
	
	@Column(name="CSAD_CONTACT_TELNO")
	private String csadContactTelNo;
	
	@Column(name="CSAD_CONTACT_STD")
	private String csadContactStd;
	
	@Column(name="CSAD_CONTACT_MOBILE")
	private String csadContactMobile;
	
	@Column(name="CSAD_CONTACT_NAME")
	private String csadContactName;
	
	@Column(name="CSAD_NAME")
	private String csadName;
	
	@Column(name="CSAD_PAN_NO")
	private String csadPanNo;
	
	@Column(name="CSAD_DELIVERY_TYPE")
	private String csadDeliveryType;
	
	@Column(name="CSAD_GST_NO")
	private String csadGstNo;

	

	

	public String getCsadTypeOfAddress() {
		return csadTypeOfAddress;
	}

	public String getCsadAddress() {
		return csadAddress;
	}

	public String getCsadCityCode() {
		return csadCityCode;
	}

	public String getCsadCity() {
		return csadCity;
	}

	public String getCsadPincode() {
		return csadPincode;
	}

	public String getCsadStateCode() {
		return csadStateCode;
	}

	public String getCsadState() {
		return csadState;
	}

	public String getCsadCountryCode() {
		return csadCountryCode;
	}

	public String getCsadTelNo1() {
		return csadTelNo1;
	}

	public String getCsadTelNo2() {
		return csadTelNo2;
	}

	public String getCsadMobileNo() {
		return csadMobileNo;
	}

	public String getCsadEmail1() {
		return csadEmail1;
	}

	public String getCsadEmail2() {
		return csadEmail2;
	}

	public String getCsadTsCreated() {
		return csadTsCreated;
	}

	public String getCsadCreatedBy() {
		return csadCreatedBy;
	}

	public String getCsadTsEdited() {
		return csadTsEdited;
	}

	public String getCsadDeletedFlg() {
		return csadDeletedFlg;
	}

	public String getCsadEditedBy() {
		return csadEditedBy;
	}

	public String getCsadAddress1() {
		return csadAddress1;
	}

	public String getCsadAddress2() {
		return csadAddress2;
	}

	public String getCsadAddress3() {
		return csadAddress3;
	}

	public String getCsadAddress4() {
		return csadAddress4;
	}

	public String getCsadContactTelNo() {
		return csadContactTelNo;
	}

	public String getCsadContactStd() {
		return csadContactStd;
	}

	public String getCsadContactMobile() {
		return csadContactMobile;
	}

	public String getCsadContactName() {
		return csadContactName;
	}

	public String getCsadName() {
		return csadName;
	}

	public String getCsadPanNo() {
		return csadPanNo;
	}

	public String getCsadDeliveryType() {
		return csadDeliveryType;
	}

	public String getCsadGstNo() {
		return csadGstNo;
	}




	public void setCsadTypeOfAddress(String csadTypeOfAddress) {
		this.csadTypeOfAddress = csadTypeOfAddress;
	}

	public void setCsadAddress(String csadAddress) {
		this.csadAddress = csadAddress;
	}

	public void setCsadCityCode(String csadCityCode) {
		this.csadCityCode = csadCityCode;
	}

	public void setCsadCity(String csadCity) {
		this.csadCity = csadCity;
	}

	public void setCsadPincode(String csadPincode) {
		this.csadPincode = csadPincode;
	}

	public void setCsadStateCode(String csadStateCode) {
		this.csadStateCode = csadStateCode;
	}

	public void setCsadState(String csadState) {
		this.csadState = csadState;
	}

	public void setCsadCountryCode(String csadCountryCode) {
		this.csadCountryCode = csadCountryCode;
	}

	public void setCsadTelNo1(String csadTelNo1) {
		this.csadTelNo1 = csadTelNo1;
	}

	public void setCsadTelNo2(String csadTelNo2) {
		this.csadTelNo2 = csadTelNo2;
	}

	public void setCsadMobileNo(String csadMobileNo) {
		this.csadMobileNo = csadMobileNo;
	}

	public void setCsadEmail1(String csadEmail1) {
		this.csadEmail1 = csadEmail1;
	}

	public void setCsadEmail2(String csadEmail2) {
		this.csadEmail2 = csadEmail2;
	}

	public void setCsadTsCreated(String csadTsCreated) {
		this.csadTsCreated = csadTsCreated;
	}

	public void setCsadCreatedBy(String csadCreatedBy) {
		this.csadCreatedBy = csadCreatedBy;
	}

	public void setCsadTsEdited(String csadTsEdited) {
		this.csadTsEdited = csadTsEdited;
	}

	public void setCsadDeletedFlg(String csadDeletedFlg) {
		this.csadDeletedFlg = csadDeletedFlg;
	}

	public void setCsadEditedBy(String csadEditedBy) {
		this.csadEditedBy = csadEditedBy;
	}

	public void setCsadAddress1(String csadAddress1) {
		this.csadAddress1 = csadAddress1;
	}

	public void setCsadAddress2(String csadAddress2) {
		this.csadAddress2 = csadAddress2;
	}

	public void setCsadAddress3(String csadAddress3) {
		this.csadAddress3 = csadAddress3;
	}

	public void setCsadAddress4(String csadAddress4) {
		this.csadAddress4 = csadAddress4;
	}

	public void setCsadContactTelNo(String csadContactTelNo) {
		this.csadContactTelNo = csadContactTelNo;
	}

	public void setCsadContactStd(String csadContactStd) {
		this.csadContactStd = csadContactStd;
	}

	public void setCsadContactMobile(String csadContactMobile) {
		this.csadContactMobile = csadContactMobile;
	}

	public void setCsadContactName(String csadContactName) {
		this.csadContactName = csadContactName;
	}

	public void setCsadName(String csadName) {
		this.csadName = csadName;
	}

	public void setCsadPanNo(String csadPanNo) {
		this.csadPanNo = csadPanNo;
	}

	public void setCsadDeliveryType(String csadDeliveryType) {
		this.csadDeliveryType = csadDeliveryType;
	}

	public void setCsadGstNo(String csadGstNo) {
		this.csadGstNo = csadGstNo;
	}

	public int getCsadCustSupplrCode() {
		return csadCustSupplrCode;
	}

	public void setCsadCustSupplrCode(int csadCustSupplrCode) {
		this.csadCustSupplrCode = csadCustSupplrCode;
	}

	
	/*
	 * many to one hibernate mapping 
	 * many address can have a single customer.
	 */
//	@ManyToOne(optional = false)
//    @JoinColumn(name="CSAD_CUST_SUPPLR_CODE", insertable=false, updatable=false)
//	private CustomerSupplier customerSupplier;
//
//	public CustomerSupplier getCustomerSupplier() {
//		return customerSupplier;
//	}
//
//	public void setCustomerSupplier(CustomerSupplier customerSupplier) {
//		this.customerSupplier = customerSupplier;
//	}
}
