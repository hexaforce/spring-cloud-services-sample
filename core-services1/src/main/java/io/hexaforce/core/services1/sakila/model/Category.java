package io.hexaforce.core.services1.sakila.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "category")
public class Category extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Byte categoryId;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category")
	private List<FilmCategory> filmCategories;

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		filmCategories.add(filmCategory);
		filmCategory.setCategory(this);
		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		filmCategories.remove(filmCategory);
		filmCategory.setCategory(null);
		return filmCategory;
	}

}