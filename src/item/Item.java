

package item;
import com.google.inject.Inject;

import item.ItemDefine.ItemType;
import tax.TaxCalculatorIntf;


public class Item implements ItemIntf {
	protected float itemPrice;
	private String name;
	private ItemType itemType;

	
	private TaxCalculatorIntf CALCULATOR ;

	@Override
	public String getItemDescription() {
		return name;
	}

	@Override
	public void setItemDescription(String itemName){
		name = itemName;
	}

	@Override
	public float getItemPrice() {
		return itemPrice;
	}

	@Override
	public void setItemPrice(float price) {
		itemPrice = price;

	}

	@Override
	public void setItemType(ItemType type) {
		itemType = type;
	}

	@Override
	public boolean isItemImported() {
		return itemType.isImported();
	}

	@Override
	public boolean isItemExempted() {
		return itemType.isExempted();
	}

	@Override
	public float getItemPriceWithTax() {
		return getItemSaleTax()+getItemPrice();
	}

	@Override
	public float getItemSaleTax() {
		return (CALCULATOR.calculateTax(this));
	}

	@Override
	public String toString(){
		return 1+ " "+name+" :" +getItemPriceWithTax();
	}
}
