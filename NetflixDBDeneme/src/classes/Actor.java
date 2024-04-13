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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Berk
 */
public class Actor {
    private int actorId;
    private String actorName;
    private String actorLastname;
    private String gender;
    private Date birthdate;
    
    static Connection connection = DatabaseConnection.getConnection();

    public Actor() {
    }

    public Actor(String actorName, String actorLastname, String gender, Date birthdate) {
        this.actorName = actorName;
        this.actorLastname = actorLastname;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public static void addActor(Actor actor) {
        String query = "INSERT INTO actor (actor_name, actor_lastname, gender, birthdate) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, actor.getActorName());
            pstmt.setString(2, actor.getActorLastname());
            pstmt.setString(3, actor.getGender());
            pstmt.setDate(4, new java.sql.Date(actor.getBirthdate().getTime()));
            pstmt.executeUpdate();

            // Eklenen kaydın oluşturulan ID'sini al
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    actor.setActorId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Error occurred while adding actor, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting actor");
            e.printStackTrace();
        }
    }

    public static void updateActor(Actor actor) {
        String query = "UPDATE actor SET actor_name = ?, actor_lastname = ?, gender = ?, birthdate = ? WHERE actor_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, actor.getActorName());
            pstmt.setString(2, actor.getActorLastname());
            pstmt.setString(3, actor.getGender());
            pstmt.setDate(4, new java.sql.Date(actor.getBirthdate().getTime()));
            pstmt.setInt(5, actor.getActorId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating actor");
            e.printStackTrace();
        }
    }
    public static void getAllActors() {
    List<Actor> actorsList = new ArrayList<>();
    String query = "SELECT * FROM actor";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int actorId = rs.getInt("actor_id");
            String actorName = rs.getString("actor_name");
            String actorLastname = rs.getString("actor_lastname");
            String gender = rs.getString("gender");
            Date birthdate = rs.getDate("birthdate");

            Actor actor = new Actor(actorName, actorLastname, gender, birthdate);
            actorsList.add(actor);

            System.out.println(actorId + ", "
                    + actorName + ", "
                    + actorLastname + ", "
                    + gender + ", "
                    + birthdate);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all actors");
        e.printStackTrace();
    }
}


    public static Actor getActorById(int actorId) {
        Actor actor = new Actor();
        String query = "SELECT * FROM actor WHERE actor_id = " + actorId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                actor.setActorId(rs.getInt("actor_id"));
                actor.setActorName(rs.getString("actor_name"));
                actor.setActorLastname(rs.getString("actor_lastname"));
                actor.setGender(rs.getString("gender"));
                actor.setBirthdate(rs.getDate("birthdate"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching actor by ID");
            e.printStackTrace();
        }

        return actor;
    }
    
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorLastname() {
        return actorLastname;
    }

    public void setActorLastname(String actorLastname) {
        this.actorLastname = actorLastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Actor.connection = connection;
    }
    
    
    
}
