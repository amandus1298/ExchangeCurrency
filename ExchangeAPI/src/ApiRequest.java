import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    private static final String BASE_URL = "https://api.currencyfreaks.com/v2.0/rates/latest";
    private static final String API_KEY = "dcc3058275f04a8eaf34ad34f9aef79a";
    URI url = URI.create(BASE_URL + "?apikey=" + API_KEY);

    public Currency BuscarTaxas(){
        Gson gson = new Gson();
//    var url = URI.create("https://api.currencyfreaks.com/v2.0/rates/latest?apikey=dcc3058275f04a8eaf34ad34f9aef79a");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: status " + response.statusCode());
        }
       return gson.fromJson(response.body(), Currency.class);
    }
}
