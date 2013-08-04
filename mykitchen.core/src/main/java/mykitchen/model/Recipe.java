package mykitchen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "recipes")
@XmlRootElement
public class Recipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7617660588930712100L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	
	@OneToOne
	private RecipeInfo recipeinfo;

	private String image;

	@OneToOne
	private List<RecipeIngredient> ingredients;

	private String preparation;
	private String serving;

	public Recipe() {
		this(new Long(0), null, new RecipeInfo(), null, null, null, null);
	}

	public Recipe(Long id, String title, RecipeInfo recipeinfo,
			String image, List<RecipeIngredient> ingredients,
			String preparation, String serving) {
		super();
		this.id = id;
		this.title = title;
		this.recipeinfo = recipeinfo;
		this.image = image;
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.serving = serving;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the recipeinfo
	 */
	public RecipeInfo getRecipeinfo() {
		return recipeinfo;
	}

	/**
	 * @param recipeinfo
	 *            the recipeinfo to set
	 */
	public void setRecipeinfo(RecipeInfo recipeinfo) {
		this.recipeinfo = recipeinfo;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param images
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the ingredients
	 */
	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients
	 *            the ingredients to set
	 */
	public void setIngredients(List<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the preparation
	 */
	public String getPreparation() {
		return preparation;
	}

	/**
	 * @param preparation
	 *            the preparation to set
	 */
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	/**
	 * @return the serving
	 */
	public String getServing() {
		return serving;
	}

	/**
	 * @param serving
	 *            the serving to set
	 */
	public void setServing(String serving) {
		this.serving = serving;
	}
	
	@Override
	public String toString() {
		return String.format("{Recipe: %d %s %s %s %s %s %s}", id, title, recipeinfo, ingredients, preparation, serving, image) ;
	}

}
