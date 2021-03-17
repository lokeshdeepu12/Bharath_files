package module;

import item.Item;
import item.ItemIntf;
import tax.ServiceTaxCalculator;
import tax.TaxCalculatorIntf;

import cart.Cart;
import cart.CartIntf;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

class ShoppingModules extends AbstractModule{

	@Override
	protected void configure() {
		bind(TaxCalculatorIntf.class).to(ServiceTaxCalculator.class).in(Singleton.class);
		bind(ItemIntf.class).to(Item.class);
		bind(CartIntf.class).to(Cart.class);
	}

}