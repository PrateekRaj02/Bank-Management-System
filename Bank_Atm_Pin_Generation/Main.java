package com.Bank_Atm_Pin_Generation;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Customer> detail=new ArrayList<>();

        int choice;
        do{
            System.out.println("-------Select the choices-------");
            System.out.println("1.Add new customer");
            System.out.println("2.Update customer details");
            System.out.println("3.Delete a customer");
            System.out.println("4.Deposit money into customer account");
            System.out.println("5.Withdraw money from customer account");
            System.out.println("6.Check Balance");
            System.out.println("7.List of all customer in the bank");
            System.out.println("8.Customer details of a specific customer");
            System.out.println("9.Transfer money");
            System.out.println("10.Exit");
            choice=sc.nextInt();
            switch (choice){
                case 1:Customer newcustomer=new Customer();
                        detail.add(newcustomer);
                        break;
                case 2:
                    System.out.println("Enter your account no:");
                    long acc=sc.nextLong();
                    boolean check=false;
                    for(Customer e:detail){
                        if(acc==e.accountNo){
                            check=true;
                            e.updateDetail();
                            System.out.println("Sucsessfull");
                        }
                    }
                    if(!check)
                        System.out.println("Please enter valid Account no.");
                    break;

                case 3:
                    System.out.println("Enter account no for deletion:");
                    acc= sc.nextLong();
                    check=false;
                    for(Customer e:detail){
                        if(acc==e.accountNo){
                            check=true;
                            detail.remove(e);
                            System.out.println("Account no "+acc+" is deleted from record.");
                            break;
                        }
                    }
                    if(!check)
                        System.out.println("Please enter valid Account no.");
                    break;
                case 4:
                    System.out.println("Enter your account no:");
                    acc=sc.nextInt();
                    check=false;
                    for(Customer e:detail){
                        if(acc==e.accountNo){
                            e.deposit();
                            check=true;
                            break;
                        }
                    }
                    if(!check)
                        System.out.println("Please enter valid Account no.");
                    break;
                case 5:
                    System.out.println("Enter your account no:");
                    acc=sc.nextInt();
                    check=false;
                    for(Customer e:detail){
                        if(acc==e.accountNo){
                            check=true;
                            e.withdraw();
                        }
                    }
                    if(!check)
                        System.out.println("Please enter valid Account no.");
                    break;
                case 6:
                    System.out.println("Enter your account no:");
                    acc=sc.nextLong();
                    check=false;
                    for(Customer e:detail){
                        if(acc==e.accountNo){
                            check=true;
                            System.out.println("Your account Balance:"+e.balance);
                            break;
                        }
                    }
                    if(!check)
                    System.out.println("Please enter valid Account no.");
                    break;

                case 7:
                    Customer.printAll(detail);
                    break;
                case 8:
                    System.out.println("Enter your account no:");
                    acc=sc.nextLong();
                    check=false;
                    for(Customer e:detail){
                        if(acc==e.accountNo){
                            check=true;
                            Customer.print(e);
                            break;
                        }
                    }
                    if(!check)
                    System.out.println("Account number not found.");
                    break;
                case 9:
                    System.out.println("Enter your account no:");
                    acc=sc.nextLong();
                    System.out.println("Enter the amount to transfer:");
                    float transferAmount=sc.nextFloat();
                    for(Customer e:detail){
                        if(acc==e.accountNo){
                            float amo=e.balance-1000;
                            if(amo>=transferAmount){
                                e.balance-=transferAmount;
                                System.out.println("Transferred Amount successfully.");
                            }
                            else{
                                System.out.println("Fund cannot be transfer.");
                            }
                        }
                    }
                    break;
                case 10:
                    System.out.println("Thanks");
                    System.exit(0);
                default:
                    System.out.println("Enter the valid input.");
            }
        }while(true);
    }
}
