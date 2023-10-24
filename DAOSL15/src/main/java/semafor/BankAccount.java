package semafor;

import lombok.Getter;

import java.util.concurrent.Semaphore;

public class BankAccount {

	private double balance;
	@Getter
	private final Semaphore sem = new Semaphore(1);
	public void setBalance(double amount, String action) {
		try {
			sem.acquire();
			if (action.equals("c")) {
				balance = balance + amount;
			}
			if (action.equals("d")){
				balance = balance - amount;
			}
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

	public double getBalance() {
		return balance;
	}
}
