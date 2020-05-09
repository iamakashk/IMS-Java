package com.ims.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cust_supplr")
public class CustomerSupplier implements Serializable {

	public CustomerSupplier() {

	}

	private static final long serialVersionUID = 442860916208417698L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CS_CUST_SUPPLR_CODE")
	private int csCustSupplrCode;

	public void setCsCustSupplrCode(int csCustSupplrCode) {
		this.csCustSupplrCode = csCustSupplrCode;
	}

	@Column(name = "CS_NAME")
	private String csName;
	@Column(name = "CS_CUST_OF")
	private String csCustOf;
	@Column(name = "CS_CUST_SUPPLR_FLG")
	private String csCustSupplFlg;
	@Column(name = "CS_TYPE")
	private String csType;
	@Column(name = "CS_FILE_NO")
	private String csFileNo;
	@Column(name = "CS_CREATED_BY")
	private String csCreatedBy;
	@Column(name = "CS_TS_EDITED")
	private Date csTsEdited;
	@Column(name = "CS_DELETED_FLG")
	private String csDeletedFlg;
	@Column(name = "CS_EDITED_BY")
	private String csEditedBy;
	@Column(name = "CS_ACC_CODE")
	private String csAccCode;
	@Column(name = "CS_ACCOUNT_NO")
	private String csAccountNo;
	@Column(name = "CS_PAN_NO")
	private String csPanNo;

	@Column(name = "CS_REMARK")
	private String csRemark;
	@Column(name = "CS_CUST_FLG")
	private String csCustFlg;
	@Column(name = "CS_AADHAR_NO")
	private String csAadharNo;
	@Column(name = "CS_AREA_LOCATION")
	private Integer csAreaLocation;
	@Column(name = "CS_SOURCE")
	private Integer csSource;
	@Column(name = "CS_CONTACT_PERSON1")
	private String csContactPerson1;
	@Column(name = "CS_TEL_NO1")
	private String csTelNo1;
	@Column(name = "CS_CONTACT_PERSON2")
	private String csContactPerson2;
	@Column(name = "CS_TEL_NO2")
	private String csTelNo2;
	@Column(name = "CS_TEL_NO3")
	private String csTelNo3;
	@Column(name = "CS_GST_NO")
	private String csGstNo;
	@Column(name = "CS_BLACKLISTED")
	private String csBlacklisted;

	@Column(name = "CS_EMAILID")
	private String csEmailId;

	public String getCsEmailId() {
		return csEmailId;
	}

	public void setCsEmailId(String csEmailId) {
		this.csEmailId = csEmailId;
	}

	/*
	 * ADDING HIBERNATE MAPPINGS ONE CUSTOMER CAN HAVE MULTIPLE ADDRESS
	 */
//	@OneToMany( fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//	@JoinColumn(name="CSAD_CUST_SUPPLR_CODE")
	@Transient
	private List<CustomerAddress> customerAddress;

	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCsName() {
		return csName;
	}

	public String getCsCustOf() {
		return csCustOf;
	}

	public String getCsCustSupplFlg() {
		return csCustSupplFlg;
	}

	public String getCsType() {
		return csType;
	}

	public String getCsFileNo() {
		return csFileNo;
	}

	public String getCsCreatedBy() {
		return csCreatedBy;
	}

	public Date getCsTsEdited() {
		return csTsEdited;
	}

	public String getCsDeletedFlg() {
		return csDeletedFlg;
	}

	public String getCsEditedBy() {
		return csEditedBy;
	}

	public String getCsAccCode() {
		return csAccCode;
	}

	public String getCsAccountNo() {
		return csAccountNo;
	}

	public String getCsPanNo() {
		return csPanNo;
	}

	public String getCsRemark() {
		return csRemark;
	}

	public String getCsCustFlg() {
		return csCustFlg;
	}

	public String getCsAadharNo() {
		return csAadharNo;
	}

	public int getCsCustSupplrCode() {
		return csCustSupplrCode;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public void setCsCustOf(String csCustOf) {
		this.csCustOf = csCustOf;
	}

	public void setCsCustSupplFlg(String csCustSupplFlg) {
		this.csCustSupplFlg = csCustSupplFlg;
	}

	public void setCsType(String csType) {
		this.csType = csType;
	}

	public void setCsFileNo(String csFileNo) {
		this.csFileNo = csFileNo;
	}

	public void setCsCreatedBy(String csCreatedBy) {
		this.csCreatedBy = csCreatedBy;
	}

	public void setCsTsEdited(Date csTsEdited) {
		this.csTsEdited = csTsEdited;
	}

	public void setCsDeletedFlg(String csDeletedFlg) {
		this.csDeletedFlg = csDeletedFlg;
	}

	public void setCsEditedBy(String csEditedBy) {
		this.csEditedBy = csEditedBy;
	}

	public void setCsAccCode(String csAccCode) {
		this.csAccCode = csAccCode;
	}

	public void setCsAccountNo(String csAccountNo) {
		this.csAccountNo = csAccountNo;
	}

	public void setCsPanNo(String csPanNo) {
		this.csPanNo = csPanNo;
	}

	public void setCsRemark(String csRemark) {
		this.csRemark = csRemark;
	}

	public void setCsCustFlg(String csCustFlg) {
		this.csCustFlg = csCustFlg;
	}

	public void setCsAadharNo(String csAadharNo) {
		this.csAadharNo = csAadharNo;
	}

	public Integer getCsAreaLocation() {
		return csAreaLocation;
	}

	public Integer getCsSource() {
		return csSource;
	}

	public String getCsContactPerson1() {
		return csContactPerson1;
	}

	public String getCsTelNo1() {
		return csTelNo1;
	}

	public String getCsContactPerson2() {
		return csContactPerson2;
	}

	public String getCsTelNo2() {
		return csTelNo2;
	}

	public String getCsTelNo3() {
		return csTelNo3;
	}

	public String getCsGstNo() {
		return csGstNo;
	}

	public String getCsBlacklisted() {
		return csBlacklisted;
	}

	public void setCsAreaLocation(Integer csAreaLocation) {
		this.csAreaLocation = csAreaLocation;
	}

	public void setCsSource(Integer csSource) {
		this.csSource = csSource;
	}

	public void setCsContactPerson1(String csContactPerson1) {
		this.csContactPerson1 = csContactPerson1;
	}

	public void setCsTelNo1(String csTelNo1) {
		this.csTelNo1 = csTelNo1;
	}

	public void setCsContactPerson2(String csContactPerson2) {
		this.csContactPerson2 = csContactPerson2;
	}

	public void setCsTelNo2(String csTelNo2) {
		this.csTelNo2 = csTelNo2;
	}

	public void setCsTelNo3(String csTelNo3) {
		this.csTelNo3 = csTelNo3;
	}

	public void setCsGstNo(String csGstNo) {
		this.csGstNo = csGstNo;
	}

	public void setCsBlacklisted(String csBlacklisted) {
		this.csBlacklisted = csBlacklisted;
	}

}
