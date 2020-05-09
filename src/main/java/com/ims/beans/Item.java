package com.ims.beans;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "item")
public class Item {

	public Item() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IT_ITEM_CODE")
	private int itItemCode;
	@Column(name = "IT_PROD_CODE")
	private String itProdCode;
	@Column(name = "IT_TECH_DESC")
	private String itTechDesc;
	@Column(name = "IT_ACTIVE_FLG")
	private String itActiveFlag;
	@Column(name = "IT_DELETED_FLG")
	private String itDeletedFlag;
	@Column(name = "IT_TS_CREATED")
	private Date itTsCreated;
	@Column(name = "IT_CREATED_BY")
	private String itCreatedBy;
	@Column(name = "IT_TS_EDITED")
	private Date itTsEdited;
	@Column(name = "IT_EDITED_BY")
	private String itTsEditedBy;
	@Column(name = "IT_ITEM_NAME")
	private String itItemName;

	@Column(name = "IT_GROUP_CODE")
	private int itGroupCode;
	@Column(name = "IT_TARIFF_CODE")
	private String itTariffCode;

	@Column(name = "IT_SUB_GROUP_CODE")
	private int itSubGroupCode;

	@Column(name = "IT_1_DAY_RATE")
	private int itRate1Day;
	@Column(name = "IT_2_DAY_RATE")
	private int itRate2Days;
	@Column(name = "IT_3_DAYS_RATE")
	private int itRate3Days;
	@Column(name = "IT_1_WEEK_RATE")
	private int itRate1Week;
	@Column(name = "IT_15_DAYS_RATE")
	private int itRate15Days;
	@Column(name = "IT_1_MONTH_RATE")
	private int itRate1Month;
	@Column(name = "IT_3_MONTHS_RATE")
	private int itRate3Months;
	@Column(name = "IT_6_MONTHS_RATE")
	private int itRate6Months;
	@Column(name = "IT_9_MONTHS_RATE")
	private int itRate9Months;
	@Column(name = "IT_12_MONTHS_RATE")
	private int itRate12Months;

	@Override
	public String toString() {
		return "Item [itItemCode=" + itItemCode + ", itProdCode=" + itProdCode + ", itTechDesc=" + itTechDesc
				+ ", itActiveFlag=" + itActiveFlag + ", itDeletedFlag=" + itDeletedFlag + ", itTsCreated=" + itTsCreated
				+ ", itCreatedBy=" + itCreatedBy + ", itTsEdited=" + itTsEdited + ", itTsEditedBy=" + itTsEditedBy
				+ ", itItemName=" + itItemName + ", itGroupCode=" + itGroupCode + ", itTariffCode=" + itTariffCode
				+ ", itSubGroupCode=" + itSubGroupCode + "]";
	}

	public int getItItemCode() {
		return itItemCode;
	}

	public void setItItemCode(int itItemCode) {
		this.itItemCode = itItemCode;
	}

	public String getItProdCode() {
		return itProdCode;
	}

	public void setItProdCode(String itProdCode) {
		this.itProdCode = itProdCode;
	}

	public String getItTechDesc() {
		return itTechDesc;
	}

	public void setItTechDesc(String itTechDesc) {
		this.itTechDesc = itTechDesc;
	}

	public String getItActiveFlag() {
		return itActiveFlag;
	}

	public void setItActiveFlag(String itActiveFlag) {
		this.itActiveFlag = itActiveFlag;
	}

	public String getItDeletedFlag() {
		return itDeletedFlag;
	}

	public void setItDeletedFlag(String itDeletedFlag) {
		this.itDeletedFlag = itDeletedFlag;
	}

	public Date getItTsCreated() {
		return itTsCreated;
	}

	public void setItTsCreated(Date itTsCreated) {
		this.itTsCreated = itTsCreated;
	}

	public String getItCreatedBy() {
		return itCreatedBy;
	}

	public void setItCreatedBy(String itCreatedBy) {
		this.itCreatedBy = itCreatedBy;
	}

	public Date getItTsEdited() {
		return itTsEdited;
	}

	public void setItTsEdited(Date itTsEdited) {
		this.itTsEdited = itTsEdited;
	}

	public String getItTsEditedBy() {
		return itTsEditedBy;
	}

	public void setItTsEditedBy(String itTsEditedBy) {
		this.itTsEditedBy = itTsEditedBy;
	}

	public String getItItemName() {
		return itItemName;
	}

	public void setItItemName(String itItemName) {
		this.itItemName = itItemName;
	}

	public int getItGroupCode() {
		return itGroupCode;
	}

	public void setItGroupCode(int itGroupCode) {
		this.itGroupCode = itGroupCode;
	}

	public String getItTariffCode() {
		return itTariffCode;
	}

	public void setItTariffCode(String itTariffCode) {
		this.itTariffCode = itTariffCode;
	}

	public int getItSubGroupCode() {
		return itSubGroupCode;
	}

	public void setItSubGroupCode(int itSubGroupCode) {
		this.itSubGroupCode = itSubGroupCode;
	}

	public int getItRate1Day() {
		return itRate1Day;
	}

	public void setItRate1Day(int itRate1Day) {
		this.itRate1Day = itRate1Day;
	}

	public int getItRate2Days() {
		return itRate2Days;
	}

	public void setItRate2Days(int itRate2Days) {
		this.itRate2Days = itRate2Days;
	}

	public int getItRate3Days() {
		return itRate3Days;
	}

	public void setItRate3Days(int itRate3Days) {
		this.itRate3Days = itRate3Days;
	}

	public int getItRate1Week() {
		return itRate1Week;
	}

	public void setItRate1Week(int itRate1Week) {
		this.itRate1Week = itRate1Week;
	}

	public int getItRate15Days() {
		return itRate15Days;
	}

	public void setItRate15Days(int itRate15Days) {
		this.itRate15Days = itRate15Days;
	}

	public int getItRate1Month() {
		return itRate1Month;
	}

	public void setItRate1Month(int itRate1Month) {
		this.itRate1Month = itRate1Month;
	}

	public int getItRate3Months() {
		return itRate3Months;
	}

	public void setItRate3Months(int itRate3Months) {
		this.itRate3Months = itRate3Months;
	}

	public int getItRate6Months() {
		return itRate6Months;
	}

	public void setItRate6Months(int itRate6Months) {
		this.itRate6Months = itRate6Months;
	}

	public int getItRate9Months() {
		return itRate9Months;
	}

	public void setItRate9Months(int itRate9Months) {
		this.itRate9Months = itRate9Months;
	}

	public int getItRate12Months() {
		return itRate12Months;
	}

	public void setItRate12Months(int itRate12Months) {
		this.itRate12Months = itRate12Months;
	}

}
