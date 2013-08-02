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
@Table(name = "recipe_ingredients")
@XmlRootElement
public class RecipeIngredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7133502115866814413L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private Product product;
	@OneToOne
	private UnitOfMeasure uom;
	private int quantity;

	public RecipeIngredient() {
		this(0, new Product(), new UnitOfMeasure(), 0);
	}

	public RecipeIngredient(int id, Product product, UnitOfMeasure uom,
			int quantity) {
		this.id = id;
		this.product = product;
		this.uom = uom;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UnitOfMeasure getUom() {
		return uom;
	}

	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("{RecipeIngredient: %d %s %s %s}", id, product, uom, quantity);
	}
}
