package com.ims.dao;

import com.ims.beans.CustomerSupplier;
import com.ims.beans.FinalResponseBean;

public interface CustomerMasterDAO {
	FinalResponseBean<CustomerSupplier> addCustomer(String logId, CustomerSupplier customerSupplier);
	FinalResponseBean<CustomerSupplier> getCustomer(String logId, int custCode);
	FinalResponseBean<CustomerSupplier> getAllCustomers(String logId);
	FinalResponseBean<CustomerSupplier> deleteCustomer(String logId, CustomerSupplier customerSupplier);
	FinalResponseBean<CustomerSupplier> updateCustomer(String logId, CustomerSupplier customerSupplier);
}
