package Seugnwon;

import java.util.Scanner;

public class FactorialMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num;

		System.out.print("input: ");
		num = in.nextInt();

		System.out.println("loop Factorial(" + num + "): " + Factorial_loop(num));
		System.out.println("Recursion Factorial(" + num + "): " + Factorial_recursion(num));
	}

	private static int Factorial_loop(int n) {
		int sum = 1;
		for (int i = 1; i <= n; i++) { // 1부터 입력받은 값까지 반복. ex) n이 5이면 5 = 5 x 1, 5 = 5 * 2, 10 = 10 * 3 ... 이런 식
			sum *= i;
		}
		return sum;
	}

	private static int Factorial_recursion(int n) { // 재귀함수
		if (n <= 1) {
			return 1;
		} else {
			return n * Factorial_recursion(n - 1); // 자기 자신을 호출하며 연산
		}
	}
}
