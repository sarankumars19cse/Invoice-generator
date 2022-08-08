package applicationErrorCorrection;

import java.util.*;

public class Home {
	public static Boolean CheckItem(CreateItem create[],String ItemName,int i)		//return true if the item already exist
	{
		for(int j=0;j<=i;j++)
		{
			if(create[j].ItemName.equals(ItemName))
			{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int condition=1;
		int i=-1,c=-1,b=-1;
		CreateItem create[]=new CreateItem[100];		
		CreateCustomer[] newCustomer = new CreateCustomer[100];
		CreateBill[] newBill = new CreateBill[100];
		do{
			System.out.println("Enter the option to perform");
			System.out.println("1 -> Create and add Item \n2 -> Create New Customer \n3 -> Create Bill \n4 -> List of Items in Shop \n5 -> List of Customer Profile \n6 -> List of Bills\n7 -> Bill Based on customer name\n8 -> Total Sales Amount by customer\n9 -> Bill Details By Bill Number");
			int option = scan.nextInt();
			switch(option)
			{
				case 1:			//Adding an item to the list
					System.out.println("Enter the Item Name");
					String ItemName = scan.next();
					System.out.println("Enter the Number Of items to add");
					int Items = scan.nextInt();
					if(!CheckItem(create,ItemName,i))		//if the item already exist increase the count
					{
						System.out.println("Enter the Brand");
						String brand = scan.next();
						System.out.println("Enter the price");
						int price  = scan.nextInt();
						create[++i] = new CreateItem(ItemName,brand,price,Items);
					}
					else{
						for(int j=0;j<=i;j++)
						{
							if(create[j].ItemName.equals(ItemName))
							{
								create[j].NoOfItems += Items;
							}
						}
					}
					for(int j=0;j<=i;j++)		//printing the added item
					{
						System.out.println("----------------------------");
						System.out.println();
						System.out.println("Item Name  "+create[j].ItemName);
						System.out.println("Brand  "+create[j].brand);
						System.out.println("Price  "+create[j].price);
						System.out.println("Total No. of "+create[j].ItemName+"s "+create[j].NoOfItems);
						System.out.println();
						System.out.println("----------------------------");
					}
					break;
				case 2:			//creating customer profile
					System.out.println("Enter the Customer Name");
					String customerName = scan.next();
					System.out.println("Enter the contact number of the customer");
					String contactNumber = scan.next();
					System.out.println("Enter the Address");
					String address = scan.next();
					newCustomer[++c] = new CreateCustomer(customerName,contactNumber,address);
					for(int j=0;j<=c;j++)
					{
						System.out.println("----------------------------");
						System.out.println();
						System.out.println("Customer Name  "+newCustomer[j].customerName);
						System.out.println("Contact number  "+newCustomer[j].contactNumber);
						System.out.println("Address  "+newCustomer[j].address);
						System.out.println("totalSalesByCustomer  "+newCustomer[j].totalSalesByCustomer);
						System.out.println();
						System.out.println("----------------------------");
					}
					break;
				case 3:		//creating bill
					System.out.println("Enter the contact Number");
					String number = scan.next();
					int flag=0;
					for(int j=0;j<=c;j++)
					{
						if(number.equals(newCustomer[j].contactNumber))//checking the entered contact number 
						{										//with the customer details contact number
							System.out.println("----------------------------");
							System.out.println();
							System.out.println("Customer Name  "+newCustomer[j].customerName);
							System.out.println("Contact number  "+newCustomer[j].contactNumber);
							System.out.println("Address  "+newCustomer[j].address);
							System.out.println();
							System.out.println("----------------------------");
							newBill[b+1] = new CreateBill(newCustomer[j],scan,create,i,newBill,b+1);
							newCustomer[j].saveBill(newBill[b+1]);		//creating a bill
							++b;
							flag=1;
							break;
						}
					}
					if(flag==0)
					{
						System.out.println("You are new to our Shop so please create new customer profile!!!");
					}
					break;
				case 4:			//list the items in the shop
					for(int j=0;j<=i;j++)
					{
						System.out.println("----------------------------");
						System.out.println();
						System.out.println("Item Name  "+create[j].ItemName);
						System.out.println("Brand  "+create[j].brand);
						System.out.println("Price  "+create[j].price);
						System.out.println("No of "+create[j].ItemName+"s  "+create[j].NoOfItems);
						System.out.println();
						System.out.println("----------------------------");
					}
					break;
				case 5:		//list the customer profile 
					for(int j=0;j<=c;j++)
					{
						System.out.println("----------------------------");
						System.out.println();
						System.out.println("Customer Name  "+newCustomer[j].customerName);
						System.out.println("Contact number  "+newCustomer[j].contactNumber);
						System.out.println("Address	 "+newCustomer[j].address);
						System.out.println();
						System.out.println("----------------------------");
					}
					break;
				case 6:		//list the bills
					for(int j=0;j<=b;j++)
					{
						System.out.println("----------------------------");
						System.out.println();
						System.out.println("Customer Name  "+newBill[j].customer.customerName);
						System.out.println("Contact number  "+newBill[j].customer.contactNumber);
						System.out.println("Address  "+newBill[j].customer.address);
						for(int k=0;k<=newBill[j].ni;k++)
						{			
							System.out.println();		
							System.out.println("Item name  "+newBill[j].newItems[k].ItemName);
							System.out.println("Price  "+newBill[j].newItems[k].price);
							System.out.println("Quantity  "+newBill[j].newItems[k].NoOfItems);
							System.out.println("price for "+newBill[j].newItems[k].ItemName+"  "+newBill[j].newItems[k].totalPrice);
							System.out.println();
						}
						System.out.println("Total  "+newBill[j].total);
						System.out.println();
						System.out.println("----------------------------");
					}
					break;
				case 7:		//display bills based on the customer name
					System.out.println("Enter the Customer name to get Bill");
					String name = scan.next();
					for(int j=0;j<=c;j++)
					{
						if(newCustomer[j].customerName.equals(name)){
							System.out.println("----------------------------");
							System.out.println();
							System.out.println("Customer Name  "+newCustomer[j].customerName);
							System.out.println("Contact number  "+newCustomer[j].contactNumber);
							System.out.println("Address		"+newCustomer[j].address);
							for(int k=0;k<=newCustomer[j].k;k++)
							{	
								for(int l=0;l<=newCustomer[j].billRef[k].ni;l++){
									System.out.println();
									System.out.println("Item name  "+newCustomer[j].billRef[k].newItems[l].ItemName);
									System.out.println("Price  "+newCustomer[j].billRef[k].newItems[l].price);
									System.out.println("Quantity  "+newCustomer[j].billRef[k].newItems[l].NoOfItems);
									System.out.println("price for  "+newCustomer[j].billRef[k].newItems[l].ItemName+" "+newCustomer[j].billRef[k].newItems[l].totalPrice);
									System.out.println();
								}
								System.out.println("Total  "+newCustomer[j].billRef[j].total);
								System.out.println();
							}
							System.out.println();
							System.out.println("----------------------------");
						}
					}
					break;
				case 8:			//Total amount of sales by the individual customer
					for(int j=0;j<=c;j++)
					{
						System.out.println("----------------------------");
						System.out.println();
						System.out.println("Customer Name  "+newCustomer[j].customerName);
						System.out.println("totalSalesByCustomer  "+newCustomer[j].totalSalesByCustomer);
						System.out.println();
						System.out.println("----------------------------");
					}
					break;	
				case 9:
					System.out.println("Enter the Bill No..");
					int billno = scan.nextInt();
					for(int j=0;j<=b;j++)
					{
						if(newBill[j].billNo==billno)
						{
							System.out.println();
							System.out.println("----------------------------");
							System.out.println("Bill No.  "+newBill[j].billNo);
							System.out.println("Customer Name  "+newBill[j].customer.customerName);
							System.out.println("Contact number  "+newBill[j].customer.contactNumber);
							System.out.println("Address  "+newBill[j].customer.address);
							for(int k=0;k<=newBill[j].ni;k++)
							{	
								System.out.println();
								System.out.println("Item Name  "+newBill[j].newItems[k].ItemName);
								System.out.println("Price per Item  "+newBill[j].newItems[k].price);
								System.out.println("Quantity  "+newBill[j].newItems[k].NoOfItems);
								System.out.println("Price    "+newBill[j].newItems[k].totalPrice);
								System.out.println();
							}
							System.out.println();
							System.out.println("----------------------------");
						}
					}
					break;
				default:
					System.out.println("Enter the valid number 1-9");
			}
			System.out.println("Press 0 to continue");
			condition = scan.nextInt();
		}while(condition == 0);
	}
}
