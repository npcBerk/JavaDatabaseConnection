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

public class CreditCard {
    private int creditCardId;
    private String cardNumber;
    private int cvc;
    private Date expirationDate;
    private String ownerName;
    private String ownerLastname;

    public CreditCard(String cardNumber, int cvc, Date expirationDate, String ownerName, String ownerLastname) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expirationDate = expirationDate;
        this.ownerName = ownerName;
        this.ownerLastname = ownerLastname;
    }
    static Connection connection = DatabaseConnection.getConnection();

    
    public CreditCard() {
    }
    public static void addCreditCard(CreditCard creditCard) {
        String query = "INSERT INTO credit_card (card_number, cvc, expiration_date, owner_name, owner_lastname) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, creditCard.getCardNumber());
            pstmt.setInt(2, creditCard.getCvc());
            pstmt.setDate(3, new java.sql.Date(creditCard.getExpirationDate().getTime()));
            pstmt.setString(4, creditCard.getOwnerName());
            pstmt.setString(5, creditCard.getOwnerLastname());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting credit card");
            e.printStackTrace();
        }
    }

    public static void updateCreditCard(CreditCard creditCard, int creditCardId) {
        String query = "UPDATE credit_card SET card_number = ?, cvc = ?, expiration_date = ?, owner_name = ?, owner_lastname = ? WHERE credit_card_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, creditCard.getCardNumber());
            pstmt.setInt(2, creditCard.getCvc());
            pstmt.setDate(3, new java.sql.Date(creditCard.getExpirationDate().getTime()));
            pstmt.setString(4, creditCard.getOwnerName());
            pstmt.setString(5, creditCard.getOwnerLastname());
            pstmt.setInt(6, creditCardId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error occurred while updating credit card");
            e.printStackTrace();
        }
    }

    public static void getAllCreditCards() {
    List<CreditCard> creditCardsList = new ArrayList<>();
    String query = "SELECT * FROM credit_card";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int creditCardId = rs.getInt("credit_card_id");
            String cardNumber = rs.getString("card_number");
            int cvc = rs.getInt("cvc");
            Date expirationDate = rs.getDate("expiration_date");
            String ownerName = rs.getString("owner_name");
            String ownerLastname = rs.getString("owner_lastname");

            CreditCard creditCard = new CreditCard(cardNumber, cvc, expirationDate, ownerName, ownerLastname);
            creditCard.setCreditCardId(creditCardId);
            creditCardsList.add(creditCard);

            System.out.println(creditCardId + ", "
                    + cardNumber + ", "
                    + cvc + ", "
                    + expirationDate + ", "
                    + ownerName + ", "
                    + ownerLastname);
        }
    } catch (SQLException e) {
        System.out.println("Error occurred while fetching all credit cards");
        e.printStackTrace();
    }
}

    public static CreditCard getCreditCardById(int creditCardId) {
        CreditCard creditCard = new CreditCard();
        String query = "SELECT * FROM credit_card WHERE credit_card_id = " + creditCardId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                creditCard.setCreditCardId(rs.getInt("credit_card_id"));
                creditCard.setCardNumber(rs.getString("card_number"));
                creditCard.setCvc(rs.getInt("cvc"));
                creditCard.setExpirationDate(rs.getDate("expiration_date"));
                creditCard.setOwnerName(rs.getString("owner_name"));
                creditCard.setOwnerLastname(rs.getString("owner_lastname"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching credit card by ID");
            e.printStackTrace();
        }

        return creditCard;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }
    
    
}
