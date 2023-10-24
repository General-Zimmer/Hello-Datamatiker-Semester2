package peterson;

public class BankAccountTraad extends Thread {

	private BankAccount ba;

	public BankAccountTraad(BankAccount ba) {
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
			TestBankAccount.getFlag()[1] = true;
			TestBankAccount.setTurn(0);
			while (TestBankAccount.getFlag()[0] && TestBankAccount.getTurn() == 0) {
				try {
					this.sleep(10);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			ba.setBalance(100, "c");
			TestBankAccount.getFlag()[1] = false;
			i++;
		}
		System.out.println("Balancen er: " + ba.getBalance());
	}

}
