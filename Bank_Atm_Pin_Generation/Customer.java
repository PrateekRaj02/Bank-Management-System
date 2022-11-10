package com.Bank_Atm_Pin_Generation;
import java.util.*;
public class Customer {
    long accountNo;
    String name;
    String accountType;
    float balance;
    float minBalance=1000.0f;
    long mobileNo;
    String emailId;
    int pin;
    Scanner sc=new Scanner(System.in);

     Customer(){
         while(true) {
             System.out.println("Enter your name:");
             this.name = sc.nextLine();
             if(this.name.length()<=30)
                 break;
             else
                 System.out.println("Name length can not be more than 30.");

         }
         this.accountNo=generateAccountNumber();
         System.out.println("Your account no:"+this.accountNo);
         this.pin=generatePin();
         System.out.println("Your PIN is:"+this.pin);
         while(true) {
             System.out.println("Enter your account type:(Saving/Current)");
             this.accountType = sc.next();
             if(this.accountType.equals("Saving") || this.accountType.equals("saving")||this.accountType.equals("Current")||this.accountType.equals("current"))
                 break;
             else
                 System.out.println("Please enter valid input.");
         }
         while(true){
             System.out.println("Enter your Initial balance:");
             this.balance=sc.nextFloat();
             if(this.balance>1000)
                break;
             else
                 System.out.println("Please enter amount grater then 1000.");
         }
        while(true) {
            System.out.println("Enter your mobile No:");
            this.mobileNo = sc.nextLong();
            String mobile=this.mobileNo+"";
            if(mobile.length()==10)
                break;
            else
                System.out.println("Enter the valid phone number.");
        }
        System.out.println("Enter your e-mail id:");
         this.emailId=sc.next();
    }
    void updateDetail(){
        this.setEmailId();
        this.setMobileNo();
    }

    void deposit(){
        long amount;
        System.out.println("Enter the amount to deposit:");
        amount=sc.nextLong();
        if(amount>50000){
            System.out.println("Enter your PAN card no:");
            String pan=sc.next();
        }
        this.balance += amount;
        System.out.println("Successfull deposit of amount "+amount);
    }

    void withdraw(){
        System.out.println("Enter the amount to withdraw:");
        float withdrawAmount=sc.nextFloat();
        if(withdrawAmount>50000) {
            System.out.println("Enter PAN number:");
            String panNo=sc.next();
        }
        if(withdrawAmount>this.balance-minBalance){
            System.out.println("Insufficient Fund");
        }else {
            this.balance -=withdrawAmount;
            System.out.println("Withdraw of "+withdrawAmount+" is successfull");
        }
    }


    void setMobileNo(){
        System.out.println("Enter your new mobile no:");
        this.mobileNo=sc.nextLong();
    }
    void setEmailId(){
        System.out.println("Enter your new email id:");
        this.emailId=sc.next();
    }
    static void printAll(ArrayList<Customer> detail){

         for(Customer e:detail){
             System.out.println(" Account no:"+e.accountNo+"\n"+" Name:"+e.name+"\n"+" Account type:"+e.accountType +"\n"+
                     " Balance:"+e.balance+"\n"+" Mobile No:" +e.mobileNo+"\n"+" Email-id:"+e.emailId+"\n");
         }


    }
    static void print(Customer e){
        System.out.println(" Account no:"+e.accountNo+"\n"+" Name:"+e.name+"\n"+" Account type:"+e.accountType +"\n"+
                " Balance:"+e.balance+"\n"+" Mobile No:" +e.mobileNo+"\n"+" Email-id:"+e.emailId+"\n");
    }

    long generateAccountNumber(){
         accountNo=(int)Math.floor(Math.random()*1000000000);
         return accountNo;
    }
    int generatePin(){
         pin=(int)Math.floor(Math.random()*10000);
            return pin;
    }

}
