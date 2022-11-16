package USER.RECRUITER;
import java.sql.SQLException;

import DATABASE.RecruiterDb;
import USER.User;

public class Recruiter extends User {
    private String CompanyName;
    private String Designation;
   
    public Recruiter(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
    }


    public Recruiter(String companyName,String designation,String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
       super.setUserType("recruiter");
       this.CompanyName=companyName;
       this.Designation=designation;
    }
     

    public String getCompanyName() {
        return CompanyName;
    }



    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }



    public String getDesignation() {
        return Designation;
    }



    public void setDesignation(String designation) {
        this.Designation = designation;
    }


    @Override
    public boolean Register() throws SQLException {
    
        return(RecruiterDb.addUserRecord(this) &&
        RecruiterDb.addRecruiterRecord(this));
        
    }
    
    @Override
    public boolean Login(String email, String password) throws SQLException{
        String userPassword = RecruiterDb.getUserPassword(email);
        if(userPassword.equals(password)){
            this.setLoggedIn(true);
            RecruiterDb.updateUserLoginStatus(getEmail(), isLoggedIn());
            return true;
        }
        else return false;
    }

    @Override
    public boolean Logout() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser() throws SQLException {
        return(RecruiterDb.deleteUserRecord(this) && RecruiterDb.deleteRecruiterRecord(this));
    
    }
}

