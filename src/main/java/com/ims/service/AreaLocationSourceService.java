package com.ims.service;

import com.ims.beans.AreaLocation;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Source;

public interface AreaLocationSourceService {

	FinalResponseBean<AreaLocation> addAreaLocationService(String logId, AreaLocation areaLocation);
	FinalResponseBean<AreaLocation> getAreaLocationService(String logId);
	
	FinalResponseBean<Source> addSourceService(String logId, Source source, String actionType);
	FinalResponseBean<Source> getSourceService(String logId);
}
