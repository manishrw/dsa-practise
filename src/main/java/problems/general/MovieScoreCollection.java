/*
    A movie 🍿 dataset table was given with fields movie_name, genre, and trend_score and there were two use cases :
    a) find the movie having the highest trend score in a given genre -> getMovieWithMaxTrendScoreByGenre(string genre) : string
    b) update the trend score of any movie by a new score -> updateMovieTrendScore(string movieName,int score): void
 */

package problems.general;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;
import utils.DebugLogger;

import java.util.*;

public class MovieScoreCollection {
    @Data
    static class Movie {
        @NonNull String movieName;
        @NonNull String genre;
        @NonNull Integer trendScore;
    }

    private final Map<String, Movie> movieMap;
    private final Map<String, TreeSet<Movie>> movieScoreByGenre;
    private final Comparator<Movie> movieScoreComparator;
    private final DebugLogger logger = DebugLogger.getInstance();

    public MovieScoreCollection() {
        movieMap = new HashMap<>();
        movieScoreByGenre = new HashMap<>();
        movieScoreComparator = Comparator.comparingInt(Movie::getTrendScore);
    }

    public String getMovieWithMaxTrendScoreByGenre(String genre) {
        logger.log("Get Max score for genre %s", genre);
        if (!movieScoreByGenre.containsKey(genre)) {
            return "";
        }
        var movie = Optional.of(movieScoreByGenre.get(genre).last());
        return movie.map(Movie::getMovieName).orElse("");
    }

    @SneakyThrows
    public void updateMovieTrendScore(String movieName, int score) {
        logger.log("Updating movie score for %s to %d", movieName, score);
        var movie = movieMap.get(movieName);
        if (Objects.isNull(movie)) {
            throw new Exception("Movie not found.");
        }
        var movieGenreScores = movieScoreByGenre.get(movie.getGenre());
        movieGenreScores.remove(movie);
        movie.setTrendScore(score);
        movieGenreScores.add(movie);
    }

    public void addMovie(Movie movie) {
        logger.log("Adding %s", movie);
        movieMap.put(movie.getMovieName(), movie);
        movieScoreByGenre.putIfAbsent(movie.getGenre(), new TreeSet<>(movieScoreComparator));
        movieScoreByGenre.get(movie.getGenre()).add(movie);
    }
}
