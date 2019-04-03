package front;

public class FrontView {

    public static void frontDesign(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                          1. Login                                │");
        System.out.println("│                          2. Register                             │");
        System.out.println("│                          3. Find ID/PWD                          │");
        System.out.println("│                          4. ID/PWD Delete                        │");
        System.out.println("│                          5. Program Off                          │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void reg_afterfront(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                          1. Login                                │");
        System.out.println("│                          2. Find ID/PWD                          │");
        System.out.println("│                          3. ID/PWD Delete                        │");
        System.out.println("│                          4. Program Off                          │");
        System.out.println("└─────────────────────────────────┘");

    }



    public static void login_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                     !!   ID & PWD input  !!                      │");
        System.out.println("└─────────────────────────────────┘");

    }
    public static void register_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                     !!  ID & PWD register  !!                    │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void find_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                        !!  Find ID & PWD  !!                     │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void Off_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                 !!  Program Off - Good Bye  !!                   │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void error_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                    !!  Select Number Error  !!                   │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void complete_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                      !!  Become a Member  !!                     │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void existing_ID(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                   !!  Already existing ID  !!                    │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void existing_name(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                  !!  Already existing Name  !!                   │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void existing_email(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                 !!  Already existing E-mail  !!                  │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void pwderror_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                            PWD Error!!                           │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void success_login(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                        !!  Login Success  !!                     │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void nonId_login(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                       !!  Not existing ID  !!                    │");
        System.out.println("│                       --> Register ID                            │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void nonName_login(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                 !!  Not existing Name / E-mail  !!               │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void existIDPWD(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                   !!  Here is your ID and Pwd.  !!               │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void NonremoveID(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                 !!  There is no such information  !!             │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void removefront(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│           !!  Enter the member information to delete  !!         │");
        System.out.println("└─────────────────────────────────┘");

    }

    public static void removeData(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│               !!  Delete the entered information  !!             │");
        System.out.println("└─────────────────────────────────┘");

    }


}
