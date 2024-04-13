package classes;

import db.operations.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String poster;
    private int productionYear;
    private String ageCategory;
    private Date addingDate;
    private int howLong;
    private String about;

    // Constructor, getters and setters
    
    static Connection connection = DatabaseConnection.getConnection();

    public void insertMovie() {
        try {
            String query = "INSERT INTO movie (title, poster, production_year, age_category, adding_date, how_long, about) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, this.title);
            statement.setString(2, this.poster);
            statement.setInt(3, this.productionYear);
            statement.setString(4, this.ageCategory);
            statement.setDate(5, new Date(Time.valueOf(LocalTime.now()).getTime()));
            statement.setInt(6, this.howLong);
            statement.setString(7, this.about);
            try {
                statement.executeUpdate();
            } catch (SQLException e) {
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateMovie(int id ,String title, String poster, int productionYear, String ageCategory, Date addingDate, int howLong, String about) {
        try {
            String query = "UPDATE movie SET title = ?, poster = ?, production_year = ?, age_category = ?,addingDate = ? how_long = ?, about = ? WHERE movie_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, poster);
            statement.setInt(3, productionYear);
            statement.setString(4, ageCategory);
            statement.setDate(5, (java.sql.Date) addingDate);
            statement.setInt(6, howLong);
            statement.setString(7, about);
            statement.setInt(8, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    public static void getAllMovie(){
        getMovieByQuery("SELECT * FROM movie");
    }
    
    
    public static void getMovieByQuery(String query) {
        List<Movie> movies = new ArrayList<>();
        try {
            
            
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("movie_id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setPoster(resultSet.getString("poster"));
                movie.setProductionYear(resultSet.getInt("production_year"));
                movie.setAgeCategory(resultSet.getString("age_category"));
                movie.setAddingDate(resultSet.getDate("adding_date"));
                movie.setHowLong(resultSet.getInt("how_long"));
                movie.setAbout(resultSet.getString("about"));
                movies.add(movie);
                System.out.println(movie.getId()+", "+
                        movie.getTitle()+", "+
                        movie.getPoster()+", "+
                        movie.getProductionYear()+", "+
                        movie.getAgeCategory()+", "+
                        movie.getAddingDate()+", "+
                        movie.getHowLong()+", "+
                        movie.getAbout());
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static Movie getMovieById(int movieId) {
        Movie movie = null;
        String query = "SELECT * FROM movie WHERE movie_id=" + movieId;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("movie_id"));
                movie.setTitle(rs.getString("title"));
                movie.setPoster(rs.getString("poster"));
                movie.setProductionYear(rs.getInt("production_year"));
                movie.setAgeCategory(rs.getString("age_category"));
                movie.setAddingDate(rs.getDate("adding_date"));
                movie.setHowLong(rs.getInt("how_long"));
                movie.setAbout(rs.getString("about"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching movie by ID");
            e.printStackTrace();
        }

        return movie;
    }

    
    
    
    
    
    
    
    
    
    public Movie(){
        
    }

    public Movie(String title, String poster, int productionYear, String ageCategory, Date addingDate, int howLong, String about) {
        this.title = title;
        this.poster = poster;
        this.productionYear = productionYear;
        this.ageCategory = ageCategory;
        this.addingDate = addingDate;
        this.howLong = howLong;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
    
    
    
}