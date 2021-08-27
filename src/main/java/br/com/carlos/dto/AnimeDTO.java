package br.com.carlos.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeDTO implements Serializable {
	
	private static final long serialVersionUID = -7714603118324524942L;

	private Long idAnime;
	
    private String nome;
	
    private Short temporada;
	
    private Boolean possuiManga;
}