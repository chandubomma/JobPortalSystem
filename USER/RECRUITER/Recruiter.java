package USER.RECRUITER;
import java.sql.SQLException;
import java.io.FileReader;  
import java.io.IOException;
import java.sql.SQLException;

import com.opencsv.CSVReader;
import DATABASE.RecruiterDb;
import USER.User;
import java.util.ArrayList;

public class Recruiter extends User {
    private String CompanyName;
    private String Designation;
    private ArrayList<Job> postedJobs = new ArrayList<>();
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


    public ArrayList<Job> getPostedJobs() {
        return postedJobs;
    }

    public void setPostedJobs() throws SQLException {
        this.postedJobs = recruiterDb.getJobsPosted(CompanyName);
    }

    @Override
    public boolean Register() throws SQLException {
    
        return(recruiterDb.addUserRecord(this) &&
        recruiterDb.addRecruiterRecord(this));
        
    }

    public boolean Register(String csvFilePath) throws SQLException {
        CSVReader reader = null; 
        try  
        {  
        reader = new CSVReader(new FileReader(csvFilePath));    
        String [] nL;  
        nL = reader.readNext();
        this.setFirstName(nL[0]);  
        this.setLastName(nL[1]);
        this.setEmail(nL[2]);
        this.setPassword(nL[3]);
        this.setGender(nL[4]);
        this.setMobileNumber(nL[5]);
        this.setDateOfBirth(nL[6]);
        this.setUserType("recruiter");
        this.setLoggedIn("true");
        this.setCompanyName(nL[7]);
        this.setDesignation(nL[8]);
           if(recruiterDb.addUserRecord(this)){
            if(recruiterDb.addRecruiterRecord(this))return true;
            else return false;
           }else return false;
           
        }  
        catch (Exception e)   
        {  
        e.printStackTrace(); 
        return false ;
        }  
        
        
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

    public static boolean addJobs(String pathCSV){
        CSVReader reader = null;  
        try  
        {  
        reader = new CSVReader(new FileReader(pathCSV));    
        String [] nL;  
        reader.readNext();
        //read one line at a time  
            while ((nL = reader.readNext()) != null)  
            {  
                int numberOfVacancies = Integer.parseInt(nL[5]);
                int maxage = Integer.parseInt(nL[7]);
                int minExperience = Integer.parseInt(nL[8]);
               Job job = new Job(nL[0],nL[1],nL[2],nL[3],nL[4],numberOfVacancies,nL[6],maxage,minExperience,nL[9]);
               if(recruiterDb.getJobRecord(job.getId())==null){
                recruiterDb.addJobRecord(job);
                System.out.println("Posted Job with ID = "+job.getId()+" : "+job.getJobTitle());
               }else{
                recruiterDb.updateJobRecord(job);
                System.out.println("updated Job Post with ID = "+job.getId()+" : "+job.getJobTitle());
               }
            }
            return true; 
        }  
        catch (Exception e)   
        {  
        e.printStackTrace(); 
        return false ;
        }  

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
    
       public boolean deleteJob(Job i) throws SQLException {
        postedJobs.remove(i);
        if(recruiterDb.deleteJobRecord(i.getId()) && recruiterDb.deleteRecruiterJob(this, i))
            return true;
        return false;
    }

    public boolean postJob(Job job) {
        return false;
    }
}

