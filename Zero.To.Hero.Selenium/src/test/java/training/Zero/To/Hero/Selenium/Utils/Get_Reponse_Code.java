package training.Zero.To.Hero.Selenium.Utils;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Get_Reponse_Code {
	
	static int inValidLink;
	private static Logger log = LogManager.getLogger(Get_Reponse_Code.class.getName());

	public static void verifyUrl(String linkURL) {

		try {
			URL url = new URL(linkURL);
			HttpsURLConnection urlConnect = (HttpsURLConnection) url.openConnection();

			// Set Connection TimeOut
			urlConnect.setConnectTimeout(5000);

			// Open Communication link to resource URL
			urlConnect.connect();

			// To verify the Response Code
			if (urlConnect.getResponseCode() == 200) {
				System.out.println(
						linkURL + " : " + urlConnect.getResponseCode() + " : " + urlConnect.getResponseMessage());
						log.info(linkURL + " : " + urlConnect.getResponseCode() + " : " + urlConnect.getResponseMessage());
			} else if (urlConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out
						.println(linkURL + " : " + urlConnect.getResponseMessage() + " : " + HttpURLConnection.HTTP_NOT_FOUND);
						log.info(linkURL + " : " + urlConnect.getResponseMessage() + " : " + HttpURLConnection.HTTP_NOT_FOUND);
				inValidLink++;
			}

		} catch (Exception e) {
		}
	}

	public static void getInvalidLinkCount() {
		System.out.println("Total Invalid Links : " + inValidLink);
	}

}