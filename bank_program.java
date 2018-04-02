import java.io.*;

import java.util.Random;

class bank
{
 static String name,typeacc,phone;

 static int account_number,balance,amount,Withdraw,autho,pin;

 static void accept()throws Exception
 {

  DataInputStream ob=new DataInputStream(System.in);

 try
 {

  System.out.print("Enter Full Name :");

  name=ob.readLine(); 

  System.out.print("Enter Contact Number (10 digits) :");

  phone=ob.readLine();

  Random r=new Random();

  System.out.print("Type of account :");

  typeacc=ob.readLine();

  System.out.print("Enter balance :");

  balance=Integer.parseInt(ob.readLine());  

  account_number=r.nextInt(1000);
	
  System.out.println("\n\tAccount Created Successfully!");
  System.out.println("\n\t********************** NOTE **********************");
	
  System.out.println("\n\tYour unique account number :"+account_number);

  pin=r.nextInt(100);

  System.out.println("\n\tSystem generated Personal Identification Number (PIN):"+pin);

  System.out.println("\n\t********************************************");

 }//tryend

catch(Exception ex){}

}//catchend

 static void deposit()throws Exception
 {
  DataInputStream ob=new DataInputStream(System.in);

  System.out.print("\nEnter the amount you wish to Deposite :");

  amount=Integer.parseInt(ob.readLine());

  balance=balance+amount;

  System.out.println("Revised balance (post deposit) :"+balance);

 }

static void Withdra()throws Exception
 {
  DataInputStream ob=new DataInputStream(System.in);

  int lpp=0;

  re_enter:

  while(lpp==0)

  {

  System.out.print("\nEnter the amount you wish to Withdra :");

  Withdraw=Integer.parseInt(ob.readLine());

  if(Withdraw>=balance-100)

  {

   System.out.println("\tERROR !");

   System.out.println("Cannot Withdra ! Entered Amount exceeds Minimun balance.");

   System.out.println("\nPlease Re-enter !");

   continue re_enter;

  }
  else
  {
   balance=balance-Withdraw;

   System.out.println("Revised balance (post Withdraal) :"+balance);  

   lpp=1;
  }
 }
}

 static void display()
 {
   //DataInputStream ob=new DataInputStream(System.in);

   System.out.println("\n\tAccount holders details :\n");

   System.out.println("Name :"+name);
 
   System.out.println("Phone number :+91"+phone);

   System.out.println("Account number:"+account_number);

   System.out.println("Account type :"+typeacc);

   System.out.println("balance :"+balance);
 }

 static void forgotpass()throws Exception
 {
     DataInputStream ob=new DataInputStream(System.in);
     int cnt=0;
     System.out.println("\n\tForgot PIN ?");
     System.out.println("Authentication process");
     System.out.println("\nStep 1");
     System.out.print("\nEnter your Unique account Number :");
     int pinacc=Integer.parseInt(ob.readLine());
     
     if(pinacc==account_number)
     {
      System.out.println("\nStep 2");
      System.out.print("\nYour registered Mobile Number :");
      System.out.print("****");
      for(int j=4;j<10;j++)
      {
       System.out.print(phone.charAt(j));
      }
      System.out.print("\nEnter the FIRST 4 digits of your registered phone number :");
      String pinphone=ob.readLine();
      for(int jk=0;jk<4;jk++)
      { 
       if(pinphone.charAt(jk)==phone.charAt(jk))
      {
       cnt++; 
      }
      }
      if(cnt==4)
      {
       System.out.println("\nUser Authentication Successful");
       System.out.println("The PIN for your account is :"+pin);
      }
      else
      {
       //System.out.println(cnt);
       System.out.println("\nYour phone number DOES NOT MATCH");
      }
     }
     else
     {
      System.out.println("\nINVALID ACCOUNT NUMBER");
     }    
}

static void changeaccname()throws Exception
{
 DataInputStream ob=new DataInputStream(System.in);

     int namevar=0;

      namechange:

      while(namevar==0)
      {
      System.out.println("\nChange account name !\n");
      System.out.print("Enter new account name :");
      String fstattempt=ob.readLine();
      System.out.print("Re-Enter account name  :");
      String sndattempt=ob.readLine();

       if (fstattempt.equals(sndattempt))
       {
        namevar=1;
        name=fstattempt;
        System.out.println("\nAccount name changed Succesfully !");
      
       }
     
       else
       {
         System.out.println("\nStrings Mismatch\n");
         System.out.println("Re-enter correct strings to continue !\n");  
         continue namechange;
       } 
     }
}

//************************************************************************************************************************//

 public static void main(String args[])throws Exception
 {
  DataInputStream ob=new DataInputStream(System.in);

  int ch,inch;

  System.out.println("\n\t\f Welcome to BIAHR bank pvt.ltd \f\n ");

  System.out.println("New customer ?\t\tAlready have an account ?");

  System.out.println("Press 1 to SIGN-UP\tPress 2 to SIGN-IN  ");

  System.out.print("\n\t    You would like to ?  :");

  inch=Integer.parseInt(ob.readLine());

  switch(inch)

  {

   case 1:

   System.out.println("\nTo create a new account fill in the follwing details:");

   accept();

   System.out.println("\nAccount created succesfully !");

   case 2:

   int inside=0;

   relog:

   while(inside==0) //lable while
   {
   System.out.println("\n\tEnter Login details");

   System.out.print("\nEnter account number :");

   autho=Integer.parseInt(ob.readLine());

   System.out.print("\nEnter PIN :");

   int authopin=Integer.parseInt(ob.readLine());

  if(autho==9999 && authopin==6666)
  {
    System.out.println("\n\tWelcome ADMIN : Rohit Kumar : BIHAR");
    break;
  }

  else if(autho==account_number && pin==authopin)
  {
    System.out.println("\n\tAccess Granted !\n");

  do
  {

  inside=1;

  System.out.println("\nSelect any of the following Options");

  System.out.println("\n1.Deposit");

  System.out.println("2.Withdra");

  System.out.println("3.Display account Details");

  System.out.println("4.Settings");

  System.out.println("5.Exit");

  System.out.print("Enter your choice :");

  ch=Integer.parseInt(ob.readLine());

 switch(ch)
 {
     case 1:

     deposit();

     break;

     case 2:

     Withdra();

     break;

     case 3:

     display();
     
     break;

    case 4:
    int editopt;
    do
    {
    System.out.println("\n\n\tEdit your bank Details :\n");
    System.out.print("1.Change Account name ?");
    System.out.println("\t\t2.Forgot PIN ?");
    System.out.print("\n3.Need assistance ?");
    System.out.println("\t\t4.Back to the previous menu ?");
    System.out.print("\n\tEnter corresponding option :");
    editopt=Integer.parseInt(ob.readLine());
     
    switch(editopt)
    {
     case 1:
     changeaccname();
     break;     
       
     case 2:
     forgotpass();
     break;

     case 3:
     System.out.println("\nOur customer care executive will call you shortly on the following number :+91"+phone);
     break;

     case 4:
     inside=0;
     continue relog;

     default:
     System.out.println("Wrong option");
     break;
    } 
   }while(editopt!=4);

     break;

      case 5:

      System.out.println("\nThank you for Banking Withdraw us !");

      System.out.println("BIAHR bank pvt.ltd");

      break;

     default:

     System.out.println("Wrong choice");

     break;
  
  }  //switch

 }while(ch!=5);

}

else if(autho==account_number && pin!=authopin)

{

  System.out.println("You've entered the wrong PIN");

  System.out.println("Please Re-enter\n");

  continue relog;

}

else if(autho!=account_number && pin==authopin)

{

  System.out.println("You've entered the wrong Account Number");

  System.out.println("Please Re-enter\n");

  continue relog;

}

else

{

  System.out.print("\n\tAccess Denied !");
  System.out.println("\tINVALID Inputs !");
  inside=1;

}

}//while for label
 break;
}//outer switch// 

}//psvm//

}//class//

// THANK YOU.....('_').