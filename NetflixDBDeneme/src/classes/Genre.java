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

public class Genre {
    private int genreId;
    private String genreName;
    
    static Connection connection = DatabaseConnection.getConnection();

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public Genre() {
    }
    public static void getAllGenres() {
    List<Genre> genresList = new ArrayList<>();
    String query = "SELECT * FROM genre";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int genreId = rs.getInt("genre_id");
            String genreName = rs.getString("genre_name");

            Genre genre = new Genre(genreName);
            genre.setGenreId(genreId);
            genresList.add(genre);

            System.out.println(genreId + ", " + genreName);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all genres");
        e.printStackTrace();
    }
}


    public static Genre getGenreById(int genreId) {
        Genre genre = new Genre();
        String query = "SELECT * FROM genre WHERE genre_id = " + genreId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                genre.setGenreId(rs.getInt("genre_id"));
                genre.setGenreName(rs.getString("genre_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching genre by ID");
            e.printStackTrace();
        }

        return genre;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Genre.connection = connection;
    }
    
    
}
