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

public class MovieActors {
    private Movie movieId;
    private Actor actorId;
    
    static Connection connection = DatabaseConnection.getConnection();

    public MovieActors(Movie movieID, Actor actorID) {
        this.movieId = movieID;
        this.actorId = actorID;
    }

    public MovieActors() {
    }
    public static void getAllMovieActors() {
    List<MovieActors> movieActorsList = new ArrayList<>();
    String query = "SELECT * FROM movies_actors";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int movieId = rs.getInt("movie_id");
            int actorId = rs.getInt("actor_id");

            MovieActors movieActors = new MovieActors();
            movieActors.setMovieId(getMovieById(movieId));
            movieActors.setActorId(getActorById(actorId));
            movieActorsList.add(movieActors);

            System.out.println("Movie ID: " + movieId + ", Actor ID: " + actorId);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all movie actors");
        e.printStackTrace();
    }
}


    public static MovieActors getMovieActorById(int movieId, int actorId) {
        MovieActors movieActors = new MovieActors();
        String query = "SELECT * FROM movie_actors WHERE movie_id = " + movieId + " AND actor_id = " + actorId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                movieActors.setMovieId(getMovieById(rs.getInt("movie_id")));
                movieActors.setActorId(getActorById(rs.getInt("actor_id")));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching movie actor by ID");
            e.printStackTrace();
        }

        return movieActors;
    }

    private static Movie getMovieById(int movieId) {
        Movie movie = new Movie();
        // Movie sınıfının ilgili metodunu çağırarak movieId'ye göre bilgileri al
        // Örnek: movie = Movie.getMovieById(movieId);
        return movie;
    }

    private static Actor getActorById(int actorId) {
        Actor actor = new Actor();
        // Actor sınıfının ilgili metodunu çağırarak actorId'ye göre bilgileri al
        // Örnek: actor = Actor.getActorById(actorId);
        return actor;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public Actor getActorId() {
        return actorId;
    }

    public void setActorId(Actor actorId) {
        this.actorId = actorId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        MovieActors.connection = connection;
    }
    
    
    
}
