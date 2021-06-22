
public class StringPattern {

	public static void main(String[] args) {
		String pLoginId = "jc@keynote.doo";
		
		String Str = new String("Welcome to Tutorialspoint.com");
		
			boolean isExcludedKeynoteTxn = pLoginId.matches("(.*)@keynote.doo") || pLoginId.matches("nkeyn_monitoring_region(.*)@walmart.com") ? true : false;
			
			
			
			//System.out.println(pLoginId.matches("(.*)Tutorials(.*)"));
			//System.out.println(pLoginId.matches("Welcome(.*)"));
			
			//System.out.println(pLoginId.matches("nkeyn_monitoring_region(.*)@walmart.com"));
			System.out.println("heloooo " + isExcludedKeynoteTxn);

	}

}
