import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		System.out.println("Enter dataa ");
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Print data " + scn.nextInt());
		
		Scanner scn1 = new Scanner(System.in);
		System.out.println("Print data " + scn1.nextInt());
	}

}
