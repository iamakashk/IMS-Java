package com.ims.dao;

import com.ims.beans.AreaLocation;
import com.ims.beans.FinalResponseBean;
import com.ims.beans.Source;

public interface AreaLocationSourceDAO {

	FinalResponseBean<AreaLocation> addAreaLocationDAO(String logId, AreaLocation areaLocation);
	FinalResponseBean<AreaLocation> getAreaLocationDAO(String logId);
	
	FinalResponseBean<Source> addSourceDAO(String logId, Source source);
	FinalResponseBean<Source> getSourceDAO(String logId);

}
