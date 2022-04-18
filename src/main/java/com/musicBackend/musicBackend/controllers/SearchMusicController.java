package com.musicBackend.musicBackend.controllers;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.models.Genre;
import com.musicBackend.musicBackend.models.Music;
import com.musicBackend.musicBackend.services.ArtistService;
import com.musicBackend.musicBackend.services.GenreService;
import com.musicBackend.musicBackend.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.*;

@RequestMapping("/searchMusic")
@Controller
public class SearchMusicController {
	MusicService musicService;
	ArtistService artistService;
	GenreService genreService;
	@Autowired
    public SearchMusicController(MusicService musicService, ArtistService artistService, GenreService genreService) {
        this.musicService = musicService;
        this.artistService=artistService;
        this.genreService = genreService;
    }
	
	@ModelAttribute("musicMap")
	public Map<Long, String> getMusicList() {
		Map<Long, String> musicMap = new HashMap<Long, String>();
		List<Music> musics = musicService.getMusic();
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
			List<Artist> artists = artistService.getArtist();
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
			List<Genre> genres = genreService.getGenre();
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
