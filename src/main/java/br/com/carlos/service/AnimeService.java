package br.com.carlos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.dto.AnimeDTO;
import br.com.carlos.model.Anime;
import br.com.carlos.repository.AnimeRepository;

@Service
public class AnimeService {
	
	@Autowired
	AnimeRepository animeRepository;
	
	public List<Anime> findAll(){
		List<Anime> animeList = animeRepository.findAll();
		if(!animeList.isEmpty()) {
			return animeList;
		}
		return new ArrayList<Anime>();
	}
	
	public Anime findById(Long id){
		Optional<Anime> anime = animeRepository.findById(id);
		if(anime.isPresent()) {
			return anime.get();
		}
		return anime.orElseThrow();
	}
	
	public void postAnime(AnimeDTO animeDto) {
		try {
			Anime anime = new Anime(animeDto);
			animeRepository.save(anime);
		} catch (Exception e) {
			System.out.println("Erro");
		}
	}
	
	public void putAnime(AnimeDTO animeDto) {
		try {
			Anime anime = findById(animeDto.getIdAnime());
			anime.updateAnime(animeDto);
			animeRepository.save(anime);
		} catch (Exception e) {
			System.out.println("Erro");
		}
	}
	
	public void deleteAnime(Long id) {
		try {
			Anime anime = findById(id);
			animeRepository.delete(anime);
		} catch (Exception e) {
			System.out.println("Erro");
		}
	}
}
