package com.ims.beans;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
@Table(name="enquiry_master")
public class EnquiryMasterGet {

	public EnquiryMasterGet() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="em_id")
	private int enquiryId;
	@Column(name="em_ts_created")
	private String enquiryTsCreated;
	@Column(name="em_cust_name")
	private String custName;
	@Column(name="em_cust_email")
	private String custEmail;
	@Column(name="em_cust_contact_person")
	private String contactPerson;
	@Column(name="em_cust_mobile")
	private String tel1;
	@Column(name="em_cust_tele")
	private String tel2;
	@Column(name="em_cust_remark")
	private String remarks;
	@Column(name="em_source_id")
	private int source;
	@Column(name="em_area_id")
	private int area;
	@Column(name="em_deleted_flg")
	private String deletedFlag;
	public int getEnquiryId() {
		return enquiryId;
	}
	public String getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public String getEnquiryTsCreated() {
		return enquiryTsCreated;
	}
	public String getCustName() {
		return custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public String getTel1() {
		return tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public String getRemarks() {
		return remarks;
	}
	public int getSource() {
		return source;
	}
	public int getArea() {
		return area;
	}
	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}
	public void setEnquiryTsCreated(String enquiryTsCreated) {
		this.enquiryTsCreated = enquiryTsCreated;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	//HIBERNATE MAPPING
	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinColumn( name ="en_dtl_enquiry_id")
	@Access(AccessType.PROPERTY)
	private List<EnquiryDetails> enquiryDetails;
	public List<EnquiryDetails> getEnquiryDetails() {
		return enquiryDetails;
	}
	public void setEnquiryDetails(List<EnquiryDetails> enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}
	
}
