public class fibonacci_recursion {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.print(fibonacci(i));
			System.out.print(", ");
		}
	}

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return 1; // base cases
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2); // recursive step
		}
    }
    
}