package MAIN;

import java.sql.SQLException;

import DATABASE.AdministratorDb;
import USER.User;

public class Main{
   
    public static void main(String[] args) throws SQLException {
        
       String arg = commandArgs(args);
       if(arg!=null){
            switch(arg){
                case "help" : {
                    UserOutput.printHelp();
                    break;
                }
                case "login" : {
                    User user = AdministratorDb.getUser(args[1]);
                    if(user==null){
                        System.out.println("Invalid Credentials");
                        break;
                    }
                    if(user.Login(args[1],args[2] )){
                        System.out.println("Login Successful!");
                    }else{
                        System.out.println("Try Again!");
                    }
                    break;
                }
                case "login1" : {
                    String password = UserInput.scanPassword();
                    User user = AdministratorDb.getUser(args[1]);
                    if(user==null){
                        System.out.println("Invalid Credentials");
                        break;
                    }
                    if(user.Login(args[1], password)){
                        System.out.println("Login Successful!");
                    }else{
                        System.out.println("Try Again!");
                    }
                    break;
                }
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
        return null;
    }

}
