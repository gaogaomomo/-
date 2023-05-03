package info2;

public class Series {
	// Exercise Task
	// 1.1 a)
	public static int sumUp(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		// TODO: fill me
		
		return result;
	}

	// Exercise Task
	// 1.2 b)
	public static void multiplicationTable(int n) {
		int result = 0;
		for (int i = 1; i <= 10; i++) {
			result = n * i;
			System.out.println(n + " x " + i + " = " + result);
		}
		// TODO: fill me

	}

	// Exercise Task
	// 1.3 c)
	public static void fizzBuzz() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
		// TODO: fill me
	}

	// Exercise Task
	// 1.4 d)
	public static void chessBoard(int n) {
		for (int i = 1; i <= n; i++) { //Zeilen
			for (int j = 1; j <= n; j++) { //Spalten
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
			     //wenn i,j beide gerade/ungerade sind
					if (j == n) {
						System.out.print("1\n");
					} else {
						System.out.print("1 ");
					}//Leerzeichen oder naechste Zeile
			    } else if ((i % 2 != 0 && j % 2 == 0) || (i % 2 == 0 && j % 2 != 0)) {
			     //wenn eine von i,j ungerade und andere gerade sind
			    	if (j == n) {
			    		System.out.print("0\n");
			    	} else {
			    		System.out.print("0 ");
			    	}
			    }
			}
		}
		// TODO: fill me
	}

	// Exercise Task
	// 1.5 e)
	public static int factorial(int n) {
		int result = 1;
		if (n == 0) {
			result = 1;
		} else {
			for (int i = 1; i <= n; i++) {
				result *= i;
			}
		}
		// TODO: fill me

		return result;
	}

	// Exercise Task
	// 1.6 f)
	public static double e(int n) {
		double result = 0;
		double term = 1.0;
		for (int i = 1; i <= n; i++) {
			term /= i;
			result += term;
		}
		// TODO: fill me
		result = result + 1;
		return result;
	}

	// Exercise Task
	// 1.7 g)
	public static void reverseDigits(int n) {
		
		while (n != 0) {
			int num = n % 10;
			System.out.println(num);
			n = n / 10;
		}
		// TODO: fill me
	}

	// Exercise Task
	// 1.8 h)
	public static double leibnizSeries(int n) {
		double res = 0;
		for (int i = 0; i <= n; i++) {
			double a = Math.pow((-1) , i) / (2 * i + 1);
			res += a;
		}
		// TODO: fill me
		res = 4 * res;
		return res;
	}

	public static void main(String[] args) {

		System.out.println("1.1 a) ");
		System.out.println(sumUp(10));

		System.out.println("1.2 b) ");
		multiplicationTable(4);

		System.out.println("1.3 c) ");
		fizzBuzz();

		System.out.println("1.4 d) ");
		chessBoard(4);

		System.out.println("1.5 e) ");
		System.out.println(factorial(4));

		System.out.println("1.6 f) ");
		System.out.println(e(100));

		System.out.println("1.7 g) ");
		reverseDigits(1239);

		System.out.println("1.8 h) ");
		System.out.println(leibnizSeries(1000));

	}
}
