
public class PerfectNumber {

	public static void main(String[] args) {

		int number = 28;
		int temp = 0;
		
		MyLambda code = (num) -> num*2;
		System.out.println("mul" + code.multiply(4));
		
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				temp = temp + i;
			}
		}
		if (temp == number) {
			System.out.println(" true ");
		} else {
			System.out.println(" false ");
		}
	}

}

interface MyLambda {
	int multiply(int a);
}
