
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.map.ObjectMapper;

public class RecaptchaApiClientTest {

	public static void main(String[] args) {
		createOrUpdateAttempt(null);
		System.out.println("jc");
	}

	public static String createOrUpdateAttempt(String recaptchaResponse){
		
		String restApiKey="6Lc7jCkTAAAAAHQ_o7ABlPG1drxiT8Y8HfhSpwtB";
		String clientKey="6Lc7jCkTAAAAAMu0FNHwzOggPx5ciyS1PoMxinwD";
		String apiUrl="https://www.google.com/recaptcha/api/siteverify";
		int readTimeout= 600;
		int connectTimeout= 600;
		
		
		String POST = "POST";
		String CONTENT_TYPE = "Content-Type";
		String APPLICATION_JSON = "application/json";
		String USER_AGENT = "User-Agent";
		String MOZILLA = "Mozilla/5.0";
		String ACCEPT_LANGUAGE = "Accept-Language";
		String LANGUAGE = "en-US,en;q=0.5";
		String SECRET = "secret=";
		String RESPONSE = "&response=";
		
		
		InputStream inputStream = null;
		//JsonNode jsonObjNode = null;
		try {
			URL verifyUrl = new URL(apiUrl);
			// Open Connection to URL
            HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();
            conn.setReadTimeout(readTimeout);
			conn.setConnectTimeout(connectTimeout);
            // Add Request Header
            conn.setRequestMethod(POST);
            //conn.setRequestProperty(USER_AGENT, MOZILLA);
            //conn.setRequestProperty(ACCEPT_LANGUAGE, LANGUAGE);
            // Data to be sent to the server.
            String postParams = SECRET + restApiKey + RESPONSE + recaptchaResponse;
            conn.setDoOutput(true);
            //ObjectMapper mapper = new ObjectMapper();
            // Get the output stream of Connection
            // Write data in this stream, which means to send data to Server.
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
            outStream.flush();
            outStream.close();
            conn.connect();
            switch (conn.getResponseCode()) {
			case HttpsURLConnection.HTTP_OK:
				
				// Get the InputStream from Connection to read data sent from the server.
                inputStream = conn.getInputStream();
                String responseAsString = readResponse(inputStream);
                //jsonObjNode = mapper.readValue(responseAsString, JsonNode.class);
                return null;
			case 403:
				
				return null;
			default:
				
				return null;
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {

				}
			}
		}
		
	}
	
	 /* @param stream
	 *            InputStream from HttpURLConnection to read the response
	 * @return Response as string
	 * @throws IOException
	 */
	public static String readResponse(InputStream stream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringBuilder response = new StringBuilder();
		String line;
		
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		return response.toString();
	}
}
