package DATABASE;
import java.sql.*;

import USER.User;

public class UserDb  {
    private  Connection connection;
    private  Database database;
    protected  Statement statement;
    protected   ResultSet resultSet;

    public UserDb() {
        database = new Database();
        
       try {
       
        connection = DriverManager.getConnection(database.getDbURL(),database.getDbUserName(),database.getDbPassword());
         statement = connection.createStatement();
        } catch (SQLException e) {
       
            e.printStackTrace();
        }
    }

    public   boolean addUserRecord(User user) throws SQLException{
        String Query = "insert into user values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getGender()+"','"+user.getMobileNumber()+"','"+user.getDateOfBirth()+"','"+user.getUserType()+"','"+user.isLoggedIn()+"')";
        return statement.execute(Query);
    }
     
    public  boolean deleteUserRecord(User user) throws SQLException{
        String Query = "delete from user where email="+user.getEmail();
        return statement.execute(Query);
    }

    public  String getUserPassword(String email) throws SQLException{
        String Query = "select password from user where email = '"+email+"'";
        resultSet = statement.executeQuery(Query);
        return(resultSet.getString("password"));
    }
}
