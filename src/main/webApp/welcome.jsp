<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>MUSIFY - Your music is here!</title>
        <link rel="stylesheet" href="/style/welcome.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        </head>
<body>
   <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">MUSIFY</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">HOME<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">ABOUT MUSIFY</a>
      </li>
      <li class="nav-item">
      </li>
    </ul>
    
    <form class="form-inline my-2 my-lg-0">
        <div class="nav-item">

  <select id = "song-select" class="form-select" aria-label="Default select example">
  <option selected>SEARCH BY NAME</option>

  <c:forEach items="${musicMap}" var="music">
    <option value = "${music.key}">
        ${music.value}
    </option>
  </c:forEach>

  </select>
  <button id = "music-btn">
   Search
  </button>
    

  <select id = "artist-select" class="form-select" aria-label="Default select example">
  <option selected>SEARCH BY ARTIST</option>
  <c:forEach items="${artistList}" var="artist">
    <option value = "${artist.key}">
        ${artist.value}
    </option>
    </c:forEach>
  </select>
<button id = "artist-btn">
   Search
  </button>
    

  <select id = "genre-select" class="form-select" aria-label="Default select example">
  <option selected>SEARCH BY GENRE</option>
  <c:forEach items="${genreList}" var="genre">
    <option value = "${genre.key}">
        ${genre.value}
    </option>
    </c:forEach>
  </select>
<button id = "genre-btn">
   Search
  </button>
   </div>

</span>
      <!-- <input class="form-control mr-sm-2" type="search" placeholder="" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">SEARCH</button> -->
    </form>
  </div>
</nav>
    <div class="container">
        <div class="songList">
            <h1>LIST OF SONGS</h1>
            <div class="songItemContainer">
               
                <div class="songItem">
                    <img alt="">
                    <span class="songName">Song1</span>
                    <span class="songlistplay"><span class="timestamp">xx:xx<i id="0" class="far songItemPlay fa-play-circle"></i> </span></span>
                <audio  controls>
  					<source id = "audio" src="/musicFiles/EkDoTeen.mp3" type="audio/mp3">
					Your browser does not support the audio element.
				</audio>
                </div>
               
               
            </div>
        </div>
        <div class="songBanner"></div>
    </div>

    <div class="bottom">
        <input type="range" name="range" id="myProgressBar" min="0" value="0" max="100">
        
    </div>
    <script src="https://kit.fontawesome.com/26504e4a1f.js" crossorigin="anonymous"></script>
</body>
<script > 
     
      $("#music-btn")
        .click(function(){
        	var selectedSong = $("#song-select").val();
        	$.get($(location).attr('pathname')+"/getMusicByMusicId?MusicId="+selectedSong, function(res){
        		
        		var container =('<div class="songItem"><img alt=""> <span class="songName">'+ res[0][0] + '</span> <span class="songlistplay"><span class="timestamp">xx:xx </span><audio  controls><source id = "audio" src=" '+ res[0][1]+ '" type="audio/mp3">Your browser does not support the audio element.</audio></div>');
     			$(".songItemContainer").html(container);
        	}
				
        	);
        
      })
       
        
    ;
</script>
</html>