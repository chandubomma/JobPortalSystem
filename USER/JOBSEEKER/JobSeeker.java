package USER.JOBSEEKER;
import USER.User;
public class JobSeeker extends User{
   private String qualification;

    public JobSeeker (String firstName, String lastName, String email, String password, String gender, String mobileNumber,
    String dateOfBirth, String Qualification){
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        qualification=Qualification;
    }
    void setQualification(String Qualification){
      this.qualification=Qualification;
    }
    String getQualification(){
       return qualification; 
    }
     @Override
    public boolean Login(String email ,String password) {
       if(this.getEmail().equals(email)){
         if(this.getPassword().equals(password)){
            return true;
         }
            return false; 
       }
       else {
        System.out.println("Invalid Email");
       }
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

