package sakila.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sakila.AbstractEntity;

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
	@JoinColumn(name = "actor_id")
	private Actor actor;

	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}