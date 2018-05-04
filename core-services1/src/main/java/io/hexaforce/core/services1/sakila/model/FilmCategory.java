package io.hexaforce.core.services1.sakila.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.hexaforce.core.services1.sakila.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film_category")
public class FilmCategory extends AbstractEntity {

	@EmbeddedId
	private FilmCategoryPK id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}