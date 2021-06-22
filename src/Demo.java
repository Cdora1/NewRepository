
public class Demo {

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		System.currentTimeMillis();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		System.out.println("Time taken (in millis) for cyberfend botcheck = " + 
				(endTime - startTime) / 1_000_000);
	}

	 long startTime = System.nanoTime();
     /*ServiceResponse<UserPasswordResetDTO> passwordResetResponse = iamRestTemplate
             .exchange(iamResetPwdUri, HttpMethod.PUT, requestEntity, parameterizedTypeReference).getBody();*/
     long endTime = System.nanoTime();
     //LOGGER.info("Time taken (in millis) for IAM Password Reset = " + (endTime - startTime) / 1_000_000);
	
}
