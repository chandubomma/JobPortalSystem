package MAIN;

import java.sql.SQLException;

import DATABASE.UserDb;
import USER.User;

public class Main{
   private static UserDb userDb = new UserDb();
   private static User user;

    public static void main(String[] args) throws SQLException {
       if(args.length==0)userMenu();
       else userMenu(args);
    }


    public static void userMenu() throws SQLException{
      
            UserOutput.printUserLoginMenu();
            int choice = UserInput.scanChoice();
            switch(choice){
                case 1 : {
                   user= login();
                   if(user.getUserType().toLowerCase().equals("jobseeker"))jobSeekerMenu();
                    else if(user.getUserType().toLowerCase().equals("recruiter"))recruiterMenu();
                   else if(user.getUserType().toLowerCase().equals("administrator"))administratorMenu();
                   break;
                }
                case 2 : {

                }
                
                case 0 : {
                     return;
                }
            }
        
    }

    public static void jobSeekerMenu(){
        UserOutput.printJobSeekerMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            
        }
    }

    public static void recruiterMenu(){
        UserOutput.printRecruiterMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            
        }
    }

    public static void administratorMenu(){
        UserOutput.printAdministratorMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            
        }
    }

    public static void userMenu(String[] args) throws SQLException{
        String arg = commandArgs(args);
        switch(arg){
            case "help" : {
                UserOutput.printHelp();
                break;
            }
            case "login" : {
              user = login(args);
                break;
            }
            case "login1" : {
               user = login1(args);
                break;
            }
        }
    }

    public static String commandArgs(String[] args){
        if(args.length == 0)return null;
        else if(args.length == 1){
            if(args[0].toLowerCase().equals("help"))return "help";
        }
        else if(args.length == 2){
            if(args[0].toLowerCase().equals("login"))return "login1";
        }
        else if(args.length==3){
            if(args[0].toLowerCase().equals("login"))return "login";
        }
        return null;
    }

    public static User login() throws SQLException{
        String email = UserInput.scanEmail();
        String password = UserInput.scanPassword();
        User user = userDb.getUser(email);
        if(user==null){
            System.out.println("Invalid Credentials");
           
        }
        if(user.Login(email,password )){
            System.out.println("Login Successful!");
            
        }else{
            System.out.println("Wrong Password! Try Again!");
        }
        return user;
    }

    

    public static User login(String[] args) throws SQLException{
        User user = userDb.getUser(args[1]);
        if(user==null){
            System.out.println("Invalid Credentials");
           
        }
        if(user.Login(args[1],args[2] )){
            System.out.println("Login Successful!");
            
        }else{
            System.out.println("Try Again!");
        }
        return user;
    }


    public static User login1(String[] args) throws SQLException{
        String password = UserInput.scanPassword();
        User user = userDb.getUser(args[1]);
        if(user==null){
            System.out.println("Invalid Credentials");
        
        }
        if(user.Login(args[1], password)){
            System.out.println("Login Successful!");
        }else{
            System.out.println("Try Again!");
        }
        return user;
    }

}
