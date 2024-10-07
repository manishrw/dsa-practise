package dsa.problems.scaler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MovieSolutionTest {

    MovieSolution solution;

    @BeforeEach
    void setup() {
        solution = new MovieSolution();
        List<MovieSolution.Movie> movies = Arrays.asList(
            MovieSolution.Movie.Create("m1", "g1", 3),
            MovieSolution.Movie.Create("m2", "g2", 5),
            MovieSolution.Movie.Create("m3", "g3", 8),
            MovieSolution.Movie.Create("m4", "g2", 4),
            MovieSolution.Movie.Create("m5", "g1", 9),
            MovieSolution.Movie.Create("m6", "g2", 6),
            MovieSolution.Movie.Create("m7", "g3", 5)
        );
        solution.addAll(movies);
    }


    @Test
    void getMovieWithMaxTrendScoreByGenre() {
        var actual = solution.getMovieWithMaxTrendScoreByGenre("g1");
        var expected = "m5";
        assert expected.equals(actual);
    }

    @Test
    void getMovieWithMaxTrendScoreByGenreWithInvalidGenre() {
        var actual = solution.getMovieWithMaxTrendScoreByGenre("g100");
        var expected = "";
        assert expected.equals(actual);
    }

    @Test
    void updateMovieTrendScore() {
        solution.updateMovieTrendScore("m5", 2);
        var actual = solution.getMovieWithMaxTrendScoreByGenre("g1");
        var expected = "m1";
        assert expected.equals(actual);
    }
}