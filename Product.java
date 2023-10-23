package OnlineShoppingCart;

public class Product {

	private String productName;
	private double productPrice;
	private int id;
   
	
	public Product(String productName,double productPrice,int id){
		this.productName=productName;
		this.productPrice=productPrice;
		this.id=id;
		
		
	}
	
//	public int getProductItemCount() {
//		return productItemCount;
//	}


	public String getProductName() {
		return productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public int getId() {
		return id;
	}
	
	
	
	
	
	
	
}


