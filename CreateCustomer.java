package applicationErrorCorrection;

public class CreateCustomer {
	String customerName;
	String contactNumber;
	String address;
	int totalSalesByCustomer=0,k=-1;
	CreateBill[] billRef = new CreateBill[100];
	CreateCustomer(String customerName,String contactNumber,String address)
	{
		this.customerName=customerName;
		this.contactNumber=contactNumber;
		this.address=address;
	}
	public void saveBill(CreateBill bill)
	{
		billRef[++k] = bill;
		totalSalesByCustomer += bill.total;
	}
}