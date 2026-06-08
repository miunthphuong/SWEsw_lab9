package application;

import products.Product;
import shoppingcart.ShoppingCart;

public class Application {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		Product tv = new Product("A123", 100.0, "TV");
		Product mp3Player = new Product("A665", 75.0, "MP3 Player");

		cart.addProduct(tv);
		cart.addProduct(mp3Player);
		cart.addProduct(mp3Player);

		cart.printCart();

		cart.removeProduct(mp3Player);
		cart.removeProduct(mp3Player);

		cart.printCart();
	}
}