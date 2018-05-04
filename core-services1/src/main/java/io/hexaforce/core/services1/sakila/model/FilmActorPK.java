package io.hexaforce.core.services1.sakila.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FilmActorPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "actor_id", insertable = false, updatable = false)
	private Integer actorId;

	@Column(name = "film_id", insertable = false, updatable = false)
	private Integer filmId;
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FilmActorPK)) {
			return false;
		}
		FilmActorPK castOther = (FilmActorPK) other;
		return (this.actorId == castOther.actorId) && (this.filmId == castOther.filmId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.actorId;
		hash = hash * prime + this.filmId;
		return hash;
	}
	
}