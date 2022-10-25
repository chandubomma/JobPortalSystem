package USER;

public abstract class User{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String mobileNumber;
    private String dateOfBirth;
    public User(String firstName, String lastName, String email, String password, String gender, String mobileNumber,
            String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
                + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", dateOfBirth=" + dateOfBirth + "]";
    }
    public abstract boolean Login();
    public abstract boolean Register();
    public abstract boolean Logout();
    public abstract boolean deleteUser();
    
}