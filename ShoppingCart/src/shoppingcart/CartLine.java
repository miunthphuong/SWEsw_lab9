package shoppingcart;

import products.Product;

public class CartLine {

	private final Product product;
	private int quantity;

	public CartLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void increaseQuantity() {
		quantity++;
	}

	public void decreaseQuantity() {
		if (quantity > 0) {
			quantity--;
		}
	}

	public boolean hasProduct(Product otherProduct) {
		return product.getProductNumber().equals(otherProduct.getProductNumber());
	}

	public boolean isEmpty() {
		return quantity == 0;
	}

	public double calculateSubtotal() {
		return product.getPrice() * quantity;
	}
}