package USER.ADMINISTRATOR;

import java.sql.SQLException;
import java.util.ArrayList;

import DATABASE.AdministratorDb;
import USER.User;
/*
 * Administrator class inherits User class
 */
import USER.JOBSEEKER.JobSeeker;

public class Administrator extends User{
    private String AdministratorKey;
    private  static AdministratorDb administratorDb = new AdministratorDb();

    public Administrator(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth, String administratorKey) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        AdministratorKey = administratorKey;
    }

    @Override
    public boolean Login (String email, String password) {
         
        return false;
    }

    @Override
    public boolean Register() throws SQLException {
       
        return(administratorDb.addUserRecord(this) &&
        administratorDb.addAdministratorRecord(this));
    }

    @Override
    public boolean Logout() {
        // TODO 
        return false;
    }

    @Override
    public boolean deleteUser() throws SQLException {
        return(administratorDb.deleteUserRecord(this) && administratorDb.deleteAdministratorRecord(this));
    }

    public String getAdministratorKey() {
        return AdministratorKey;
    }

    public void setAdministratorKey(String administratorKey) {
        AdministratorKey = administratorKey;
    }
    /* methods, a administrator has access to do  */
    public ArrayList<JobSeeker> getAllJobSeekerList() throws SQLException{
       return administratorDb.getAllJobSeekers();
    }

    public boolean approveUser(User user){
        //TODO
        return false;
    }
    public boolean removeUser(User user){
        //TODO
        return false;
    }

    /*more methods to add come here */
}
