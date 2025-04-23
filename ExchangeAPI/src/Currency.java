import java.util.Map;

public class Currency {
    private String date;
    private String base;
    private Map<String,Double> rates;

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getBase() {
        return base;
    }
    public void setBase(String base) {
        this.base = base;
    }
    public Map<String, Double> getRates() {
        return rates;
    }
    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
