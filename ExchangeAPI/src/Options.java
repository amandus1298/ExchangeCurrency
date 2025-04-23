import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

class Options{

public void MenuPrincipal() {
    System.out.println("\n------------ MENU --------------");
    System.out.println("1 - Conversão");
    System.out.println("2 - Ver taxas");
    System.out.println("3 - Salvar Taxas");
    System.out.println("4 - Sair");
    System.out.println("********************************");
    System.out.print("Escolha uma opção: ");
}

public void menuConversao(Scanner scanner, Conversor conversor, Map<String, Double> rates) {
    try {
        System.out.print("Valor a ser convertido: ");
        double valor = Double.parseDouble(scanner.nextLine());

        System.out.print("Moeda de origem (ex: USD): ");
        String moedaDe = scanner.nextLine().toUpperCase();

        System.out.print("Moeda de destino (ex: BRL): ");
        String moedaPara = scanner.nextLine().toUpperCase();

        if (!rates.containsKey(moedaDe) || !rates.containsKey(moedaPara)) {
            System.out.println("Uma das moedas informadas não é válida.");
            return;
        }

        double resultado = conversor.Convert(valor, moedaDe, moedaPara, rates);
        System.out.printf("%.2f (%s) ====> %.2f (%s)%n", valor, moedaDe, resultado, moedaPara);

    } catch (NumberFormatException e) {
        System.out.println("Valor inválido. Use ponto para casas decimais (ex: 3.32).");
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
}

public void menuTaxas(Scanner scanner, Map<String, Double> rates, ApiRequest req) {
    rates.forEach((moeda, taxa) -> {
        System.out.printf("%s: %.4f%n", moeda, taxa);
        System.out.println("---------------");
    });

    System.out.println("Data das taxas: " + req.BuscarTaxas().getDate());

    System.out.print("Buscar moeda específica: ");
    String moeda = scanner.nextLine().toUpperCase();
    var taxa = rates.get(moeda);
    if (taxa != null) {
        System.out.println("Taxa: " + taxa);
    } else {
        System.out.println("Moeda não encontrada.");
    }
}

public void SalveDates(String fileName, String rates) throws IOException {
    try {
        FileWriter myWriter = new FileWriter(STR."\{fileName}.txt");
        myWriter.write(rates);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred.");
        System.out.println(e.getMessage());
    }
}
}