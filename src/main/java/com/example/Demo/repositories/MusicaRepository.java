package com.example.Demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Demo.entidades.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {
}
