package bankmanagementsys;

import java.util.Scanner;

public class Service {
	static Scanner sc = new Scanner(System.in);
	static AccountService service = new AccountService();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\nWelcome to Bank: \n");
			System.out.println(
					"\nPress: \n1 for Account Creation\n2 for Update Account\n3 for Disable Account\n4 To get All Account Holder's Details");
			switch (sc.nextInt()) {

			case 1 -> {
				if(add()==null) {
					System.out.println("User already Exist");
				}
				service.addAccount(add());
				
			}
			case 2 -> update();
			case 3 -> {
				System.out.println("Enter id to Disable");
				int id = sc.nextInt();
				if (service.disableAccount(id)) {
					System.out.println("ID "+id + " has been disabled");
				} else {
					System.out.println("Id Did not matched");
				}
			}
			case 4 ->service.getAllAccounts();
			default -> throw new IllegalArgumentException("Unexpected value: " + sc.nextInt());
			}
		}
	}
	static Account add() {
		System.out.println("Enter Account Holder name");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("Enter Mobile Number");
		String ph = sc.next();
		System.out.println("Enter Balance");
		double balance = sc.nextDouble();
		Account account = new Account(name, email, ph, balance);
		
		if(email.equals(account.getEmail())||(ph.equals(account.getMobileNumber())))
			return null;
		return account;
	}
	static void update() {
		System.out.println("Enter ID to Update");
		int id = sc.nextInt();
		System.out.println("Enter New name of Account Holder");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter new email");
		String email = sc.next();
		System.out.println("Enter new Mobile Number");
		String ph = sc.next();
		String st = service.updateAccount(id, name, email, ph);
		System.out.println(st);
	}
}
