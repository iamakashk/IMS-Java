package com.ims.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "itsubgroup")
public class ItemSubGroup {
	public ItemSubGroup() {

	}

	@Id
	@Column(name = "SUB_GROUP_CODE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subGroupCode;

	public int getSubGroupCode() {
		return subGroupCode;
	}

	public void setSubGroupCode(int subGroupCode) {
		this.subGroupCode = subGroupCode;
	}

	@Column(name = "GROUP_CODE")
	private int groupCode;
	@Column(name = "MAIN_GROUP")
	private int mainGroup;
	@Column(name = "MAIN_GROUP_NAME")
	private String mainGroupName;
	@Column(name = "MIN_SALEABLE_LENGTH")
	private int minSaleableLength;

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public int getMainGroup() {
		return mainGroup;
	}

	public void setMainGroup(int mainGroup) {
		this.mainGroup = mainGroup;
	}

	public String getMainGroupName() {
		return mainGroupName;
	}

	public void setMainGroupName(String mainGroupName) {
		this.mainGroupName = mainGroupName;
	}

	public int getMinSaleableLength() {
		return minSaleableLength;
	}

	public void setMinSaleableLength(int minSaleableLength) {
		this.minSaleableLength = minSaleableLength;
	}

	@Override
	public String toString() {
		return "ItemSubGroup [itemCode=" + ", groupCode=" + groupCode + ", mainGroup=" + mainGroup
				+ ", mainGroupName=" + mainGroupName + ", minSaleableLength=" + minSaleableLength + "]";
	}
}
