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

public class SerieGenre {
    private  Serie serieId;
    private Genre genreId;
    private int serieGenreId;
    
    static Connection connection = DatabaseConnection.getConnection();

    public SerieGenre(Serie serieID, Genre genreID) {
        this.serieId = serieID;
        this.genreId = genreID;
    }

    public static void getAllSerieGenres() {
    List<SerieGenre> serieGenresList = new ArrayList<>();
    String query = "SELECT * FROM serie_genre";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            Serie serieId = Serie.getSerieById(rs.getInt("serie_id"));
            Genre genreId = Genre.getGenreById(rs.getInt("genre_id"));

            SerieGenre serieGenre = new SerieGenre(serieId, genreId);
            serieGenre.setSerieGenreId(rs.getInt("serie_genre_id"));
            serieGenresList.add(serieGenre);

            System.out.println("Serie Genre ID: " + serieGenre.getSerieGenreId() +
                    ", Serie ID: " + serieGenre.getSerieId().getSerieId() +
                    ", Serie Title: " + serieGenre.getSerieId().getTitle() +
                    ", Genre ID: " + serieGenre.getGenreId().getGenreId() +
                    ", Genre Name: " + serieGenre.getGenreId().getGenreName());
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all serie genres");
        e.printStackTrace();
    }
}

    public static List<SerieGenre> getSerieGenresById(int serieGenreId) {
        List<SerieGenre> serieGenresList = new ArrayList<>();
        String query = "SELECT * FROM serie_genre WHERE serie_genre_id = " + serieGenreId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Serie serie = new Serie(); // Serie sınıfına ait bir nesne oluşturmanız gerekebilir
                Genre genre = new Genre(); // Genre sınıfına ait bir nesne oluşturmanız gerekebilir

                // Veritabanından alınan değerleri kullanarak Serie ve Genre nesnelerini set edin
                // Bu kısımları ilgili sınıflara göre düzenlemeniz gerekebilir

                SerieGenre serieGenre = new SerieGenre(serie, genre);
                serieGenre.setSerieGenreId(rs.getInt("serie_genre_id"));
                serieGenresList.add(serieGenre);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching serie genres by ID");
            e.printStackTrace();
        }

        return serieGenresList;
    }
    
    public SerieGenre() {
    }

    public Serie getSerieId() {
        return serieId;
    }

    public void setSerieId(Serie serieId) {
        this.serieId = serieId;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    public int getSerieGenreId() {
        return serieGenreId;
    }

    public void setSerieGenreId(int serieGenreId) {
        this.serieGenreId = serieGenreId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        SerieGenre.connection = connection;
    }
    
    
    
}
