import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    ApiRequest req = new ApiRequest();
    Map<String, Double> rates = req.BuscarTaxas().getRates();
    Conversor convert = new Conversor();
    System.out.println(rates);
    boolean continua = true;
    while (continua) {
        new Options().MenuPrincipal();
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                new Options().menuConversao(scanner, convert, rates);
                break;
            case "2":
                new Options().menuTaxas(scanner, rates, req);
                break;
            case "3":
                Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
                System.out.println("escreva o nome do arquivo. ou aperte(1) pra voltar");
                String fileName = scanner.nextLine();
                if(!Objects.equals(fileName, "1")){
                Map<String,Double> valueKeys = HashMap.newHashMap(rates.size());
                valueKeys.putAll(rates);
                new Options().SalveDates(fileName,gson.toJson(valueKeys));
                }else{
                    break;
                }
                break;
            case "4":
                System.out.println("Obrigado, ate breve!!!");
                continua = false;
                break;
            default:
                System.out.println("Digite um numero valido!!");

        }
    }
    scanner.close();
}
