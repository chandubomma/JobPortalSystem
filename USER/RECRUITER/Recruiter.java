package USER.RECRUITER;

import USER.User;

public class Recruiter extends User {
   

    public Recruiter(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        //TODO Auto-generated constructor stub
    }
     
    @Override
    public boolean Login() {
        // TODO Auto-generated method stub
        return false;
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
    



    
}
