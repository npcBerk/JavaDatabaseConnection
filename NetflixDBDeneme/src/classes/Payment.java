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

public class Payment {
    private int paymentId;
    private Date paymentDate;
    private PaymentMethod paymentMethodId;
    private PaymentPlans paymentPlansId;
    
    
    static Connection connection = DatabaseConnection.getConnection();

    public Payment(Date paymentDate, PaymentMethod paymentMethodId, PaymentPlans paymentPlansId) {
        this.paymentDate = paymentDate;
        this.paymentMethodId = paymentMethodId;
        this.paymentPlansId = paymentPlansId;
    }

    public Payment() {
    }
    public static void getAllPayments() {
    List<Payment> paymentsList = new ArrayList<>();
    String query = "SELECT * FROM payment";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int paymentId = rs.getInt("payment_id");
            Date paymentDate = rs.getDate("payment_date");
            int paymentMethodId = rs.getInt("payment_method_id");
            int paymentPlansId = rs.getInt("payment_plans_id");

            Payment payment = new Payment();
            payment.setPaymentId(paymentId);
            payment.setPaymentDate(paymentDate);
            payment.setPaymentMethodId(getPaymentMethodById(paymentMethodId));
            payment.setPaymentPlansId(getPaymentPlansById(paymentPlansId));
            paymentsList.add(payment);

            System.out.println("Payment ID: " + paymentId +
                    ", Payment Date: " + paymentDate +
                    ", Payment Method ID: " + paymentMethodId +
                    ", Payment Plans ID: " + paymentPlansId);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all payments");
        e.printStackTrace();
    }
}


    public static Payment getPaymentById(int paymentId) {
        Payment payment = new Payment();
        String query = "SELECT * FROM payment WHERE payment_id = " + paymentId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setPaymentMethodId(getPaymentMethodById(rs.getInt("payment_method_id")));
                payment.setPaymentPlansId(getPaymentPlansById(rs.getInt("payment_plans_id")));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching payment by ID");
            e.printStackTrace();
        }

        return payment;
    }

    private static PaymentMethod getPaymentMethodById(int paymentMethodId) {
        PaymentMethod paymentMethod = new PaymentMethod();
        // PaymentMethod sınıfının ilgili metodunu çağırarak paymentMethodId'ye göre bilgileri al
        // Örnek: paymentMethod = PaymentMethod.getPaymentMethodById(paymentMethodId);
        return paymentMethod;
    }

    private static PaymentPlans getPaymentPlansById(int paymentPlansId) {
        PaymentPlans paymentPlans = new PaymentPlans();
        // PaymentPlans sınıfının ilgili metodunu çağırarak paymentPlansId'ye göre bilgileri al
        // Örnek: paymentPlans = PaymentPlans.getPaymentPlansById(paymentPlansId);
        return paymentPlans;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public PaymentPlans getPaymentPlansId() {
        return paymentPlansId;
    }

    public void setPaymentPlansId(PaymentPlans paymentPlansId) {
        this.paymentPlansId = paymentPlansId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Payment.connection = connection;
    }

    
}
