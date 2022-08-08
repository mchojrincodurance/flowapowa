package flowapowa.forGettingPrices;

public interface PriceProvider {
    void add(String product, Double unitaryPrice);
    double getPrice(String product);
}
