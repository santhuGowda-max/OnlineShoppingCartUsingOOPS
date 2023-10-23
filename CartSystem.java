package OnlineShoppingCart;

public class CartSystem {
	private Product CartProduct;
	private int quantity;
   
	
	public CartSystem(Product CartProduct,int quantity){
		this.CartProduct=CartProduct;
		this.quantity=quantity;
		
		
	}


	
	public int getCartQuantity() {
		return quantity;
	}
	public Product getCartProduct() {
		return CartProduct;
	}
} 
