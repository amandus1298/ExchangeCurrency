import java.util.Map;

public class Conversor {
  public double Convert(double val, String currencyDe, String currencyPara, Map<String,Double> rates){
      if (!rates.containsKey(currencyDe) || !rates.containsKey(currencyPara)) {
          throw new IllegalArgumentException("Uma das moedas informadas não é válida.");
      }

      double taxaDe = rates.get(currencyDe);
      double taxaPara = rates.get(currencyPara);
      return (val/taxaDe) * taxaPara;
  }

}
