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

public class PaymentMethod {
    private int paymentMethodId;
    private CreditCard creditCardId;
    private int giftCardId;
    
    static Connection connection = DatabaseConnection.getConnection();

    public PaymentMethod(CreditCard creditCardID, int giftCardID) {
        this.creditCardId = creditCardID;
        this.giftCardId = giftCardID;
    }

    public PaymentMethod() {
    }
    public static void getAllPaymentMethods() {
    List<PaymentMethod> paymentMethodsList = new ArrayList<>();
    String query = "SELECT * FROM payment_method";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int paymentMethodId = rs.getInt("payment_method_id");
            int creditCardId = rs.getInt("credit_card_id");
            int giftCardId = rs.getInt("gift_card_id");

            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setPaymentMethodId(paymentMethodId);
            paymentMethod.setCreditCardId(getCreditCardById(creditCardId));
            paymentMethod.setGiftCardId(giftCardId);
            paymentMethodsList.add(paymentMethod);

            System.out.println("Payment Method ID: " + paymentMethodId +
                    ", Credit Card ID: " + creditCardId +
                    ", Gift Card ID: " + giftCardId);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all payment methods");
        e.printStackTrace();
    }
}


    public static PaymentMethod getPaymentMethodById(int paymentMethodId) {
        PaymentMethod paymentMethod = new PaymentMethod();
        String query = "SELECT * FROM payment_method WHERE payment_method_id = " + paymentMethodId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                paymentMethod.setPaymentMethodId(rs.getInt("payment_method_id"));
                paymentMethod.setCreditCardId(getCreditCardById(rs.getInt("credit_card_id")));
                paymentMethod.setGiftCardId(rs.getInt("gift_card_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching payment method by ID");
            e.printStackTrace();
        }

        return paymentMethod;
    }

    private static CreditCard getCreditCardById(int creditCardId) {
        CreditCard creditCard = new CreditCard();
        // CreditCard sınıfının ilgili metodunu çağırarak creditCardId'ye göre bilgileri al
        // Örnek: creditCard = CreditCard.getCreditCardById(creditCardId);
        return creditCard;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public CreditCard getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(CreditCard creditCardId) {
        this.creditCardId = creditCardId;
    }

    public int getGiftCardId() {
        return giftCardId;
    }

    public void setGiftCardId(int giftCardId) {
        this.giftCardId = giftCardId;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        PaymentMethod.connection = connection;
    }

    
    
}
