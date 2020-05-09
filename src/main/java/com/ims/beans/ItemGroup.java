package com.ims.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itgroup")
public class ItemGroup {

	public ItemGroup() {

	}

	@Id
	@Column(name = "GROUP_CODE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupCode;
	@Column(name = "GROUP_NAME")
	private String groupName;
	@Column(name = "GROUP_NAME1")
	private String groupName1;
	@Column(name = "GROUP_NAME2")
	private String groupName2;
	@Column(name = "SHORT_NAME")
	private String shortName;
	@Column(name = "MAIN_GROUP_CODE")
	private int mainGroupCode;
	@Column(name = "MAIN_GROUP_NAME")
	private String mainGroupName;
	@Column(name = "PROD_NAME")
	private String prodName;
	@Column(name = "MIN_SALEABLE_LENGTH")
	private int minSaleableLength;
	@Column(name = "MAIN_CATEGORY")
	private int mainCategory;

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName1() {
		return groupName1;
	}

	public void setGroupName1(String groupName1) {
		this.groupName1 = groupName1;
	}

	public String getGroupName2() {
		return groupName2;
	}

	public void setGroupName2(String groupName2) {
		this.groupName2 = groupName2;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getMainGroupCode() {
		return mainGroupCode;
	}

	public void setMainGroupCode(int mainGroupCode) {
		this.mainGroupCode = mainGroupCode;
	}

	public String getMainGroupName() {
		return mainGroupName;
	}

	public void setMainGroupName(String mainGroupName) {
		this.mainGroupName = mainGroupName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getMinSaleableLength() {
		return minSaleableLength;
	}

	public void setMinSaleableLength(int minSaleableLength) {
		this.minSaleableLength = minSaleableLength;
	}

	public int getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(int mainCategory) {
		this.mainCategory = mainCategory;
	}

	@Override
	public String toString() {
		return "ItemGroup [groupCode=" + groupCode + ", groupName=" + groupName + ", groupName1=" + groupName1
				+ ", groupName2=" + groupName2 + ", shortName=" + shortName + ", mainGroupCode=" + mainGroupCode
				+ ", mainGroupName=" + mainGroupName + ", prodName=" + prodName + ", minSaleableLength="
				+ minSaleableLength + ", mainCategory=" + mainCategory + "]";
	}
}
