package com.ims.service;

import com.ims.beans.EnquiryMaster;
import com.ims.beans.FinalResponseBean;

public interface EnquiryService {

	FinalResponseBean<EnquiryMaster> addEnquiry(String logId, EnquiryMaster enquiry, String actionType);
	FinalResponseBean<EnquiryMaster> getEnquiry(String logId);
}
