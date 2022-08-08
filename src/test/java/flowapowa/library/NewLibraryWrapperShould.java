package flowapowa.library;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NewLibraryWrapperShould {

    private NewProductProvider provider = spy(NewProductProvider.class);
    private NewLibraryWrapper newProvider = new NewLibraryWrapper(provider);

    @ParameterizedTest
    @CsvSource({
            "rose,10.5",
            "lilly,8.6"
    })
    public void respond_to_old_interface (String name, Double price) {
        provider = new NewProductProvider();
        newProvider = new NewLibraryWrapper(provider);

        newProvider.add(name, price);

        assertEquals(price, newProvider.getPrice(name));
    }

    @ParameterizedTest
    @CsvSource({
            "rose,10.5",
            "lilly,8.6"
    })
    public void use_new_product_provider(String name, Double price)
    {
        newProvider.add(name, price);

        verify(provider).store(eq(new VendorProduct(name, price)));
    }
}