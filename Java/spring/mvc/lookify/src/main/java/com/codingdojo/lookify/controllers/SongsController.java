package com.codingdojo.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongsController {
	
	final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	@GetMapping("/")
	public String showIndex() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		model.addAttribute("songs", songService.getAllSongs());
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/{id}")
	public String showDashboard(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songService.getSong(id));
		return "song.jsp";
	}
	
	@GetMapping("/songs/new")
	public String showNewSong(Model model) {
		model.addAttribute("song", new Song());
		return "newSong.jsp";
	}
	@PostMapping("/songs/new")
	public String createNewSong(@Valid @ModelAttribute("song") Song song, BindingResult result){
        if (result.hasErrors()) {
            return "newSong.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
	}
	
	@PostMapping("/songs/delete/{id}")
	public String createNewSong(@PathVariable("id") Long id){
        songService.deleteSong(id);
        return "redirect:/dashboard";
	}
	
	@GetMapping("/search")
	public String showArtistSearch(@RequestParam(value = "artist") String artist, Model model) {
		model.addAttribute("songs", songService.getSongsByArtist(artist));
		model.addAttribute("artist", artist);
		return "artistSearch.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String showTopTen(Model model) {
		model.addAttribute("songs", songService.getTopTenSongs());
		return "topTen.jsp";
	}
}
