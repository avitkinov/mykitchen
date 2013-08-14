package mykitchen.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "unit_of_measure")
@XmlRootElement
public class UnitOfMeasure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3599681236557348121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	public UnitOfMeasure() {
		this(0L, null, null);
	}

	public UnitOfMeasure(Long id, String name, String description) {
		this.id = id;
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(new Object[] { id, name, description });
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (this == obj) {
			result = true;
		} else if (obj instanceof UnitOfMeasure) {

			UnitOfMeasure uom = (UnitOfMeasure) obj;
			result = uom.getId().doubleValue() == this.id.doubleValue();
		}

		return result;
	}
}
