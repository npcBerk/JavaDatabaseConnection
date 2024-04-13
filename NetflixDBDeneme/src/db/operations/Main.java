package db.operations;

import classes.*;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class Main {
    private Date date ;
    public static void main(String[] args) throws SQLException {
        /*
        Movie film = new Movie("Inception", "", 2010, "Adult" ,new java.sql.Date(Time.valueOf(LocalTime.now()).getTime()), 148,
                "A thief, who steals corporate secrets through the use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.");
        film.insertMovie();
        
        Movie.getAllMovie();
        Movie.getMovieByQuery("select * from \"movie\" where title like 'I%'");
        */
        
        
        //Bu kısımda serie classına yeni veri ekleyip select işlemiyle görüntülüyoruz.
        
        /*
        Serie dizi = new Serie("Yeni dendfdsfsdeme", "poser",2024 ,"Adult",1 );
        Serie.addSerie(dizi);
        Serie.getAllSeries();
        
        Serie.getAllSeriesById(5);
      
        Serie.updateSerie(dizi,11);
        Serie.getAllSeries();
        
        */
        
        
        /*
        User.getAllUsers();
        User.getUserByID(1);
        User kullanıcı1 = new User("Yeni kullanıcı", true, "password", 19, 1, "phoneNumber");
        User.addUser(kullanıcı1);
        User.getAllUsers();
        */
        
        
        
       
       /*
       Actor.getAllActors();
       System.out.println("****************************");
       CreditCard.getAllCreditCards();
       System.out.println("****************************");
       Episode.getAllEpisodes();
       System.out.println("****************************");
       Genre.getAllGenres();
       System.out.println("****************************");
       Movie.getAllMovie();
       System.out.println("****************************");
       MovieActors.getAllMovieActors();
       System.out.println("****************************");
       MovieGenre.getAllMovieGenres();
       System.out.println("****************************");
       Payment.getAllPayments();
       System.out.println("****************************");
       PaymentMethod.getAllPaymentMethods();
       System.out.println("****************************");
       PaymentPlans.getAllPaymentPlans();
       System.out.println("****************************");
       Serie.getAllSeries();
       System.out.println("****************************");
       SerieGenre.getAllSerieGenres();
       System.out.println("****************************");
       SeriesActors.getAllSeriesActors();
       System.out.println("****************************");
       User.getAllUsers();
       System.out.println("****************************");
       UserPaymentMethod.getAllUserPaymentMethods();
       System.out.println("****************************");*/
       //WatchedContent.getWatchedContentByUser(1);

       /*
       WatchedContent k = new WatchedContent(Movie.getMovieById(1)
               ,User.getUserById(1), Serie.getSerieById(1));
       WatchedContent.addWatchedContent(k);
       WatchedContent.getWatchedContentByUser(1);
       
       */
        
    }
}