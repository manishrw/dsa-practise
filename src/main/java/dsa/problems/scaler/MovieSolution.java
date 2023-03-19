/**
 * Reference company: Amazon
 * <br>
 * Question:
 * Explain that there will be multiple of these queries.
 * A movie  dataset  is given with fields movie_name, genre, and trend_score and there were two use cases :
 * <br>
 * a) find the movie having the highest trend score in a given genre -> getMovieWithMaxTrendScoreByGenre(string genre) : string
 * <br>
 * b) update the trend score of any movie b new score a -> updateMovieTrendScore(string movieName,int score): void
 *
 */
package dsa.problems.scaler;

import java.util.*;

public class MovieSolution {
    // Your data structures go here
    Map<String, TreeSet<Movie>> orderedMoviesByGenre;
    Map<String, Movie> movieByName;
    Comparator<Movie> movieComparator;

    public MovieSolution() {
        orderedMoviesByGenre = new HashMap<>();
        movieByName = new HashMap<>();
        movieComparator = Comparator.comparing(Movie::getScore).thenComparing(Movie::getName);
    }

    public String getMovieWithMaxTrendScoreByGenre(String genre) {
        // your code goes here...
        if (orderedMoviesByGenre.containsKey(genre)) {
            return orderedMoviesByGenre.get(genre).last().getName();
        }
        return "";
    }

    public void updateMovieTrendScore(String movieName, int score) {
        // your code goes here...
        if (movieByName.containsKey(movieName)) {
            var movie = movieByName.get(movieName);
            var movies = orderedMoviesByGenre.get(movie.getGenre());
            movies.remove(movie);
            movie.setScore(score);
            movies.add(movie);
        }
    }

    // Methods not under test
    public void addAll(Collection<Movie> movies) {
        movies.forEach(this::add);
    }

    public void add(Movie movie) {
        movieByName.put(movie.getName(), movie);
        orderedMoviesByGenre.computeIfAbsent(movie.getGenre(), k -> new TreeSet<>(movieComparator));
        orderedMoviesByGenre.get(movie.getGenre()).add(movie);
    }

    static class Movie {
        String name;
        String genre;
        int score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public Movie(String name, String genre, int score) {
            this.name = name;
            this.genre = genre;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Movie)) return false;

            Movie movie = (Movie) o;

            if (score != movie.score) return false;
            if (!Objects.equals(name, movie.name)) return false;
            return Objects.equals(genre, movie.genre);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (genre != null ? genre.hashCode() : 0);
            result = 31 * result + score;
            return result;
        }

        public static synchronized Movie Create(String name, String genre, int score) {
            return new Movie(name, genre, score);
        }
    }
}
