import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {

	public static void main(String[] args) {
		AtomicLong atomicLong = new AtomicLong(30);


		System.out.println(atomicLong.getAndAdd(10));
		System.out.println(atomicLong.addAndGet(10));
	}

}
