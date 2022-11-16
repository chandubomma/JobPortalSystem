package MAIN;



public class Main{
   
    public static void main(String[] args) {
       String arg = commandArgs(args);
       if(arg!=null){
            switch(arg){
                case "help" : {
                    UserOutput.printHelp();
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

        }
        return null;
    }

}
