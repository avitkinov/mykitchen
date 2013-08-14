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
@Table(name = "user_products")
@XmlRootElement
public class UserProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Product product;
	@OneToOne
	private UnitOfMeasure uom;
	private int quantity;

	public UserProduct() {
		this(0L, new Product(), new UnitOfMeasure(), 0);
	}

	public UserProduct(Long id, Product product, UnitOfMeasure uom, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.uom = uom;
		this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the uom
	 */
	public UnitOfMeasure getUom() {
		return uom;
	}

	/**
	 * @param uom
	 *            the uom to set
	 */
	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%s %s %d", product, uom, quantity);
	}
}
