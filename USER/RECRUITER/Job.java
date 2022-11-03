package USER.RECRUITER;

public class Job {
    private int id;
    private String jobtitle;
    private String location;
    private String company_name;
    private String description;
    private String pdate;
    private int no_of_vacancies;
    private String skill1;
    private String skill2;
    private String skill3;
    
    public Job(String jobtitle, String location, String company_name, String description, String pdate,int n_vacancy,String skill1,String skill2,String skill3) {
        this.jobtitle = jobtitle;
        this.location = location;
        this.company_name = company_name;
        this.description = description;
        this.pdate = pdate;
        this.no_of_vacancies = n_vacancy;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3; 
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompany_name() {
        return company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public String getSkill1() {
        return skill1;
    }
    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }
    public String getSkill2() {
        return skill2;
    }
    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }
    public String getSkill3() {
        return skill3;
    }
    public void setSkill3(String skill3) {
        this.skill3 = skill3;
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
    public String getPdate() {
        return pdate;
    }
    public void setPdate(String pdate) {
        this.pdate = pdate;
    }
    
}
