package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import products.Product;

public class ShoppingCart {

	private final List<CartLine> cartLines = new ArrayList<>();

	public void addProduct(Product product) {
		CartLine existingCartLine = findCartLineByProduct(product);

		if (existingCartLine != null) {
			existingCartLine.increaseQuantity();
			return;
		}

		cartLines.add(new CartLine(product, 1));
	}

	public void removeProduct(Product product) {
		Iterator<CartLine> iterator = cartLines.iterator();

		while (iterator.hasNext()) {
			CartLine cartLine = iterator.next();

			if (cartLine.hasProduct(product)) {
				cartLine.decreaseQuantity();

				if (cartLine.isEmpty()) {
					iterator.remove();
				}

				return;
			}
		}
	}

	public void printCart() {
		System.out.println("Content of the shopping cart:");

		for (CartLine cartLine : cartLines) {
			printCartLine(cartLine);
		}

		System.out.println("Total price = " + calculateTotalPrice());
	}

	public double calculateTotalPrice() {
		double totalPrice = 0.0;

		for (CartLine cartLine : cartLines) {
			totalPrice += cartLine.calculateSubtotal();
		}

		return totalPrice;
	}

	private CartLine findCartLineByProduct(Product product) {
		for (CartLine cartLine : cartLines) {
			if (cartLine.hasProduct(product)) {
				return cartLine;
			}
		}

		return null;
	}

	private void printCartLine(CartLine cartLine) {
		Product product = cartLine.getProduct();

		System.out.println(
				cartLine.getQuantity() + " "
						+ product.getProductNumber() + " "
						+ product.getDescription() + " "
						+ product.getPrice()
		);
	}
}