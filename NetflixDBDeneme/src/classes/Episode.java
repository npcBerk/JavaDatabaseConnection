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
public class Episode {

    private int episodeId;
    private String episodeTitle;
    private int season;
    private String about;
    private int serieId;
    private int howLong;
    private int numberOfEpisode;

    static Connection connection = DatabaseConnection.getConnection();

    public Episode() {
    }

    public Episode(String episodeTitle, int season, String about, int serieId, int howLong, int numberOfEpisode) {
        this.episodeTitle = episodeTitle;
        this.season = season;
        this.about = about;
        this.serieId = serieId;
        this.howLong = howLong;
        this.numberOfEpisode = numberOfEpisode;
    }


    public static void addEpisode(Episode episode) {
        String query = "INSERT INTO episode (episode_title, season, about, serie_id, how_long, number_of_episode) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, episode.getEpisodeTitle());
            pstmt.setInt(2, episode.getSeason());
            pstmt.setString(3, episode.getAbout());
            pstmt.setInt(4, episode.getSerieId());
            pstmt.setInt(5, episode.getHowLong());
            pstmt.setInt(6, episode.getNumberOfEpisode());
            pstmt.executeUpdate();

            // Eklenen kaydın oluşturulan ID'sini al
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    episode.setEpisodeId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Error occurred while adding episode, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting episode");
            e.printStackTrace();
        }
    }

    public static void updateEpisode(Episode episode) {
        String query = "UPDATE episode SET episode_title = ?, season = ?, about = ?, serie_id = ?, how_long = ?, number_of_episode = ? WHERE episode_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, episode.getEpisodeTitle());
            pstmt.setInt(2, episode.getSeason());
            pstmt.setString(3, episode.getAbout());
            pstmt.setInt(4, episode.getSerieId());
            pstmt.setInt(5, episode.getHowLong());
            pstmt.setInt(6, episode.getNumberOfEpisode());
            pstmt.setInt(7, episode.getEpisodeId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating episode");
            e.printStackTrace();
        }
    }
/*
    public static void getAllEpisodes() {
    List<Episode> episodesList = new ArrayList<>();
    String query = "SELECT * FROM episode";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int episodeId = rs.getInt("episode_id");
            String episodeTitle = rs.getString("episode_title");
            int season = rs.getInt("season");
            String about = rs.getString("about");
            int serieId = rs.getInt("serie_id");
            int howLong = rs.getInt("how_long");
            int numberOfEpisode = rs.getInt("number_of_episode");

            Episode episode = new Episode(episodeTitle, season, about, serieId, howLong, numberOfEpisode);
            episode.setEpisodeId(episodeId);
            episodesList.add(episode);

            System.out.println(episodeId + ", "
                    + episodeTitle + ", "
                    + season + ", "
                    + about + ", "
                    + serieId + ", "
                    + howLong + ", "
                    + numberOfEpisode);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all episodes");
        e.printStackTrace();
    }
}*/

    public static void getAllEpisodes() {
    List<Episode> episodesList = new ArrayList<>();
    String query = "SELECT * FROM episode";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int episodeId = rs.getInt("episode_id");
            String episodeTitle = rs.getString("episode_title");
            int season = rs.getInt("season");
            String about = rs.getString("about");
            int serieId = rs.getInt("serie_id");
            int howLong = rs.getInt("how_long");
            int numberOfEpisode = rs.getInt("number_of_episode");

            Episode episode = new Episode();
            episode.setEpisodeId(episodeId);
            episode.setEpisodeTitle(episodeTitle);
            episode.setSeason(season);
            episode.setAbout(about);
            episode.setSerieId(serieId);
            episode.setHowLong(howLong);
            episode.setNumberOfEpisode(numberOfEpisode);

            episodesList.add(episode);

            System.out.println(episodeId + ", "
                    + episodeTitle + ", "
                    + season + ", "
                    + about + ", "
                    + serieId + ", "
                    + howLong + ", "
                    + numberOfEpisode);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all episodes");
        e.printStackTrace();
    }
}

    public static Episode getEpisodeById(int episodeId) {
        Episode episode = new Episode();
        String query = "SELECT * FROM episode WHERE episode_id = " + episodeId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                episode.setEpisodeId(rs.getInt("episode_id"));
                episode.setEpisodeTitle(rs.getString("episode_title"));
                episode.setSeason(rs.getInt("season"));
                episode.setAbout(rs.getString("about"));
                episode.setSerieId(rs.getInt("serie_id"));
                episode.setHowLong(rs.getInt("how_long"));
                episode.setNumberOfEpisode(rs.getInt("number_of_episode"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching episode by ID");
            e.printStackTrace();
        }

        return episode;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }

    public int getNumberOfEpisode() {
        return numberOfEpisode;
    }

    public void setNumberOfEpisode(int numberOfEpisode) {
        this.numberOfEpisode = numberOfEpisode;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Episode.connection = connection;
    }

}
