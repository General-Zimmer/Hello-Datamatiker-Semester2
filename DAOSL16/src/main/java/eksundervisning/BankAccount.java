package eksundervisning;

public class BankAccount {

	private double balance;

	public synchronized void credit(double amount) {
		balance = balance + amount;
		System.out.println("credit er: " + balance);
		this.notify();
	}

	public synchronized void debit(double amount) {
		if ((balance - amount) >= 0) {
			balance = balance - amount;
			System.out.println("debit er: " + balance);
		} else {
			try {
				this.wait();
				System.out.println("Venter");
				if ((balance - amount) >= 0) {
					balance = balance - amount;
					System.out.println("debit er: " + balance);
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public double getBalance() {
		return balance;
	}
}
