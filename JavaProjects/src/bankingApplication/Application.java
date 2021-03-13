package bankingApplication;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount obj1 = new BankAccount("XYZ", "BA001");
		obj1.showMenu();
	}
}

class BankAccount {
	int balance;
	int prevTranx;
	String custname;
	String custid;

	BankAccount(String cname, String cid) {
		custname = cname;
		custid = cid;
	}

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			prevTranx = amount;
		}
	}

	void withdraw(int amount) {
		if (amount != 0 && amount <= balance) {
			balance = balance - amount;
			prevTranx = -amount;
		} else {
			System.out.println("Insufficient Balance.");
		}
	}

	void getPrevTranx() {
		if (prevTranx < 0) {
			System.out.println("Withdrawn: " + Math.abs(prevTranx));
		} else if (prevTranx > 0) {
			System.out.println("Deposited: " + prevTranx);
		} else {
			System.out.println("No transaction occured");
		}
	}

	void showMenu() {
		char option = '\0';
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome " + custname);
		System.out.println("Your id is " + custid);
		System.out.println("\n");
		System.out.println("A.	Check Balance");
		System.out.println("B.	Deposit");
		System.out.println("C.	Withdraw");
		System.out.println("D.	Previous transaction");
		System.out.println("E.	Exit");

		do {
			System.out.println(
					"=========================================================================================================================================");
			System.out.print("Enter an Option: ");
			option = s.next().charAt(0);
			System.out.println(
					"*****************************************************************************************************************************************");
			System.out.println("\n");

			switch (option) {
			case 'A':
				System.out.println("-------------------------------------------");
				System.out.println("Current Balance = " + balance);
				System.out.println("-------------------------------------------");
				System.out.println("\n");
				break;
			case 'B':
				System.out.println("-------------------------------------------");
				System.out.println("Enter an amount to deposit : ");
				System.out.println("-------------------------------------------");
				int amount1 = s.nextInt();
				deposit(amount1);
				System.out.println("\n");
				break;
			case 'C':
				System.out.println("-------------------------------------------");
				System.out.println("Enter an amount to withdraw : ");
				System.out.println("-------------------------------------------");
				int amount2 = s.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
			case 'D':
				System.out.println("-------------------------------------------");
				getPrevTranx();
				System.out.println("-------------------------------------------");
				System.out.println("\n");
				break;
			case 'E':
				System.out.println(
						"**************************************************************************************************************************");
				break;

			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		} while (option != 'E');
		System.out.println("Thank you for using our services !!");
	}
}