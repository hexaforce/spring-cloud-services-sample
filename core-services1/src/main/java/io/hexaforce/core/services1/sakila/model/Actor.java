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
import io.hexaforce.core.services1.sakila.extension.FullNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
public class Actor extends AbstractEntity implements FullNames {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private Integer actorId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToMany(mappedBy = "actor")
	private List<FilmActor> filmActors;

	public FilmActor addFilmActor(FilmActor filmActor) {
		filmActors.add(filmActor);
		filmActor.setActor(this);
		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		filmActors.remove(filmActor);
		filmActor.setActor(null);
		return filmActor;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

}