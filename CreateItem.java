package applicationErrorCorrection;

public class CreateItem {
	String ItemName;
	String brand;
	int price;
	int NoOfItems;
	int totalPrice=1;
	CreateItem(String ItemName,String brand,int price,int NoOfItems){
		this.ItemName=ItemName;
		this.brand=brand;
		this.price=price;
		this.NoOfItems=NoOfItems;
	}
	CreateItem(String ItemName,String brand,int price,int NoOfItems,int totalPrice)
	{
		this.ItemName=ItemName;
		this.brand=brand;
		this.price=price;
		this.NoOfItems=NoOfItems;
		this.totalPrice=totalPrice;
	}
}
