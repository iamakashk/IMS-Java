package com.ims.dao;

import com.ims.beans.Item;
import com.ims.beans.ItemMaster;

public interface ItemMasterDAO {

	ItemMaster getAllItemsDAO(String logId);

	ItemMaster getSingleItemDAO(String logId, int itemCode);

	ItemMaster updateSingleItemDAO(String logId, Item item);

	ItemMaster deleteSingleItemDAO(String logId, Item item);

	ItemMaster createSingleItemDAO(String logId, Item item);

	ItemMaster itemPaginationDAO(String logId, int limit, int offset);
}
