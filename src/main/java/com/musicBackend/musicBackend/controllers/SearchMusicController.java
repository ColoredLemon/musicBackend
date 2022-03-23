package com.musicBackend.musicBackend.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.musicBackend.musicBackend.models.Music;
import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.models.Genre;
import com.musicBackend.musicBackend.services.musicService;
import com.musicBackend.musicBackend.services.artistService;
import com.musicBackend.musicBackend.services.genreService;

@RequestMapping("/searchMusic")
@Controller
public class SearchMusicController {
	musicService musicService;
	artistService artistService;
	genreService genreService;
	@Autowired
    public SearchMusicController(musicService musicService,artistService artistService,genreService genreService) {
        this.musicService = musicService;
        this.artistService=artistService;
        this.genreService = genreService;
    }
	
	@ModelAttribute("musicMap")
	public Map<Long, String> getMusicList() {
		Map<Long, String> musicMap = new HashMap<Long, String>();
		List<Music> musics = musicService.getMusics();
		for(Music music : musics) {
			Long musicCode = music.getId();
			String musicName = music.getMusicName();
			musicMap.put(musicCode,musicName);
		}
		return musicMap;	
	}
	@ModelAttribute("artistList")
	public Map<Long, String> getArtistList() {
			Map<Long, String> artistList = new HashMap<Long, String>();
			List<Artist> artists = artistService.getArtists();
			for(Artist artist : artists) {
				Long artistCode = artist.getId();
				String artistName = artist.getArtistName();
				artistList.put(artistCode,artistName);
			}
		return artistList;	
		}
	@ModelAttribute("genreList")
	public Map<Long, String> getGenreList() {
			Map<Long, String> genreList = new HashMap<Long, String>();
			List<Genre> genres = genreService.getGenres();
			for(Genre genre : genres) {
				Long genreCode = genre.getId();
				String genreName = genre.getGenreName();
				genreList.put(genreCode,genreName);
			}
			
			return genreList;	
	}
	
	@GetMapping
	public String getSearhMusic() {
		return "/welcome.jsp";
	}
	
	//Method for searching songs by song name
	@ResponseBody
	@GetMapping("/getMusicByMusicId")
	public List<List<String>> getMusicByMusicId(@RequestParam(name="MusicId") long id) {
		Music music =  musicService.getMusic(id);
		List<List<String>> musics = new ArrayList<List<String>>();
		List<String> musicDetails = new ArrayList<String>();
		musicDetails.add(music.getMusicName());
		musicDetails.add(music.getMusicDesc());
		musics.add(musicDetails);
		return musics;
	}
	
	@ResponseBody
	@GetMapping("/getMusicByArtistId")
	public Map<String,String> getMusicByArtistId(@RequestParam(name="ArtistId") long id) {
		Artist artist =  artistService.getArtist(id);
		Set<Music> musicsByThisArtist = artist.getMusics();
		Map<String,String> musicList = new HashMap<String,String>();
		for(Music eachMusic : musicsByThisArtist) {
			musicList.put(eachMusic.getMusicName(), eachMusic.getMusicDesc());
		}
		return musicList;
	}
	
	@ResponseBody
	@GetMapping("/getMusicByGenreId")
	public Map<String,String> getMusicByGenreId(@RequestParam(name="GenreId") long id) {
		Genre genre =  genreService.getGenre(id);
		Set<Music> musicsInThisGenre = genre.getMusics();
		Map<String,String> musicList = new HashMap<String,String>();
		for(Music eachMusic : musicsInThisGenre) {
			musicList.put(eachMusic.getMusicName(), eachMusic.getMusicDesc());
			
		}
		return musicList;
	}
}
