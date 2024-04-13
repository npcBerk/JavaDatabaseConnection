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
import java.util.Date;
import java.util.List;

public class Serie {

    private int serieId;
    private String title;
    private String poster;
    private int productionYear;
    private String age_category;
    private int seasonNumber;
    private Date addingDate;

    static Connection connection = DatabaseConnection.getConnection();

    public Serie(String title, String poster, int productionYear, String age_category, int seasonNumber) {
        this.title = title;
        this.poster = poster;
        this.productionYear = productionYear;
        this.age_category = age_category;
        this.seasonNumber = seasonNumber;
        this.addingDate = new Date();
    }

    public Serie() {
    }

    public static void addSerie(Serie serie) {
        String query = "INSERT INTO serie (title, poster, production_year, age_category, season_number, adding_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, serie.getTitle());
            pstmt.setString(2, serie.getPoster());
            pstmt.setInt(3, serie.getProductionYear());
            pstmt.setString(4, serie.getAge_category());
            pstmt.setInt(5, serie.getSeasonNumber());
            pstmt.setDate(6, new java.sql.Date(serie.getAddingDate().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting serie");
            e.printStackTrace();
        }
    }

    public static void updateSerie(Serie serie, int seriId) {
        String query = "UPDATE serie SET title = ?, poster = ?, production_year = ?, age_category = ?, season_number = ?, adding_date = ? WHERE serie_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, serie.getTitle());
            pstmt.setString(2, serie.getPoster());
            pstmt.setInt(3, serie.getProductionYear());
            pstmt.setString(4, serie.getAge_category());
            pstmt.setInt(5, serie.getSeasonNumber());
            pstmt.setDate(6, new java.sql.Date(serie.getAddingDate().getTime()));
            pstmt.setInt(7, seriId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating serie");
        }
    }
    
    public static void getAllSeries() {
    List<Serie> series = new ArrayList<>();
    String query = "SELECT * FROM serie";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int serieId = rs.getInt("serie_id");
            String title = rs.getString("title");
            String poster = rs.getString("poster");
            int productionYear = rs.getInt("production_year");
            String ageCategory = rs.getString("age_category");
            int seasonNumber = rs.getInt("season_number");
            Date addingDate = rs.getDate("adding_date");

            Serie serie = new Serie(title, poster, productionYear, ageCategory, seasonNumber);
            serie.setSerieId(serieId); // Setting Serie ID separately
            series.add(serie);

            System.out.println("Serie ID: " + serieId +
                    ", Title: " + title +
                    ", Poster: " + poster +
                    ", Production Year: " + productionYear +
                    ", Age Category: " + ageCategory +
                    ", Season Number: " + seasonNumber +
                    ", Adding Date: " + addingDate);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all series");
        e.printStackTrace();
    }
}

    
    
    public static Serie getSerieById(int serieId) {
        Serie serie = null;
        String query = "SELECT * FROM serie WHERE serie_id=" + serieId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                serie = new Serie();
                serie.setSerieId(rs.getInt("serie_id"));
                serie.setTitle(rs.getString("title"));
                serie.setPoster(rs.getString("poster"));
                serie.setProductionYear(rs.getInt("production_year"));
                serie.setAge_category(rs.getString("age_category"));
                serie.setSeasonNumber(rs.getInt("season_number"));
                serie.setAddingDate(rs.getDate("adding_date"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching serie by ID");
            e.printStackTrace();
        }

        return serie;
    }
    public static void getAllSeriesById(int id) {
        String whereOp ="";
        whereOp = "where serie_id = "+String.valueOf(id);
        
        List<Serie> series = new ArrayList<>();
        String query = "SELECT * FROM serie "+whereOp;

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int serieId = rs.getInt("serie_id");
                String title = rs.getString("title");
                String poster = rs.getString("poster");
                int productionYear = rs.getInt("production_year");
                String ageCategory = rs.getString("age_category");
                int seasonNumber = rs.getInt("season_number");
                Date addingDate = rs.getDate("adding_date");

                Serie serie = new Serie(title, poster, productionYear, ageCategory, seasonNumber);
                series.add(serie);

                System.out.println(serieId + ", "
                        + title + ", "
                        + poster + ", "
                        + productionYear + ", "
                        + ageCategory + ", "
                        + seasonNumber + ", "
                        + addingDate);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching all series");
            e.printStackTrace();
        }
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getAge_category() {
        return age_category;
    }

    public void setAge_category(String age_category) {
        this.age_category = age_category;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Serie.connection = connection;
    }

}
