package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String DELIMITER = ", ";

	public static double inputPurchaseMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = scanner.nextLine();
		validate(input);
		return Double.parseDouble(input);
	}

	public static String[] inputSixNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String input = scanner.nextLine();
		validate(input);
		return input.split(DELIMITER);
	}

	public static String inputBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		String input = scanner.nextLine();
		validate(input);
		return input;
	}

	private static void validate(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력이 없습니다.");
		}
	}
}