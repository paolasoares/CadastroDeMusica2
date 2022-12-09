package com.example.Demo.dtos;

import org.springframework.stereotype.Component;

import com.example.Demo.entidades.Musica;

import jakarta.validation.constraints.NotBlank;

@Component
public class MusicaDTO {

	@NotBlank(message = "não deve estar em branco")
	private String titulo, artista, lancamento;

	public MusicaDTO(Musica musica) {
		this.titulo = musica.getTitulo();
		this.artista = musica.getArtista();
		this.lancamento = musica.getLancamento();
	}

	public MusicaDTO() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public String toString() {
		return "MusicaDto [titulo=" + titulo + ", artista=" + artista + ", lancamento=" + lancamento + "]";
	}

}
