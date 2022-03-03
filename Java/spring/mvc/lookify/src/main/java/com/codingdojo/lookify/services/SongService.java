package com.codingdojo.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public void createSong(Song song) {
		songRepository.save(song);
	}
	
	public void deleteSong(Long id) {
		System.out.println(id);
		songRepository.deleteBy_id(id);
	}
	
	public List<Song> getAllSongs(){
		return songRepository.find_All();
	}
	
	public List<Song> getTopTenSongs(){
		return songRepository.find_TopTen();
	}
	
	public Song getSong(Long id){
		return songRepository.findBy_id(id);
	}
	
	public List<Song> getSongsByArtist(String name){
		return songRepository.findBy_artist(name);
	}

}