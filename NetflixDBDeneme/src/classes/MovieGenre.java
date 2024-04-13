/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Berk
 */

import db.operations.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieGenre {
    private Genre genreId;
    private Movie movieId;
    private int movieGenreId;
    
    static Connection connection = DatabaseConnection.getConnection();

    public MovieGenre(Genre genreID, Movie movieID) {
        this.genreId = genreID;
        this.movieId = movieID;
    }
    public MovieGenre() {
    }
    public static void getAllMovieGenres() {
    List<MovieGenre> movieGenresList = new ArrayList<>();
    String query = "SELECT * FROM movie_genre";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int movieGenreId = rs.getInt("movie_genre_id");
            int genreId = rs.getInt("genre_id");
            int movieId = rs.getInt("movie_id");

            MovieGenre movieGenre = new MovieGenre();
            movieGenre.setMovieGenreId(movieGenreId);
            movieGenre.setGenreId(getGenreById(genreId));
            movieGenre.setMovieId(getMovieById(movieId));
            movieGenresList.add(movieGenre);

            System.out.println("Movie Genre ID: " + movieGenreId +
                    ", Genre ID: " + genreId +
                    ", Movie ID: " + movieId);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all movie genres");
        e.printStackTrace();
    }
}


    public static MovieGenre getMovieGenreById(int movieGenreId) {
        MovieGenre movieGenre = new MovieGenre();
        String query = "SELECT * FROM movie_genre WHERE movie_genre_id = " + movieGenreId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                movieGenre.setMovieGenreId(rs.getInt("movie_genre_id"));
                movieGenre.setGenreId(getGenreById(rs.getInt("genre_id")));
                movieGenre.setMovieId(getMovieById(rs.getInt("movie_id")));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching movie genre by ID");
            e.printStackTrace();
        }

        return movieGenre;
    }

    private static Genre getGenreById(int genreId) {
        Genre genre = new Genre();
        // Genre sınıfının ilgili metodunu çağırarak genreId'ye göre bilgileri al
        // Örnek: genre = Genre.getGenreById(genreId);
        return genre;
    }

    private static Movie getMovieById(int movieId) {
        Movie movie = new Movie();
        // Movie sınıfının ilgili metodunu çağırarak movieId'ye göre bilgileri al
        // Örnek: movie = Movie.getMovieById(movieId);
        return movie;
    }


    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public int getMovieGenreId() {
        return movieGenreId;
    }

    public void setMovieGenreId(int movieGenreId) {
        this.movieGenreId = movieGenreId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        MovieGenre.connection = connection;
    }

    
}
