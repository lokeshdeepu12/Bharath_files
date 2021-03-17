package cart;

import item.ItemIntf;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class Cart implements CartIntf{

	private List<ItemIntf> itemList;
	private float saleTax;
	private float totalCost;
	private static final Format FORMATTER = new DecimalFormat("0.00");

	public Cart() {
		itemList = new ArrayList<ItemIntf>();
	}

	@Override
	public void addItemToCart(ItemIntf item) {
		itemList.add(item);
	}

	@Override
	public void calculateAndPrintReceiptWithTax() {
		resetCart();
		StringBuilder buffer = new StringBuilder();
		for (ItemIntf item : itemList) {
			buffer.append("\n").append(item.toString());
			totalCost += item.getItemPriceWithTax();
			saleTax += item.getItemSaleTax();
		}
		buffer.append("\nSales Tax:" + FORMATTER.format(saleTax));
		buffer.append("\nTotal :" + totalCost);
		System.out.println(buffer.toString());
	}

	private void resetCart() {
		totalCost = 0.0f;
		saleTax = 0.0f;
	}

	@Override
	public float getTotalCost() {
		return totalCost;
	}

	@Override
	public float getSalesTax() {
		return Float.valueOf(FORMATTER.format(saleTax));
	}

	public String toString(){
		StringBuilder buffer = new StringBuilder();
		for (ItemIntf item : itemList) {
			buffer.append("\n").append(item.toString());
		}
		return buffer.toString();
	}

}