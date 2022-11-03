package DATABASE;
import java.sql.*;

import USER.User;

public class UserDb  {
    private static Connection connection;
    private Database database;
    private Statement statement;

    public UserDb() {
        database = new Database();
        
       try {
        connection = DriverManager.getConnection(database.getDbURL(),database.getDbUserName(),database.getDbPassword());
         statement = connection.createStatement();
        } catch (SQLException e) {
       
            e.printStackTrace();
        }
    }

    public  boolean addUserRecord(User user) throws SQLException{
        String Query = "insert into user values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getGender()+"','"+user.getMobileNumber()+"','"+user.getDateOfBirth()+"')";
        return statement.execute(Query);
    }
     
    public boolean deleteUserRecord(User user) throws SQLException{
        String Query = "delete from user where email="+user.getEmail();
        return statement.execute(Query);
    }

    // TODO methods
}
