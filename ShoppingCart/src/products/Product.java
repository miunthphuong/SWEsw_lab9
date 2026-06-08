package products;

import java.util.Objects;

public class Product {

	private final String productNumber;
	private final double price;
	private final String description;

	public Product(String productNumber, double price, String description) {
		if (productNumber == null || productNumber.isBlank()) {
			throw new IllegalArgumentException("Product number is required.");
		}

		if (description == null || description.isBlank()) {
			throw new IllegalArgumentException("Product description is required.");
		}

		if (price < 0) {
			throw new IllegalArgumentException("Product price cannot be negative.");
		}

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Product)) {
			return false;
		}

		Product otherProduct = (Product) object;
		return productNumber.equals(otherProduct.productNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productNumber);
	}

	@Override
	public String toString() {
		return productNumber + " " + description + " " + price;
	}
}