import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPatternMatches {

	public static void main(String[] args) {

		String text = "keynotek5ipvt@keynote.doo";
		String text2 = "nkeyn_monitoring_region5@walmart.com";

		String patternString = "(.*)@keynote.doo";
		String patternString2 = "nkeyn_monitoring_region(.*)@walmart.com";

		Pattern pattern = Pattern.compile(patternString);
		Pattern pattern2 = Pattern.compile(patternString2);

		Matcher matcher = pattern.matcher(text);
		System.out.println("Matches " + matcher.matches());

		Matcher matcher2 = pattern2.matcher(text2);
		System.out.println("Matches " + matcher2.matches());
	}

}
