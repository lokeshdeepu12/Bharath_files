import item.Item;
import item.ItemIntf;
import item.ItemDefine.ItemType;

import java.util.Scanner;

import module.InjectorFactory;

import cart.Cart;
import cart.CartIntf;

/**
 * command line Test programme
 * @author vinod
 *
 */
public class Main {

	enum ItemTypeList{
		BOOK("Book"),
		MUSIC_CD("Music CD"),
		CHOCOLATE("Chocolate"),
		PERFUME("Perfume"),
		PILLS("Headache Pills");
		private String itemName;
		private ItemTypeList( String name){
			itemName = name;
		}

		public String getItemName(){
			return itemName;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ItemTypeList list[] = ItemTypeList.values();
		StringBuilder buffer  = new StringBuilder();
		int count=1;
		for(ItemTypeList item : list){
			buffer.append(count++).append(" :").append(item.getItemName()+"\n");
		}
		String productList = "Select Item : \n"+buffer.toString();
        ItemType[] itemTypes = ItemType.values();

        buffer.delete(0, buffer.length());
		for(ItemType itemType : itemTypes){
			buffer.append(itemType.ordinal()).append(" :").append(itemType.name()+"\n");
		}
		String itemTypeList ="Item type: "+buffer;

		CartIntf cart = InjectorFactory.getInjector().getInstance(CartIntf.class);
		while(true){
			System.out.println(productList);
			int product = input.nextInt();
			if(product == 0 ){
				break;
			}
			ItemIntf item = InjectorFactory.getInjector().getInstance(ItemIntf.class);
			item.setItemDescription(list[product-1].getItemName());
			System.out.println("Price: ");
            item.setItemPrice(input.nextFloat());
            System.out.println(itemTypeList);
            item.setItemType(itemTypes[input.nextInt()]);

			cart.addItemToCart(item);

		}

		cart.calculateAndPrintReceiptWithTax();
	}
}