package item;

import item.ItemDefine.ItemType;


public interface ItemIntf {

	String getItemDescription();
	void setItemDescription(String description);
	float getItemPrice();
	void setItemPrice(float price);
	void setItemType(ItemType itemType);

	boolean isItemImported();
	boolean isItemExempted();

	float getItemPriceWithTax();
	float getItemSaleTax();
}
