package com.bank;


import java.util.Scanner;

public class Methods {

	Scanner sc=new Scanner(System.in);
	private static double balance;
	private String name;
	private long acc_no;
	private String id;
	private String mob_no;

	
      public Methods(double balance, String name, long acc_no, String  id, String mob_no) {
		super();
		Methods.balance = balance;
		this.name = name;
		this.acc_no = acc_no;
		this.id = id;
		this.mob_no = mob_no;
	}
	public Methods() {

	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		SqlCommands.balance = balance;
	}
	public void showBalance() {
		System.out.println("Your Cureent Balance >>" +SqlCommands.balance);
	}
	public void miniStatement() {
		System.out.println("\n********** Mini Statement *********\n" +
				" "+"\n1] Name = "+name+"\n2]Account Number = "+acc_no+"\n"
				+ "3] Customer I'D = "+id+"\n4]Mobile Number = "+
				mob_no+"\n");
	}
	public  void addingData() {
		System.out.println("Bank Application form -\n"
				+ "Enter the details");
		System.out.println("Enter Name >>");
		String Name=sc.nextLine();

		SqlCommands.Name=Name;
		System.out.println("Creating your 8 digit account number automatically >>");
//		String account_no=sc.next();
//		SqlCommands.acc_no=account_no;
		System.out.println("Enter your mobile number >>");
		
		String mob_no1=sc.next();
		System.out.println("Creating Your PIN >> ");
//		int pass=sc.nextInt();
//		SqlCommands.pass=pass;
		int ln=mob_no1.length();
		if(ln<10) {

			System.out.println("Invalid number\n"
					+ "Your Accounting Process is failed");
			System.exit(ln);

		}
		else if(ln>11) {
			System.out.println("Invalid number\n"
					+ "Your Accounting Process is failed");
			System.exit(ln);
		}else {
			SqlCommands.mob_no=mob_no1;
		}
		System.out.println("Add your initial balance >>");
		long balance1=sc.nextLong();
		SqlCommands.balance=balance1;
	}


}

