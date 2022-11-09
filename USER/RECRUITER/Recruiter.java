package USER.RECRUITER;

import USER.User;

public class Recruiter extends User {
    private String compnay_name;
    private String designation;

    public Recruiter(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
       super.setUserType("recruiter");
    }
     
   

    @Override
    public boolean Register() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Logout() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Login(String email, String password) {
        // TODO Auto-generated method stub
        return false;
    }
    



    
}
