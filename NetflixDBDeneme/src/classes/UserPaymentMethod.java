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

public class UserPaymentMethod {

    private int userPaymentMethodId;
    private User userId;
    private PaymentMethod paymentMethodId;

    static Connection connection = DatabaseConnection.getConnection();

    public UserPaymentMethod(User userID, PaymentMethod paymentMethodId) {
        this.userId = userID;
        this.paymentMethodId = paymentMethodId;
    }

    public UserPaymentMethod() {
    }

    public static void addUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
        String query = "INSERT INTO user_payment_method (user_id, payment_method_id) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userPaymentMethod.getUserId().getUserId());
            pstmt.setInt(2, userPaymentMethod.getPaymentMethodId().getPaymentMethodId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting user payment method");
            e.printStackTrace();
        }
    }

    public static void updateUserPaymentMethod(UserPaymentMethod userPaymentMethod, int userPaymentMethodId) {
        String query = "UPDATE user_payment_method SET user_id = ?, payment_method_id = ? WHERE user_payment_method_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userPaymentMethod.getUserId().getUserId());
            pstmt.setInt(2, userPaymentMethod.getPaymentMethodId().getPaymentMethodId());
            pstmt.setInt(3, userPaymentMethodId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating user payment method");
            e.printStackTrace();
        }
    }

    public static void getAllUserPaymentMethods() {
    List<UserPaymentMethod> userPaymentMethods = new ArrayList<>();
    String query = "SELECT * FROM user_payment_method";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            UserPaymentMethod userPaymentMethod = new UserPaymentMethod();
            userPaymentMethod.setUserPaymentMethodId(rs.getInt("user_payment_method_id"));

            int userId = rs.getInt("user_id");
            User user = User.getUserById(userId); // Assuming you have a method to get User by ID
            userPaymentMethod.setUserId(user);

            int paymentMethodId = rs.getInt("payment_method_id");
            PaymentMethod paymentMethod = PaymentMethod.getPaymentMethodById(paymentMethodId); // Assuming you have a method to get PaymentMethod by ID
            userPaymentMethod.setPaymentMethodId(paymentMethod);

            userPaymentMethods.add(userPaymentMethod);

            System.out.println("UserPaymentMethod ID: " + userPaymentMethod.getUserPaymentMethodId() +
                    ", User ID: " + user.getUserId() +
                    ", Payment Method ID: " + paymentMethod.getPaymentMethodId());
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all user payment methods");
        e.printStackTrace();
    }
}



    public int getUserPaymentMethodId() {
        return userPaymentMethodId;
    }

    public void setUserPaymentMethodId(int userPaymentMethodId) {
        this.userPaymentMethodId = userPaymentMethodId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        UserPaymentMethod.connection = connection;
    }

}
