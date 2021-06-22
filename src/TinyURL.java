import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

//https://www.youtube.com/watch?v=igrx08gaBMA
public class TinyURL {
	
	String  charsetStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	final int base = charsetStr.length();
	AtomicInteger counter = new AtomicInteger(10);
	Map<Long, String> store = new HashMap<>();
	
	private long getNextNumber(){
		int countervalue = counter.incrementAndGet();
		long systemTime = Long.valueOf(""+ countervalue+ System.currentTimeMillis());
		
		System.out.println("Print get number" + systemTime + " Number " + countervalue);
		return systemTime;
	}
	
	private String convertAndGetBase62Code(long num){
		StringBuffer sb = new StringBuffer("");
		while (num>0){
			int remainder = (int)(num % base);
			sb.append(charsetStr.charAt(remainder));
			num = num/ base;
		}
		return sb.toString();
	}
	private String generateUrl (String URl){
		final long nextNumber = getNextNumber();
		String tinyUrl = convertAndGetBase62Code(nextNumber);
		store.put(nextNumber, URl);
		return tinyUrl;
	}

	private String reverseTinyUrl(String tinyUrl){
		long tinyURLId = convertToBase10(tinyUrl);
		return store.get(tinyURLId);
	}
	
	private long convertToBase10(String tinyUrl){
		long nbase10 = 0;
		char[] chars = new StringBuilder(tinyUrl).toString().toCharArray();
		for(int i= chars.length-1; i>=0; i--){
			int index = charsetStr.indexOf(chars[i]);
			nbase10 += index * (long)Math.pow(base, i);
		}
		return nbase10;
	}
	
	private String generateMany(){
		final long nextNumber = getNextNumber();
		String tinyUrl = convertAndGetBase62Code(nextNumber);
		return tinyUrl;
	}
	
	public static void main(String[] args) {
		
		TinyURL urlclass = new TinyURL();
		//1 Exa
		Set<String> urls = new HashSet<String>();
		
		for (int count =0; count<100; count++){
			String generatedSeq = urlclass.generateMany();
			urls.add(generatedSeq);
		}
		
		System.out.println("number of URLs " + urls.size());
		
		//Check Reverse logic
		
		String tinyURLs = urlclass.generateUrl("http://JC.com");
		System.out.println("1st Tiny URL generated " + tinyURLs);
		
		String original = urlclass.reverseTinyUrl(tinyURLs);
		System.out.println("get Original URL" + original);
		
		String tinyURLs2 = urlclass.generateUrl("http://JC1.com");
		System.out.println("2nd Tiny URL generated " + tinyURLs2);
		
		String original2 = urlclass.reverseTinyUrl(tinyURLs2);
		System.out.println("get Original URL" + original2);
		
		String tinyURLs1 = urlclass.generateUrl("http://JC.com");
		System.out.println("2nd Tiny URL generated " + tinyURLs);
		
		String original1 = urlclass.reverseTinyUrl(tinyURLs1);
		System.out.println("get Original URL" + original1);
		
		MathOperation mo = (a, b) -> a+b;
		
		System.out.println("adddition" + mo.operation(10, 11));
		
		System.out.println(disp());
		
	}
	

	private static String disp(){
		char [] base64 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random rn = new Random();
		
		StringBuilder sb = new StringBuilder();
		int number = 6;
		for(int i=0; i<=number; i++){
			sb.append(base64[rn.nextInt(base64.length)]);
		}
		
		System.out.println("Print Random String:  " + sb);
		return sb.toString();
	}
	
}
interface MathOperation {
    int operation(int a, int b);
 }