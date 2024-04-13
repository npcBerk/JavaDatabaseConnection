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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentPlans {
    private int paymentPlansId;
    private String name;
    private BigDecimal price;
    
    static Connection connection = DatabaseConnection.getConnection();

    public PaymentPlans(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    
    public PaymentPlans() {
    }
    public static void getAllPaymentPlans() {
    List<PaymentPlans> paymentPlansList = new ArrayList<>();
    String query = "SELECT * FROM payment_plans";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int id = rs.getInt("payment_plans_id");
            String name = rs.getString("name");
            BigDecimal price = rs.getBigDecimal("price");

            PaymentPlans paymentPlan = new PaymentPlans();
            paymentPlan.setPaymentPlansId(id);
            paymentPlan.setName(name);
            paymentPlan.setPrice(price);
            paymentPlansList.add(paymentPlan);

            System.out.println("Payment Plan ID: " + id +
                    ", Name: " + name +
                    ", Price: " + price);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all payment plans");
        e.printStackTrace();
    }
}


    public static void getPaymentPlansById(int paymentPlansId) {
    List<PaymentPlans> paymentPlansList = new ArrayList<>();
    String query = "SELECT * FROM payment_plans WHERE payment_plans_id = " + paymentPlansId;

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int id = rs.getInt("payment_plans_id");
            String name = rs.getString("name");
            BigDecimal price = rs.getBigDecimal("price");

            PaymentPlans paymentPlan = new PaymentPlans();
            paymentPlan.setPaymentPlansId(id);
            paymentPlan.setName(name);
            paymentPlan.setPrice(price);
            paymentPlansList.add(paymentPlan);

            System.out.println("Payment Plan ID: " + id +
                    ", Name: " + name +
                    ", Price: " + price);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching payment plans by ID");
        e.printStackTrace();
    }
}



    public int getPaymentPlansId() {
        return paymentPlansId;
    }

    public void setPaymentPlansId(int paymentPlansId) {
        this.paymentPlansId = paymentPlansId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        PaymentPlans.connection = connection;
    }

    
}
