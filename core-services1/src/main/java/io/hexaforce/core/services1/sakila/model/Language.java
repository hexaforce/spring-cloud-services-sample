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
@Table(name = "language")
public class Language extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private Byte languageId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "language1")
	private List<Film> films1;

	@OneToMany(mappedBy = "language2")
	private List<Film> films2;

	public Film addFilms1(Film films1) {
		this.films1.add(films1);
		films1.setLanguage1(this);
		return films1;
	}

	public Film removeFilms1(Film films1) {
		this.films1.remove(films1);
		films1.setLanguage1(null);
		return films1;
	}

	public Film addFilms2(Film films2) {
		this.films2.add(films2);
		films2.setLanguage2(this);
		return films2;
	}

	public Film removeFilms2(Film films2) {
		this.films2.remove(films2);
		films2.setLanguage2(null);
		return films2;
	}

}