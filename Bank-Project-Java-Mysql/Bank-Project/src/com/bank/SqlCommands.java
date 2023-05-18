package com.bank;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.bank.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class SqlCommands {
	static long balance=0;
	public static String Name=null;
	public static int pass=0;
	public static String acc_no=null;
	public static String mob_no=null;
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection cm=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
		java.sql.Statement st=cm.createStatement();
		java.sql.PreparedStatement p=null;
		
		Scanner sc=new Scanner(System.in);
		Methods ac=new Methods();
		Methods M=new Methods();
		//PIN GENERATOR
		Random r1=new Random();
		Random r2=new Random();
		
		System.out.println("\n**********************************************************\n");
		System.out.println("\n                   <<*** WELCOME ***>>\n\nHope  you doing greate\n\n"
				+ "  \t\tMake your choice >>\n\n1] Account Validfication \n2] Bank transation ");
		int x12=0;
		try {
			x12=sc.nextInt();
			if(x12>5) {
				System.out.println("Invalid option !");
			}
		}catch(Exception e) {
			System.out.println("Invalid option");
		}
		switch (x12){
		case 1:
			for(int i=0;i<2;i++) {
				System.out.println("\n**********************************************************\n");
				System.out.println("  Choose your option  >>\n"
						+ "1] Bank Account Opening form\n2] Passbook \n3] Delete Current bank account\n"
						+ "4] Exit");
				int choose=0;
				try {
					choose=sc.nextInt();
					if(choose>6) {
						System.out.println("invalid Option\nChoose again");
						choose=sc.nextInt();
						if(choose>6) {
							System.out.println("Again invalid Option \nTry after a second");
							System.exit(choose);
						}
					}
				}
				catch(Exception e) {
					System.out.println("Invalid option");
				}
				switch(choose){
				case 1:
					int a=r1.nextInt(500);
					int b=r1.nextInt(500);
					int c=r1.nextInt(500);
					int d=r1.nextInt(500);
					int e=r1.nextInt(500);
					int number=a+b+c+d+e;
					int number2=0;
					int x=r2.nextInt(550);
					int y=r2.nextInt(550);
					int z=r2.nextInt(550);
					int l=r2.nextInt(550);
					int m=r2.nextInt(550);
					number2=x+y+z+l+m;
					if(number>1000) {
						pass=number;
					}if(number2>1000) {
						pass=number2;
					}
					//ACCOUNT NUMBER GENERATOR
					int a1=r1.nextInt(50000000);
					int b1=r1.nextInt(50000000);
					int c1=r1.nextInt(50000000);
					int d1=r1.nextInt(50000000);
					int e1=r1.nextInt(50000000);

					int x1=r2.nextInt(55000000);
					int y1=r2.nextInt(55000000);
					int z1=r2.nextInt(55000000);
					int l1=r2.nextInt(55000000);
					int m1=r2.nextInt(55000000);
					long a11=a1+c1+b1+d1+e1;
					long a12=x1+y1+z1+l1+m1;
					long j1=a11+a12;
					String acc1=Long.toString(j1);
					int lg=acc1.length();
					acc_no=acc1;

					M.addingData();
					String query="insert into bank_customer values('"+Name+"','"+acc_no+"','"+mob_no+"','"+balance+"','"+pass+"')";
				//	String query="insert into bank_customer values('Shyam','89745627','9874562345','500000','2525')";
					int k=st.executeUpdate(query);
					System.out.println(k+" - Your bank accouunt created ");
					System.out.println("Your Account number and Pin is generated \n"
							+ "PIN >> "+pass+"\nAccount Number >> "+acc_no);
					System.out.println("\n**********************************************************\n");
					break;
				case 2:
					System.out.println("Enter PIN >>");
					int pin=sc.nextInt();
					String sql = "select * from bank_customer where pass="+pin;
					p = cm.prepareStatement(sql);
					ResultSet rs = p.executeQuery();
					// Condition check
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						int balance=rs.getInt("balance");
						System.out.println("\n**********************************************************\n");
						System.out.println("\t\t***** WELCOME ******\n\nCustomer name >> "+name+"\n"
								+ "Account Number >> "+acc+"\n"
								+"Mobile Number >> "+mob+"\nCurrent Balance >> "+balance);
						System.out.println("Thanks For Visisting Mr/Miss "+name);
					}
					System.out.println("\t");
					break;
				case 3:
					System.out.println("Enter your account number >>");
					acc_no=sc.next();
					int k1=st.executeUpdate("delete from bank_customer where acc_no="+acc_no);
					System.out.println(k1+" Account Deleted !");
					break;
				case 4:
					System.out.println("Exiting");
					System.out.println("****** All Process done *****");
					break;
				case 5:
					try {
						String sql1 = "select * from bank_customer ";
						p = cm.prepareStatement(sql1);
						ResultSet rs1 = p.executeQuery();
						System.out.println("PIN\t\tName\t\t\tMobile\t\t\tAccount No\t\t\tBalance");
						while (rs1.next()) {
							int password = rs1.getInt("pass");
							String name = rs1.getString("name");
							long mob=rs1.getLong("mob_no");
							long acc=rs1.getLong("acc_no");
							int balance=rs1.getInt("balance");
							System.out.println(password + "\t\t" + name
									+ "\t\t" + mob+"\t\t"+acc+"\t\t\t"+balance);
						}
					}
					catch(SQLException h) {
						System.out.println(h);
					}
					System.out.println("\n\n ^^ Data");
					break;
				}
			}//1st for loop terminated
		case 2:
			System.out.println("\n\n************  ATM Machine1  ************* \n");
			System.out.println("If their is no Correct PIN message comes then PIN is Wrong !");
			System.out.println("Enter PIN >>");
			int pin=sc.nextInt();
			String sql = "select * from bank_customer where pass="+pin;
			p = cm.prepareStatement(sql);
			ResultSet rs = p.executeQuery();

			String sql1 = "select * from bank_customer where pass="+pin;
			p = cm.prepareStatement(sql1);
			ResultSet rs1 = p.executeQuery();
			while (rs1.next()) {
				int password = rs1.getInt("pass");
				String name = rs1.getString("name");
				long mob=rs1.getLong("mob_no");
				long acc=rs1.getLong("acc_no");
				int balance=rs1.getInt("balance");
				System.out.println(password);
				if(pin!=password) {
					System.out.println("Incorrect");
				}else if(pin==password){
					System.out.println("Correct PIN Good to go >>");
					break;
				}
			}
			System.out.println("\nEnter the option >>\n");
			System.out.println("1 - Deposite               2 - Withdraw");
			System.out.println("3 -Mini Statement         4 - Show Balance");
			System.out.println("5 - Update");
			int option=0;
			try {
				option=sc.nextInt();}
			catch(IllegalArgumentException e) {
				System.out.println("Invalid Option");
			}
			for(int i=0;i<2;i++) {
				switch(option) {
				case 1:
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						balance=rs.getInt("balance");
						System.out.println("balance > "+balance);
						System.out.println("Enter the amount for Deposite >> ");
						int add=sc.nextInt();
						if(add<1) {
							System.out.println("Invalid Amount !\nTry again");
						}
						else if(add>1000000) {
							System.out.println("You can't deposite that much money !");
						}
						else {
							balance+=add;
							System.out.println();
						}
						sql=" update bank_customer set balance="+balance+" where pass="+pin;
						int k=st.executeUpdate(sql);
						System.out.println("Current balance >> "+balance);
					}	
					break;
				case 2:
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						balance=rs.getInt("balance");
						System.out.println("balance > "+balance);
						System.out.println("Enter the amount for Withdraw >> ");
						int minus=sc.nextInt();
						int tot=0;
						if(balance<minus) {
							System.out.println("Bank balance is low can't withdraw");
						}
						else if(minus==balance) {
							System.out.println("You can't withdraw all amount from bank !");
						}
						else if(minus>1000000) {
							System.out.println("You can't Withdraw that much money !");
						}
						else if(minus<1){
							System.out.println("Low Number ! \n Try again ");
						}else {
							balance-=minus;
						}
						System.out.println("Current balance >> "+balance);
					}
					sql=" update bank_customer set balance="+balance+" where pass="+pin;
					int k=st.executeUpdate(sql);
					break;
				case 3:
					try {
						while (rs.next()) {
							String name = rs.getString("name");
							long mob=rs.getLong("mob_no");
							long acc=rs.getLong("acc_no");
							balance=rs.getInt("balance");
							System.out.println("\n**********************************************************\n");
							System.out.println("MINI Statatement ");
							System.out.println("Name >> "+name+"\nMob No >> "+mob+"\nBalance >> "+balance);
						}
					}catch(SQLException f) {
						System.out.println(f);
					}
					break;
				case 4:
					while (rs.next()) {
						String name = rs.getString("name");
						long mob=rs.getLong("mob_no");
						long acc=rs.getLong("acc_no");
						balance=rs.getInt("balance");
						System.out.println("Current balance >> "+balance);
					}
					break;
					
				case 5:
					System.out.println("\n\n************  ATM Machine2  ************* \n");
					System.out.println("If their is no Correct PIN message comes then PIN is Wrong !");
					System.out.println("Enter Your Old PIN  >>");
					int pin2=sc.nextInt();
					String sql2 = "select * from bank_customer where pass="+pin2;
					p = cm.prepareStatement(sql);
					ResultSet rs2 = p.executeQuery();

					String sql3 = "select * from bank_customer where pass="+pin2;
					p = cm.prepareStatement(sql3);
					ResultSet rs3 = p.executeQuery();
					while (rs3.next()) {
						int password = rs3.getInt("pass");
//						String name = rs3.getString("name");
//						long mob=rs3.getLong("mob_no");
//						long acc=rs3.getLong("acc_no");
//						int balance=rs3.getInt("balance");
						System.out.println(password);
						if(pin2!=password) {
							System.out.println("Incorrect");
						}else if(pin2==password){
							System.out.println("Correct PIN  >>");
							System.out.println("Please Enter Your New PIN  >>");
							int pin3=sc.nextInt();
							sql=" update bank_customer set pass="+pin3+" where pass="+pin;
							int k1=st.executeUpdate(sql);
							System.out.println("Your Password is Upadate Sucessfully....");
		     				System.out.println("Your New Password >>"+pin3);
		     				break;
						}
						break;
					}
					break;
//				case 5:
//					while (rs.next()) {
//						String name = rs.getString("name");
//						long mob=rs.getLong("mob_no");
//						long acc=rs.getLong("acc_no");
//						balance=rs.getInt("balance");
//						System.out.println("balance > "+balance);
//						System.out.println("Update Your Password >> ");
//						System.out.println("Please Enter Old Password");
//						int pin1=sc.nextInt();
//						if(pin1==pin) {
//							System.out.println("Enter New Password");
//							int pin2=sc.nextInt();
//							sql=" update bank_customer set pass="+pin2+" where pass="+pin;
//							int k1=st.executeUpdate(sql);
//							System.out.println("Your Password is Upadate Sucessfully....");
//							System.out.println("Your New Password >>"+pin2);
//							
//						}
//						else if(pin1!=pin) {
//							System.out.println("Enter Your Correct Password");
//						}
//						
//						}
//						
//					}	
//					break;
					//break;
				}//break;
			}
			System.out.println("\n**********************************************************\n");
			System.out.println("\n"
					+ "Thank you for visiting us ");
		}
	}
}
