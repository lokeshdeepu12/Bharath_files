package cart;

import item.ItemIntf;

public interface CartIntf {
	public void addItemToCart(ItemIntf item);
	public void calculateAndPrintReceiptWithTax();
	public float getTotalCost() ;
	public float getSalesTax() ;
}