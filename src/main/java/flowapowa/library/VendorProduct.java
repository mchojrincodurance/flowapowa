package flowapowa.library;

import java.util.Objects;

public class VendorProduct {
    private final String name;
    private final double unitPrice;

    public VendorProduct(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String name() {
        return name;
    }

    public double unitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorProduct that = (VendorProduct) o;
        return Double.compare(that.unitPrice, unitPrice) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice);
    }
}

