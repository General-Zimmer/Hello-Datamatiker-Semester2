package peterson;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


public class TestBankAccount {
	@Getter
	private static final boolean[] flag = new boolean[2];
	@Getter
	@Setter
	private static int turn = 0;

	public static void main(String[] args) {
		flag[0] = false;
		flag[1] = false;


		BankAccount ba = new BankAccount();
		BankAccountTraad bat1 = new BankAccountTraad(ba);
		BankAccountTraad2 bat2 = new BankAccountTraad2(ba);

		bat1.start();
		bat2.start();

		try {
			bat1.join();
			bat2.join();
		} catch (InterruptedException e) {
			System.out.println(Arrays.toString(e.getStackTrace()));
		}

		System.out.println(ba.getBalance());
		}

}
