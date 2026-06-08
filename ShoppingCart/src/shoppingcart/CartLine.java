package shoppingcart;

import products.Product;

public class CartLine {

	private final Product product;
	private int quantity;

	public CartLine(Product product, int quantity) {
		if (product == null) {
			throw new IllegalArgumentException("Product is required.");
		}

		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be greater than zero.");
		}

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
		quantity--;
	}

	public boolean contains(Product otherProduct) {
		return product.equals(otherProduct);
	}

	public boolean hasNoItems() {
		return quantity == 0;
	}

	public double calculateSubtotal() {
		return product.getPrice() * quantity;
	}

	@Override
	public String toString() {
		return quantity + " " + product;
	}
}