package training.Zero.To.Hero.Selenium.Utils;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Get_Reponse_Code {
	
	static int inValidLink;

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
			} else if (urlConnect.getResponseCode() == urlConnect.HTTP_NOT_FOUND) {
				System.out
						.println(linkURL + " : " + urlConnect.getResponseMessage() + " : " + urlConnect.HTTP_NOT_FOUND);
				inValidLink++;
			}

		} catch (Exception e) {
		}
	}

	public static void getInvalidLinkCount() {
		System.out.println("Total Invalid Links : " + inValidLink);
	}

}