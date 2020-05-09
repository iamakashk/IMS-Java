package com.ims.service;

import com.ims.beans.Item;
import com.ims.beans.ItemMaster;

public interface ItemMasterService {

	ItemMaster getAllItemsService(String logId);
	ItemMaster getSingleItemService(String logId, int itemCode);
	ItemMaster updateSingleItemService(String logId, Item item);
	ItemMaster deleteSingleItemService(String logId, Item item);
	ItemMaster createSingleItemService(String logId, Item item);
	ItemMaster itemPaginationService(String logId, int limit, int offset);
	
	
}
