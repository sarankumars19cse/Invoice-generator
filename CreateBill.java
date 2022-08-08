package applicationErrorCorrection;
import java.util.Scanner;

public class CreateBill {
	int billNo;
	CreateCustomer customer;
	CreateItem[] newItems= new CreateItem[100];
	int condition=1,ni=-1,flag=0,total=0;
	CreateBill(CreateCustomer custom,Scanner scan,CreateItem create[],int i,CreateBill newBill[],int b)
	{
		this.customer=custom;
		this.billNo=b+1;
		int condition = 0;
		do{
			System.out.println("Enter the Item");
			String item = scan.next();
			for(int j=0;j<=i;j++)
			{
				if(item.equals(create[j].ItemName))
				{
					System.out.println("Enter the quntity of the product");
					int quantity = scan.nextInt();
					if(create[j].NoOfItems>quantity){
					for(int k=0;k<=ni;k++)
					{
						if((newItems[k].ItemName).equals(item))
						{
							total -= newItems[k].totalPrice;
							newItems[k].NoOfItems += quantity;
							newItems[k].totalPrice += quantity*newItems[k].price;
							total += newItems[k].totalPrice;
							flag=1;
						}
					}
					if(flag==0){
					newItems[++ni] = new CreateItem(item,create[j].brand,create[j].price,quantity,create[j].price*quantity);
					total += newItems[ni].totalPrice;
					}
					create[j].NoOfItems -= quantity;
					}
					else
					{
						System.out.println("Item Quantity is less than the required quantity");
					}
				}
			}

			System.out.println("Press 0 to add more items");
			condition = scan.nextInt();
		}while(condition==0);
			System.out.println("Customer Name "+customer.customerName);
			System.out.println("Contact number "+customer.contactNumber);
			System.out.println("address "+customer.address);
			for(int k=0;k<=ni;k++)
			{					
				System.out.println("Item name "+this.newItems[k].ItemName);
				System.out.println("Price "+this.newItems[k].price);
				System.out.println("Quantity "+this.newItems[k].NoOfItems);
				System.out.println("Total price for "+this.newItems[k].ItemName+" "+this.newItems[k].totalPrice);
			}
		
	}
}
