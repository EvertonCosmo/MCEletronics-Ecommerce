package mceletronics.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)


public class Product {
	private int id;
	private String name;
	private String category;
	private Double price;
	private Integer quantity;
	private String description;

	public Product() {}
	public Product(int id, String name, String category, Double price, Integer quantity,String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}
	
//	public Product(int id, String name, String categorie, Double price, Integer quantity,String color) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.categorie = categorie;
//		this.price = price;
//		this.quantity = quantity;
//		this.color = color;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", quantity="
				+ quantity + ", description=" + description + "]";
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	

	
	
	
}
