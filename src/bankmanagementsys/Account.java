package bankmanagementsys;

public class Account implements Comparable<Account> {
	private static int idCounter = 1;
	private int accountId;
	private String accountHolderName;
	private String email;
	private String mobileNumber;
	private double balance;
	private boolean isActive;

	public Account(String accountHolderName, String email, String mobileNumber, double balance) {
		super();
		this.accountId = idCounter++;
		this.accountHolderName = accountHolderName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
		this.isActive = true;
	}

	@Override
	public String toString() {
		return "Account ID: " + accountId + "\nAccount Holder Name: " + accountHolderName + "\nEmail: " + email
				+ "\nMobileNumber: " + mobileNumber + "\nBalance: " + balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String name) {
		this.accountHolderName = name;
	}

	@Override
	public boolean equals(Object obj) {
		Account ac = (Account) obj;
		return this.mobileNumber.equals(ac.mobileNumber) && this.email.equals(ac.email);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + accountHolderName.hashCode();
		hash = 31 * hash + email.hashCode();
		return hash;
	}

	@Override
	public int compareTo(Account o) {
		return Double.compare(this.balance, o.balance);
	}

	public boolean isActive() {

		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}
}
