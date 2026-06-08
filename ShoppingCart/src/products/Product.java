package products;

public class Product {

	private final String productNumber;
	private final double price;
	private final String description;

	public Product(String productNumber, double price, String description) {
		this.productNumber = productNumber;
		this.price = price;
		this.description = description;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
}