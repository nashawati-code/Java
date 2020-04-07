import java.io.File;

public class mystery_recursion {
	public static void main(String[] args) {
		System.out.println(mystery2(348));
		System.out.println(mystery(648));
	}

	private static int mystery(int n) {
		if (n < 10) {
			return n;
		} else {
			int a = n / 10;
			int b = n % 10;
			return mystery(a + b);
		}
	}

	public static int mystery2(int n) {
		if (n < 10) {
			return (10 * n) + n;
		} else {
			int a = mystery2(n / 10);
			int b = mystery2(n % 10);
			return (100 * a) + b;
		}
	}
}