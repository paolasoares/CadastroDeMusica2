package com.example.Demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Demo.dtos.MusicaDTO;
import com.example.Demo.entidades.Musica;
import com.example.Demo.services.MusicaService;

import jakarta.validation.Valid;

@Controller
public class ControladorMusica {
	
	@Autowired
	private MusicaService service;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("index");
		return modelView;
	}
	
	@GetMapping("/musicas")
	public ModelAndView todasMusicas(){
		ModelAndView modelView = new ModelAndView("todasMusicas");
		List<Musica> musicas = service.findAll();
		modelView.addObject("musicas", musicas);
		return modelView;
	}
	
	@GetMapping("musicas/nova")
	public ModelAndView musicaNova(MusicaDTO musicaDto) {
		ModelAndView modelView = new ModelAndView("musicaNova");
		return modelView;
	}	
	
	@PostMapping("/musicas/salvar")
	public ModelAndView novaMusica(@Valid MusicaDTO musicaDto, BindingResult br
			, RedirectAttributes redirectAttributes) {
		if(br.hasErrors()) {
			System.out.println(musicaDto);
	        return new ModelAndView("musicaNova");
		}
		service.create(musicaDto);
		ModelAndView modelView = new ModelAndView("redirect:/musicas");
        redirectAttributes.addFlashAttribute("musica", musicaDto);
        redirectAttributes.addFlashAttribute("origemDados", "musicas");
		return modelView;
	}
}
