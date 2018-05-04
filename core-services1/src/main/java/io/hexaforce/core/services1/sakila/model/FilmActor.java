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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film_actor")
public class FilmActor extends AbstractEntity {

	@EmbeddedId
	private FilmActorPK id;

	@ManyToOne
	@JoinColumn(name = "actor_id", referencedColumnName = "actor_id", insertable = false, updatable = false)
	private Actor actor;

	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
	private Film film;

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}