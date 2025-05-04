package org.example.tp3.exo3;

public class ProductService {
    private ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) throws Exception {
        return productApiClient.getProduct(productId);
    }
}
