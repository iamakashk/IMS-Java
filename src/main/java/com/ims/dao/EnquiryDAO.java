package com.ims.dao;

import com.ims.beans.EnquiryMaster;
import com.ims.beans.FinalResponseBean;

public interface EnquiryDAO {

	FinalResponseBean<EnquiryMaster> addEnquiry(String logId, EnquiryMaster enquiry, String actionType);
	FinalResponseBean<EnquiryMaster> getEnquiry(String logId);
}
