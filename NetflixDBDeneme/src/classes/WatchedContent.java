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

public class WatchedContent {
    private Movie movieId;
    private User userId;
    private Serie serieId;
    
    static Connection connection = DatabaseConnection.getConnection();

    public WatchedContent() {
    }

    public WatchedContent(Movie movieID, User userID, Serie serieID) {
        this.movieId = movieID;
        this.userId = userID;
        this.serieId = serieID;
    }
    public static void addWatchedContent(WatchedContent watchedContent) {
        String query = "INSERT INTO watched_content (movie_id, user_id, serie_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, watchedContent.getMovieId().getId());
            pstmt.setInt(2, watchedContent.getUserId().getUserId());
            pstmt.setInt(3, watchedContent.getSerieId().getSerieId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while adding watched content");
            e.printStackTrace();
        }
    }

    public static void deleteWatchedContent(int userId, int contentId) {
        String query = "DELETE FROM watched_content WHERE user_id = ? AND (movie_id = ? OR serie_id = ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, contentId);
            pstmt.setInt(3, contentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting watched content");
            e.printStackTrace();
        }
    }

    public static void getWatchedContentByUser(int userId) {
        List<WatchedContent> watchedContentList = new ArrayList<>();
        String query = "SELECT * FROM watched_content WHERE user_id = " + userId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                WatchedContent watchedContent = new WatchedContent();
                watchedContent.setMovieId(Movie.getMovieById(rs.getInt("movie_id")));
                watchedContent.setUserId(User.getUserById(rs.getInt("user_id")));
                watchedContent.setSerieId(Serie.getSerieById(rs.getInt("serie_id")));
                watchedContentList.add(watchedContent);
                
                if (watchedContent.getSerieId()!= null) {
                    System.out.println(watchedContent.getUserId().getNickName() 
                        + " : " +watchedContent.getSerieId().getTitle());
                }
                if (watchedContent.getMovieId() != null) {
                System.out.println(watchedContent.getUserId().getNickName() 
                        + " : " + watchedContent.getMovieId().getTitle());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching watched content by user");
            e.printStackTrace();
        }
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Serie getSerieId() {
        return serieId;
    }

    public void setSerieId(Serie serieId) {
        this.serieId = serieId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        WatchedContent.connection = connection;
    }

    
}
