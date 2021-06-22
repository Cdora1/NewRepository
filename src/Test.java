public class Test {

	public static void main(String[] args) {

		// int nums[] = { 5, 1, 2, 0, 2, 2, 3 };
		// System.out.println(increasingTriplet(nums));
		String tags = "DEFAULT_GLS_URL:\r\n" + 
				"DEFAULT_GLS_INSTANCE_ID:";
		System.out.println(contains(tags, "DEFAULT_GLS_URL"));
		System.out.println(contains(tags, "DEFAULT_GLS_INSTANCE_ID"));
		
		System.out.println(addGLSURLInstanceIdToEmailContent(tags, "www.jd.co", "123"));
	}

	// Checking is Email template for GLS auto provision
	public static boolean contains(String tags, String str) {

		int in = tags.indexOf(':', 0);
		
		if (str.equalsIgnoreCase("DEFAULT_GLS_URL"))
			return tags.substring(0, in).equalsIgnoreCase(str);

		if (str.equalsIgnoreCase("DEFAULT_GLS_INSTANCE_ID"))
			return tags.substring(tags.indexOf('\n', 0) + 1, tags.length() - 1).equalsIgnoreCase(str);

		return false;

	}

	// Add GLS URL and Instance Id to to email content
	public static String addGLSURLInstanceIdToEmailContent(String contentTags, String url, String instanceId) {

		StringBuilder emailContent = new StringBuilder();
		String preURLTag = contentTags.substring(0, contentTags.indexOf(':'));
		String postURLTag = contentTags.substring(contentTags.indexOf('\n', 0) + 1, contentTags.length());

		if (url != null && url.length() != 0 && preURLTag != null) {
			emailContent.append(preURLTag);
			emailContent.append(": ");
			emailContent.append(url);
		}

		if (instanceId != null && instanceId.length() != 0&& postURLTag != null) {
			emailContent.append(" ");
			emailContent.append(postURLTag);
			emailContent.append(instanceId);
		}

		return emailContent.toString();
	}
	
	

	static boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				return true;
			if (nums[i] <= min)
				min = nums[i];
			else
				max = nums[i];
		}
		return false;
	}

}
