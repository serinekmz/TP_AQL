package org.example.tp3.exo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    public void testGetProductSuccess() throws Exception {
        // Création du mock
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);

        // Préparer une réponse simulée
        Product fakeProduct = new Product("123", "Laptop", 999.99);
        when(apiClientMock.getProduct("123")).thenReturn(fakeProduct);

        // Appeler la méthode
        Product result = productService.getProduct("123");

        // Vérifications
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        assertEquals(999.99, result.getPrice());

        // Vérifier que la méthode du mock est bien appelée avec le bon argument
        verify(apiClientMock).getProduct("123");
    }

    @Test
    public void testGetProductDataFormatError() throws Exception {
        // Création du mock
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);

        // Simuler une exception due à un format incompatible
        when(apiClientMock.getProduct("bad_format")).thenThrow(new IllegalArgumentException("Bad format"));

        // Vérifier que l'exception est bien levée
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productService.getProduct("bad_format");
        });

        assertEquals("Bad format", exception.getMessage());

        // Vérification que la méthode a été appelée
        verify(apiClientMock).getProduct("bad_format");
    }

    @Test
    public void testGetProductApiFailure() throws Exception {
        // Création du mock
        ProductApiClient apiClientMock = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);

        // Simuler une exception API (par exemple réseau indisponible)
        when(apiClientMock.getProduct("api_down")).thenThrow(new RuntimeException("API unreachable"));

        // Vérifier que l'exception est bien levée
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct("api_down");
        });

        assertEquals("API unreachable", exception.getMessage());

        // Vérifier que le mock a été bien appelé
        verify(apiClientMock).getProduct("api_down");
    }
}
