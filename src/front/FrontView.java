package front;

public class FrontView {

    public void frontDesign(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                          1. Login                                │");
        System.out.println("│                          2. Register                             │");
        System.out.println("│                          3. Find ID/PWD                          │");
        System.out.println("│                          4. ID/PWD Delete                        │");
        System.out.println("│                          5. Program Off                          │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void reg_afterfront(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                          1. Login                                │");
        System.out.println("│                          2. Find ID/PWD                          │");
        System.out.println("│                          3. ID/PWD Delete                        │");
        System.out.println("│                          4. Program Off                          │");
        System.out.println("└─────────────────────────────────┘");

    }



    public void login_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                     !!   ID & PWD input  !!                      │");
        System.out.println("└─────────────────────────────────┘");

    }
    public void register_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                     !!  ID & PWD register  !!                    │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void find_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                        !!  Find ID & PWD  !!                     │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void Off_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                 !!  Program Off - Good Bye  !!                  │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void error_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                    !!  Select Number Error  !!                  │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void complete_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                      !!  Become a Member  !!                    │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void existing_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                   !!  Already existing ID  !!                   │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void pwderror_front(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                            PWD Error!!                           │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void success_login(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                        !!  Login Success  !!                     │");
        System.out.println("└─────────────────────────────────┘");

    }

    public void nonId_login(){

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│                       !!  Not existing ID  !!                    │");
        System.out.println("│                       --> Register ID & PWD                      │");
        System.out.println("└─────────────────────────────────┘");

    }



}
