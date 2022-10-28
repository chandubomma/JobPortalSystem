package USER.JOBSEEKER;

import USER.User;
public class JobSeeker extends User{
   private String qualification;
   private int work_experience;
    public JobSeeker (String firstName, String lastName, String email, String password, String gender, String mobileNumber,
    String dateOfBirth, String Qualification,int workexperience){
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        qualification=Qualification;
        work_experience=workexperience;
    }
    void setQualification(String Qualification){
      this.qualification=Qualification;
    }
    String getQualification(){
       return qualification; 
    }
    public void setWorkExperience(int work_experience) {
        this.work_experience = work_experience;
    }
    public int getWork_experience() {
        return work_experience;
    }
     @Override
    public boolean Login(String email ,String password) {
       if(this.getEmail().equals(email)){
         if(this.getPassword().equals(password)){
            return true;
         }
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

