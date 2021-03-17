package tax;

import tax.TaxDefine.TaxType;
import item.ItemIntf;


public class ServiceTaxCalculator implements TaxCalculatorIntf{
	private static final float ROUNDOFF=0.05f;
	public float calculateTax(ItemIntf item) {
		return roundOffTax(getItemTaxType(item).getApplicableTax() * item.getItemPrice());
	}

	private TaxType getItemTaxType(ItemIntf item) {
		if(item.isItemImported() && !item.isItemExempted()){
			return TaxType.BOTH;
		}else if( item.isItemImported() && item.isItemExempted()){
			return TaxType.IMPORTED;
		}else if( !item.isItemImported() && !item.isItemExempted()){
			return TaxType.BASIC;
		}
		return TaxType.NA;
	}
	private float roundOffTax(float tax){
		return (float) Math.ceil(tax/ROUNDOFF)*ROUNDOFF;
	}

}