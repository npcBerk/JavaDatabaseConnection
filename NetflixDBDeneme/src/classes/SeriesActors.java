/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import db.operations.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Berk
 */
public class SeriesActors {
    private Serie serieId;
    private Actor actorId;
    
    static Connection connection = DatabaseConnection.getConnection();

    public SeriesActors(Serie serieId, Actor actorId) {
        this.serieId = serieId;
        this.actorId = actorId;
    }

    public SeriesActors() {
    }
    public static void getAllSeriesActors() {
    List<SeriesActors> seriesActorsList = new ArrayList<>();
    String query = "SELECT * FROM series_actors";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int serieId = rs.getInt("serie_id");
            int actorId = rs.getInt("actor_id");

            Serie serie = Serie.getSerieById(serieId);
            Actor actor = Actor.getActorById(actorId);

            SeriesActors seriesActors = new SeriesActors(serie, actor);
            seriesActorsList.add(seriesActors);

            System.out.println("Series Actors ID: " + seriesActors.getActorId().getActorId() +
                    ", Serie ID: " + seriesActors.getSerieId().getSerieId() +
                    ", Serie Title: " + seriesActors.getSerieId().getTitle() +
                    ", Actor ID: " + seriesActors.getActorId().getActorId() +
                    ", Actor Name: " + seriesActors.getActorId().getActorName());
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching series actors by ID");
        e.printStackTrace();
    }
}

    public static void getSeriesActorsById(int serieId) {
        List<SeriesActors> seriesActorsList = new ArrayList<>();
        String query = "SELECT * FROM series_actors WHERE serie_id = " + serieId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Serie serie = new Serie(); // Serie sınıfına ait bir nesne oluşturmanız gerekebilir
                Actor actor = new Actor(); // Actor sınıfına ait bir nesne oluşturmanız gerekebilir

                // Veritabanından alınan değerleri kullanarak Serie ve Actor nesnelerini set edin
                // Bu kısımları ilgili sınıflara göre düzenlemeniz gerekebilir

                SeriesActors seriesActors = new SeriesActors(serie, actor);
                seriesActorsList.add(seriesActors);
                System.out.println("Series Actors ID: " + seriesActors.getActorId().getActorName()+
                ", Serie ID: " + seriesActors.getSerieId().getSerieId() +
                ", Serie Title: " + seriesActors.getSerieId().getTitle() +
                ", Actor ID: " + seriesActors.getActorId().getActorId() +
                ", Actor Name: " + seriesActors.getActorId().getActorName());
 
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching series actors by ID");
            e.printStackTrace();
        }

    }


    public Serie getSerieId() {
        return serieId;
    }

    public void setSerieId(Serie serieId) {
        this.serieId = serieId;
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
        SeriesActors.connection = connection;
    }
    
    
}
