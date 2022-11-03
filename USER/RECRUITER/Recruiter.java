package USER.RECRUITER;

import USER.User;
class Job {
    private int id;
    private String jobtitle;
    private String location;
    private String company_name;
    private String description;
    private String deadline;
    private int no_of_vacancies;
    private String skill;
 
    
    public Job(String jobtitle, String location, String company_name, String description, String deadline,int n_vacancy,String skill) {
        this.jobtitle = jobtitle;
        this.location = location;
        this.company_name = company_name;
        this.description = description;
        this.deadline = deadline;
        this.no_of_vacancies = n_vacancy;
        this.skill = skill;

    }
    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
    public String getjobTitle() {
        return jobtitle;
    }
    public void setjobTitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getcompany_name() {
        return company_name;
    }
    public void setcomapny_name(String company_name) {
        this.company_name = company_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDeadline() {
        return deadline;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
  }
public class Recruiter extends User {
    private String company_name;
    private String designation;

    public Recruiter(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth,String CompanyName,String Designation) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        company_name = CompanyName;
        designation = Designation;
        
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
