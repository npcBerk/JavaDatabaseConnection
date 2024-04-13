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

public class User {

    private int userId;
    private String nickName;
    private boolean isAdult;
    private String password;
    private int age;
    private int countrId;
    private String phoneNumber;
    
    static Connection connection = DatabaseConnection.getConnection();


    public User() {
    }

    public User(String nickName, boolean isAdult, String password, int age, int countrId, String phoneNumber) {
        this.nickName = nickName;
        this.isAdult = isAdult;
        this.password = password;
        this.age = age;
        this.countrId = countrId;
        this.phoneNumber = phoneNumber;
    }

    public static void getAllUsers() {
        String query = "SELECT * FROM public.user";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String nickName = rs.getString("nick_name");
                boolean isAdult = rs.getBoolean("is_adult");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                int countrId = rs.getInt("country_id");
                String phoneNumber = rs.getString("phone_number");

                System.out.println("User ID: " + userId +
                    ", Nickname: " + nickName +
                    ", Is Adult: " + isAdult +
                    ", Password: " + password +
                    ", Age: " + age +
                    ", Country ID: " + countrId +
                    ", Phone Number: " + phoneNumber);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching all users");
            e.printStackTrace();
        }
    }

    public static void getUserByID(int userId) {
        String query = "SELECT * FROM public.user WHERE user_id = " + userId;

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                String nickName = rs.getString("nick_name");
                boolean isAdult = rs.getBoolean("is_adult");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                int countrId = rs.getInt("country_id");
                String phoneNumber = rs.getString("phone_number");

                System.out.println(userId + ", "
                        + nickName + ", "
                        + isAdult + ", "
                        + password + ", "
                        + age + ", "
                        + countrId + ", "
                        + phoneNumber);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching user by ID");
            e.printStackTrace();
        }
    }
    public static User getUserById(int userId) {
        User user = null;
        String query = "SELECT * FROM public.user WHERE user_id=" + userId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setNickName(rs.getString("nick_name"));
                user.setIsAdult(rs.getBoolean("is_adult"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setCountrId(rs.getInt("country_id"));
                user.setPhoneNumber(rs.getString("phone_number"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching user by ID");
            e.printStackTrace();
        }

        return user;
    }
    

    public static void addUser(User user) {
        String query = "INSERT INTO public.user (nick_name, is_adult, password, age, country_id, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, user.getNickName());
            pstmt.setBoolean(2, user.isIsAdult());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getAge());
            pstmt.setInt(5, user.getCountrId());
            pstmt.setString(6, user.getPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting user");
            e.printStackTrace();
        }
    }

    public static void updateUser(User user, int userId) {
        String query = "UPDATE public.user SET nick_name = ?, is_adult = ?, password = ?, age = ?, country_id = ?, phone_number = ? WHERE user_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, user.getNickName());
            pstmt.setBoolean(2, user.isIsAdult());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getAge());
            pstmt.setInt(5, user.getCountrId());
            pstmt.setString(6, user.getPhoneNumber());
            pstmt.setInt(7, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating user");
            e.printStackTrace();
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isIsAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCountrId() {
        return countrId;
    }

    public void setCountrId(int countrId) {
        this.countrId = countrId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
