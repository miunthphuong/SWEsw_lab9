package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import products.Product;

public class ShoppingCart {

	private final List<CartLine> cartLines = new ArrayList<>();

	public void addProduct(Product product) {
		validateProduct(product);

		Optional<CartLine> existingCartLine = findCartLine(product);

		if (existingCartLine.isPresent()) {
			existingCartLine.get().increaseQuantity();
			return;
		}

		cartLines.add(new CartLine(product, 1));
	}

	public void removeProduct(Product product) {
		validateProduct(product);

		Iterator<CartLine> iterator = cartLines.iterator();

		while (iterator.hasNext()) {
			CartLine cartLine = iterator.next();

			if (cartLine.contains(product)) {
				cartLine.decreaseQuantity();

				if (cartLine.hasNoItems()) {
					iterator.remove();
				}

				return;
			}
		}
	}

	public void printCart() {
		System.out.println("Content of the shopping cart:");

		for (CartLine cartLine : cartLines) {
			System.out.println(cartLine);
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

	public boolean isEmpty() {
		return cartLines.isEmpty();
	}

	public int getNumberOfProductTypes() {
		return cartLines.size();
	}

	private Optional<CartLine> findCartLine(Product product) {
		for (CartLine cartLine : cartLines) {
			if (cartLine.contains(product)) {
				return Optional.of(cartLine);
			}
		}

		return Optional.empty();
	}

	private void validateProduct(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Product is required.");
		}
	}
}