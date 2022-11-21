package USER.RECRUITER;
import java.sql.SQLException;

import DATABASE.RecruiterDb;
import USER.User;

public class Recruiter extends User {
    private String CompanyName;
    private String Designation;
    private static RecruiterDb recruiterDb = new RecruiterDb();
    
    public Recruiter()
    {
        super.setUserType("recruiter");
    }
    
    public Recruiter(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
    }


    public Recruiter(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth, String userType, String isLoggedIn) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth, userType, isLoggedIn);
    }

    public Recruiter(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth, String userType, String isLoggedIn, String companyName,
            String designation) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth, userType, isLoggedIn);
        CompanyName = companyName;
        Designation = designation;
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
    
        return(recruiterDb.addUserRecord(this) &&
        recruiterDb.addRecruiterRecord(this));
        
    }
    
    @Override
    public boolean Login(String email, String password) throws SQLException{
        String userPassword = recruiterDb.getUserPassword(email);
        if(userPassword.equals(password)){
            this.setLoggedIn("true");
            recruiterDb.updateUserLoginStatus(getEmail(), isLoggedIn());
            return true;
        }
        else return false;
    }

    @Override
    public boolean Logout() throws SQLException {
        recruiterDb.updateUserLoginStatus(getEmail(),"false");
        return false;
    }

    @Override
    public boolean deleteUser() throws SQLException {
        return(recruiterDb.deleteUserRecord(this) && recruiterDb.deleteRecruiterRecord(this));
    
    }
    
    
    public void getDetails()
    {
    System.out.println("USER PROFILE :");
        System.out.println("NAME            : "+this.getFirstName()+" "+getLastName());
        System.out.println("DATE OF BIRTH   : "+this.getDateOfBirth());
        System.out.println("GENDER          : "+this.getGender());
        System.out.println("EMAIL           : "+this.getEmail());
        System.out.println("MOBILE NUMBER   : "+this.getMobileNumber());
        System.out.println("COMPANY NAME    : "+this.getCompanyName());
        System.out.println("DESIGNATION     : "+this.getDesignation());
    }
}

