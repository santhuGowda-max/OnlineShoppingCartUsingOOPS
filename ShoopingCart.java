package OnlineShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ShoopingCart {
  
 private List<Product> produts;
 private List<CartSystem> carts;
 private double totalAmount=0;
 public ShoopingCart() {
	 produts=new ArrayList<>();
	 carts=new ArrayList<>();
 }
 public void  addProduct(Product p) {
	 produts.add(p);
 }
 public void displayProduct() {
	 for(Product product:produts) {
		 System.out.println(product.getId()+". "+product.getProductName()+"(Price:"+product.getProductPrice()+")");
	 }
	
 }
 public void listCartProduct() {
	 int cartItemId=0;
	 double totalCost=0;
	 if(carts.size()>0) {
		 System.out.println("Your Shooping Cart : ");
		 for(CartSystem cartProduct :carts) {
			 cartItemId++;
			 Product product=cartProduct.getCartProduct();
			 System.out.println(cartItemId+". "+product.getProductName()+"("+cartProduct.getCartQuantity()+")"+" - Price: "+product.getProductPrice());
			
			  totalCost+=product.getProductPrice()*cartProduct.getCartQuantity();
			
		 }
		 System.out.println("TotalCost :"+totalCost);
		 totalAmount=totalCost;
	 }else {
		 System.out.println("Your shooping cart is empty");
	 }
 }
 
 public void removeCartItems(String ProductName) {
	 Product product=null;
	 CartSystem RemoveCart=null;
	 if(carts.size()>0) {
	 for(CartSystem cartProducts:carts) {
		 product=cartProducts.getCartProduct();
		 if(product.getProductName().equalsIgnoreCase(ProductName)) {
			 RemoveCart=cartProducts;
			 break;
		 }
	 }
	 if(RemoveCart!=null) {
		 carts.remove(RemoveCart);
		 if(carts.size()>0) {
		 totalAmount-=product.getProductPrice();
		 }
	 }
	 else {
		 System.out.println("Your selected product name not maching your CartList please try again");
	 }
	 
	 }
 }
 
 public void menu() {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Welcome to Online Shopping");
	 System.out.println("Available Products :");
	 displayProduct();
	 
	 boolean isExit=false;
	 while(!isExit) {
		 System.out.print("Enter the item number to add your cart :");
		 int productId=sc.nextInt();
		 Product newProduct=null;
		 int productQuantity=0;
		 for(Product product:produts) {
			 if(product.getId()==productId) {
				 System.out.print("Enter the Quantity :");
				  productQuantity=sc.nextInt();
				 
				  newProduct=product;
//				 carts.add(new CartSystem(product,productQuantity) );
//				
//				 System.out.println();
//				 System.out.println(product.getProductName()+"("+productQuantity+") "+"added to your cart");
//				 System.out.println();
				 break;
			 }
//			 else {
//				 System.out.println("Your Product Currentlly not available");
//			 }
			
		 }
		 if(newProduct!=null) {
			
			 carts.add(new CartSystem(newProduct,productQuantity) );
				
				 System.out.println();
				 System.out.println(newProduct.getProductName()+"("+productQuantity+") "+"added to your cart");
				 System.out.println();
		 }
		 else {
			
			 System.out.println("Your Product Currentlly not available");
			 System.out.println();
		 }
		 sc.nextLine();
		 System.out.print("Do you want to continue shopping?(yes/no): ");
		 String running =sc.nextLine();
		 if(running.equalsIgnoreCase("yes")) {
			 isExit=false;
		 }
		 else {
			 isExit=true;
			
			 boolean removeItem=false;
			 while(!removeItem) {
				 listCartProduct();
				 System.out.println();
			 System.out.print("Do you want to remove any items?(yes/no) ");
			 String CheckRemoveOption=sc.next();
			   if(CheckRemoveOption.equalsIgnoreCase("yes")) {
				   System.out.print("Enter the Product name to remove from your cart :");
					 String productName=sc.next();
					 removeCartItems(productName);
			   }
			   else {
				   removeItem=true;
				   if(carts.size()<=0) {
					   System.out.println("Thank you for shopping with us! Your total amount payable is :"+0);
				   }else
				   {
				   System.out.println("Thank you for shopping with us! Your total amount payable is :"+totalAmount);
				   }
			   }
			 }
		 }
		 
	 }
 }
    
   public static void main(String[] args) {
	   ShoopingCart s=new ShoopingCart();
	  Product p=new Product("T-shirt",400,1);
	  Product p1=new Product("jeans",700,2);
	  Product p2=new Product("Sneakers",250,3);
	  Product p3=new Product("Backpack",450,4);
	  Product p4=new Product("Hat",75,5);
	  s.addProduct(p);
	  s.addProduct(p1);
	  s.addProduct(p2);
	  s.addProduct(p3);
	  s.addProduct(p4);
	 s.menu();
	
	  
	  
   }
    
    
	
}


