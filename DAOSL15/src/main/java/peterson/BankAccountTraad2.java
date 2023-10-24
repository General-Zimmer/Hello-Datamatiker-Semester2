package peterson;

public class BankAccountTraad2 extends Thread {

	private BankAccount ba;

	public BankAccountTraad2(BankAccount ba) {
		this.ba = ba;
	}

	public void run() {
		int i = 0;
		while (i < 4) {
			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			TestBankAccount.getFlag()[0] = true;
			TestBankAccount.setTurn(1);
			while (TestBankAccount.getFlag()[1] && TestBankAccount.getTurn() == 1) {
				try {
					this.sleep(10);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			ba.setBalance(100, "d");
			TestBankAccount.getFlag()[0] = false;
			i++;
		}
		System.out.println("Balancen er: " + ba.getBalance());
	}

}
