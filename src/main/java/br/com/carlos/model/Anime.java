package br.com.carlos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.carlos.dto.AnimeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ANIME")
public class Anime implements Serializable {

	private static final long serialVersionUID = -731378901932364664L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_anime")
    private Long idAnime;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "temporada")
    private Short temporada;
	
	@Column(name = "possui_manga")
    private Boolean possuiManga;
	
	
	public Anime(AnimeDTO animeDto) {
		this.idAnime = animeDto.getIdAnime();
		this.nome = animeDto.getNome();
		this.temporada = animeDto.getTemporada();
		this.possuiManga = animeDto.getPossuiManga();
	}
	
	public Anime updateAnime(AnimeDTO animeDto) {
		this.nome = animeDto.getNome();
		this.temporada = animeDto.getTemporada();
		this.possuiManga = animeDto.getPossuiManga();
		return this;
	}
}