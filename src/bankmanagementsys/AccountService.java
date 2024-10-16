package bankmanagementsys;

import java.util.TreeSet;

public class AccountService {
	    private TreeSet<Account> accounts = new TreeSet<Account>();
	    public void addAccount(Account account) {
//	    	if(accounts.contains(account)) {
//	    		System.out.println("Already Exist");
//	    		return;
//	    	}
	    	accounts.add(account);
	    }
	    public String updateAccount(int id, String newName, String newEmail, String newMobileNumber) {
	        for (Account account : accounts) {
	            if (account.getAccountId() == id) {
	                account.setAccountHolderName(newName);
	                account.setEmail(newEmail);
	                account.setMobileNumber(newMobileNumber);
	                return "Account ID: "+id+" Updated";
	            }
	        }
	        return "Since Account ID: "+id+" is not matching with database hence it can't be updated";
	    }
	    public boolean disableAccount(int accountId) {
	        for (Account account : accounts) {
	            if (account.getAccountId() == accountId) {
	                account.setActive(false);
	                return true;
	            }
	        }
	        return false;
	    }
	    public void getAllAccounts() {
	    	if(accounts.isEmpty()) {
	    		System.out.println("There is NO data present in data Base");
	    	}
	    	else {
	    		System.out.println("Account Holders ppresent in Data Base: ");
	    		for (Account account : accounts) {
		    		System.out.println(account);
		        }
	    	}
	    }
	}