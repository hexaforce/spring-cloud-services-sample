package io.hexaforce.core.services1.sakila.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.hexaforce.core.services1.sakila.AbstractEntity;
import io.hexaforce.core.services1.sakila.type.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film")
public class Film extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer filmId;

	@Lob
	@Column(name = "description")
	private String description;

	@Column(name = "length")
	private Integer length;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "rating")
	private Rating rating;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_year")
	private Date releaseYear;

	@Column(name = "rental_duration")
	private Byte rentalDuration;

	@Column(name = "rental_rate")
	private BigDecimal rentalRate;

	@Column(name = "replacement_cost")
	private BigDecimal replacementCost;

	@Column(name = "special_features")
	private String specialFeatures;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language1;

	@ManyToOne
	@JoinColumn(name = "original_language_id")
	private Language language2;

	@OneToMany(mappedBy = "film")
	private List<FilmActor> filmActors;

	@OneToMany(mappedBy = "film")
	private List<FilmCategory> filmCategories;

	@OneToMany(mappedBy = "film")
	private List<Inventory> inventories;
	
	public FilmActor addFilmActor(FilmActor filmActor) {
		filmActors.add(filmActor);
		filmActor.setFilm(this);
		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		filmActors.remove(filmActor);
		filmActor.setFilm(null);
		return filmActor;
	}

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		filmCategories.add(filmCategory);
		filmCategory.setFilm(this);
		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		filmCategories.remove(filmCategory);
		filmCategory.setFilm(null);
		return filmCategory;
	}

	public Inventory addInventory(Inventory inventory) {
		inventories.add(inventory);
		inventory.setFilm(this);
		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		inventories.remove(inventory);
		inventory.setFilm(null);
		return inventory;
	}

	public void setLanguage1(Language language) {
		this.language1 = language;
	}

	public void setLanguage2(Language language) {
		this.language2 = language;
	}
}