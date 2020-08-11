package seleniumWrapper.Commands;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seleniumWrapper.Browser;


public class HttpsCheckCommand implements CommandInterface {
	private String results = "";
	private String httpsRequest;
	private HttpResponse<String> response;

    public HttpsCheckCommand(String httpsRequest) {
    	this.httpsRequest = httpsRequest;
    }

    public String execute() {    	 
    	HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(httpsRequest))
            .build();
		try {
			response = client.send(request,
			         HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			results += e.getMessage() + "\n";
		}

        return response.body().toString();    
    }
}
