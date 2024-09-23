package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        // your code here
        String name = movie.getName();
        movieMap.put(name,movie);
    }

    public void saveDirector(Director director){
        // your code here
        String name = director.getName();

        directorMap.put(name, director);

    }

    public void saveMovieDirectorPair(String movie, String director){

        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            // your code here

            if(!directorMovieMapping.containsKey(director)){

                List<String> movieList = new ArrayList<>();
                movieList.add(movie);
                directorMovieMapping.put(director,movieList);
            }

            directorMovieMapping.get(director).add(movie);


        }else{
            Movie m = new Movie(movie,0,0.0);
            Director d = new Director(director,0,0.0);
            movieMap.put(movie,m);
            directorMap.put(director,d);

            if(!directorMovieMapping.containsKey(director)){

                List<String> movieList = new ArrayList<>();
                movieList.add(movie);
                directorMovieMapping.put(director,movieList);
            }

            directorMovieMapping.get(director).add(movie);

        }
    }

    public Movie findMovie(String movie){
        // your code here
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        // your code here
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        // your code here
        return directorMovieMapping.get(director);
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        // your code here
        directorMap.remove(director);
        directorMovieMapping.remove(director);
    }

    public void deleteAllDirector(){
        // your code here
        directorMap.clear();
        directorMovieMapping.clear();
    }
}