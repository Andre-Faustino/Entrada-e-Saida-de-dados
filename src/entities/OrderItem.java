package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	private Product pInterno = new Product();
	
  // Produto dentro da Ordem
	
	public OrderItem() {
		
	}

	public OrderItem(String name, Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;
	
		pInterno.setName(name);
		subTotal();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		return this.quantity * this.price;
	}

	@Override
	public String toString() {
		return "" + pInterno.getName() + ", $" + getPrice() + ", Quantity: " + getQuantity()
				+  ", subTotal: $" + subTotal();
	}
	
}
