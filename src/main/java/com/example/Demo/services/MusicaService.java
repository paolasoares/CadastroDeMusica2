package com.example.Demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.dtos.MusicaDTO;
import com.example.Demo.entidades.Musica;
import com.example.Demo.repositories.MusicaRepository;

@Service
public class MusicaService {
	
	@Autowired
	private MusicaRepository repository;
	
	public List<Musica> findAll() {
		return repository.findAll();
	}
	
	public void create(MusicaDTO dto) {
		Musica musica = new Musica(dto);
		repository.save(musica);
	}
}
