package com.ims.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * ==============================================================================
 *	Copyright ETP International. All rights reserved.
 *	Licensed material property of ETP Group.
 * ==============================================================================
 * ========================== Change History ====================================
 * ==============================================================================
 * ID   AuthorID  	DtChange   	ModID/IssueID  	 Method Name 					Description	
 * ----------------------------------------------------------------------------
 *                                
 * */
@XmlRootElement(name = "responseBean")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

	@XmlElement(name = "respMsg")
	private String respMsg;

	@XmlElement(name = "respCode")
	private String respCode;

	/**
	 * @return the respMsg
	 */
	public String getRespMsg() {
		return respMsg;
	}

	/**
	 * @param respMsg
	 *            the respMsg to set
	 */

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	/**
	 * @return the respCode
	 */
	public String getRespCode() {
		return respCode;
	}

	/**
	 * @param respCode
	 *            the respCode to set
	 */

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseBean [respMsg=" + respMsg + ", respCode=" + respCode + ", getRespMsg()=" + getRespMsg()
				+ ", getRespCode()=" + getRespCode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
