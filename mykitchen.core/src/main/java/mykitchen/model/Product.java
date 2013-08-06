package mykitchen.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "products")
@XmlRootElement
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4385839955831867587L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToOne
	private ProductCategory category;

	private String description;

	public Product() {
		this(0L, null, new ProductCategory(), null);
	}

	public Product(Long id, String name, ProductCategory category,
			String description) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("{Product: %d %s %s %s}", id, name, category,
				description);
	}
}
