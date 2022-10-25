package USER.ADMINISTRATOR;

import java.util.ArrayList;

import USER.User;
/*
 * Administrator class inherits User class
 */

public class Administrator extends User{
    private String AdministratorKey;

    public Administrator(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth, String administratorKey) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        AdministratorKey = administratorKey;
    }

    @Override
    public boolean Login() {
        // TODO 
        return false;
    }

    @Override
    public boolean Register() {
        // TODO
        return false;
    }

    @Override
    public boolean Logout() {
        // TODO 
        return false;
    }

    @Override
    public boolean deleteUser() {
        // TODO 
        return false;
    }

    public String getAdministratorKey() {
        return AdministratorKey;
    }

    public void setAdministratorKey(String administratorKey) {
        AdministratorKey = administratorKey;
    }
    /* methods, a administrator has access to do  */
    public ArrayList<User> getAllUserList(){
      
        //TODO
        return null;
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
