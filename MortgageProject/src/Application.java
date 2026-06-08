package application;

import products.Product;
import shoppingcart.ShoppingCart;

public class Application {

	private static final String TV_PRODUCT_NUMBER = "A123";
	private static final double TV_PRICE = 100.0;
	private static final String TV_DESCRIPTION = "TV";

	private static final String MP3_PLAYER_PRODUCT_NUMBER = "A665";
	private static final double MP3_PLAYER_PRICE = 75.0;
	private static final String MP3_PLAYER_DESCRIPTION = "MP3 Player";

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		Product tv = new Product(TV_PRODUCT_NUMBER, TV_PRICE, TV_DESCRIPTION);
		Product mp3Player = new Product(
				MP3_PLAYER_PRODUCT_NUMBER,
				MP3_PLAYER_PRICE,
				MP3_PLAYER_DESCRIPTION
		);

		cart.addProduct(tv);
		cart.addProduct(mp3Player);
		cart.addProduct(mp3Player);

		cart.printCart();

		cart.removeProduct(mp3Player);
		cart.removeProduct(mp3Player);

		cart.printCart();
	}
}