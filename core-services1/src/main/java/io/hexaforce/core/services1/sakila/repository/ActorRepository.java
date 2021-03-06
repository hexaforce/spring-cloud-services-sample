package io.hexaforce.core.services1.sakila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import io.hexaforce.core.services1.sakila.model.Actor;

@Repository
@RepositoryRestResource(collectionResourceRel = "Actor", path = "actor")
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
