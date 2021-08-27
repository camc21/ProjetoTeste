package br.com.carlos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.model.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
