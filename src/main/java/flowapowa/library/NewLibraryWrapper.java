package flowapowa.library;

import flowapowa.forGettingPrices.PriceProvider;

public class NewLibraryWrapper implements PriceProvider {
    private final NewProductProvider provider;

    public NewLibraryWrapper(NewProductProvider provider)
    {
        this.provider = provider;
    }

    @Override
    public void add(String product, Double unitaryPrice) {
        provider.store(new VendorProduct(product, unitaryPrice));
    }

    @Override
    public double getPrice(String product) {
        return provider.getProductByName(product).unitPrice();
    }
}
