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
@Table(name = "recipe_info")
@XmlRootElement
public class RecipeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String blurb;
	private String genre;
	@OneToOne
	private User autor;
	private String yield;
	private String preptime;

	public RecipeInfo() {
		this(0L, null, null, new User(), null, null);
	}

	public RecipeInfo(Long id, String blurb, String genre, User autor,
			String yield, String preptime) {
		super();
		this.id = id;
		this.blurb = blurb;
		this.genre = genre;
		this.autor = autor;
		this.yield = yield;
		this.preptime = preptime;
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
	 * @return the blurb
	 */
	public String getBlurb() {
		return blurb;
	}

	/**
	 * @param blurb
	 *            the blurb to set
	 */
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the autor
	 */
	public User getAutor() {
		return autor;
	}

	/**
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(User autor) {
		this.autor = autor;
	}

	/**
	 * @return the yield
	 */
	public String getYield() {
		return yield;
	}

	/**
	 * @param yield
	 *            the yield to set
	 */
	public void setYield(String yield) {
		this.yield = yield;
	}

	/**
	 * @return the preptime
	 */
	public String getPreptime() {
		return preptime;
	}

	/**
	 * @param preptime
	 *            the preptime to set
	 */
	public void setPreptime(String preptime) {
		this.preptime = preptime;
	}

//	@Override
//	public String toString() {
//		return String.format("{RecipeInfo: %d %s %s %s %s %s}", id, blurb, genre, autor, yield, preptime);
//	}
}
