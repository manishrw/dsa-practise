package problems.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DebugLogger;

import java.util.Objects;

class MovieScoreCollectionTest {
    private final MovieScoreCollection collection = new MovieScoreCollection();
    private final DebugLogger logger = DebugLogger.getInstance();

    @BeforeEach
    void setUp() {
        collection.addMovie(new MovieScoreCollection.Movie("a1", "g1", 1));
        collection.addMovie(new MovieScoreCollection.Movie("a2", "g1", 2));
        collection.addMovie(new MovieScoreCollection.Movie("a3", "g1", 3));
        collection.addMovie(new MovieScoreCollection.Movie("a4", "g1", 4));
        collection.addMovie(new MovieScoreCollection.Movie("a5", "g1", 5));
        collection.addMovie(new MovieScoreCollection.Movie("a6", "g1", 6));

        collection.addMovie(new MovieScoreCollection.Movie("a11", "g2", 1));
        collection.addMovie(new MovieScoreCollection.Movie("a12", "g2", 2));
        collection.addMovie(new MovieScoreCollection.Movie("a13", "g2", 3));
        collection.addMovie(new MovieScoreCollection.Movie("a14", "g2", 4));
        collection.addMovie(new MovieScoreCollection.Movie("a15", "g2", 5));
        collection.addMovie(new MovieScoreCollection.Movie("a16", "g2", 6));
        collection.addMovie(new MovieScoreCollection.Movie("a17", "g2", 7));
    }


    @Test
    public void testPositiveScenario() {
        var movieWithMaxTrendScoreByGenre = collection.getMovieWithMaxTrendScoreByGenre("g1");
        logger.log("Result: %s", movieWithMaxTrendScoreByGenre);
        assert Objects.equals(movieWithMaxTrendScoreByGenre, "a6");

        movieWithMaxTrendScoreByGenre = collection.getMovieWithMaxTrendScoreByGenre("g2");
        logger.log("Result: %s", movieWithMaxTrendScoreByGenre);
        assert Objects.equals(movieWithMaxTrendScoreByGenre, "a17");

        collection.updateMovieTrendScore("a1", 9);
        movieWithMaxTrendScoreByGenre = collection.getMovieWithMaxTrendScoreByGenre("g1");
        logger.log("Result: %s", movieWithMaxTrendScoreByGenre);
        assert Objects.equals(movieWithMaxTrendScoreByGenre, "a1");
    }

    @Test
    public void testGetMovieWithMaxTrendScoreByGenreWithInvalidGenreInput() {
        var movie = collection.getMovieWithMaxTrendScoreByGenre("g3");
        assert movie.isEmpty();
    }

    @Test
    public void testUpdateMovieTrendScoreWithInvalidMovieName() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> collection.updateMovieTrendScore("a0", 1));
        assert exception.getMessage().equals("Movie not found.");
    }

}