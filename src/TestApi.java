import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestApi {

	public static void main(String[] args) {

		EvenOrOdd odd = new EvenOrOdd(false, "Odd");
		EvenOrOdd even = new EvenOrOdd(true, "Even");

		Thread oddThread = new Thread(odd);
		Thread evenThread = new Thread(even);
		oddThread.start();
		evenThread.start();
	}

}

class EvenOrOdd implements Runnable {

	public static Object obj = new Object();
	static int num = 10;
	boolean oddEven = false;
	int start = 1;

	public EvenOrOdd(boolean oddEven, String message) {
		this.oddEven = oddEven;
	}

	@Override
	public void run() {

		while (start <= num) {
			synchronized (obj) {
				try {
					if (start % 2 != 0) {
						System.out.println(start + " " + Thread.currentThread().getName());
						obj.wait();
					} else {
						System.out.println(start + " " + Thread.currentThread().getName());
						obj.notifyAll();
					}
					start++;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
