package org.example.tp3.exo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        // Création des mocks
        OrderService orderServiceMock = mock(OrderService.class);
        OrderDao orderDaoMock = mock(OrderDao.class);

        // Préparation de l'objet à tester
        OrderController orderController = new OrderController(orderServiceMock);

        // Création d'une commande factice
        Order order = new Order(1L, "New Order");

        // Simuler que OrderService utilise OrderDao (configuration supplémentaire si on teste en profondeur)
        doNothing().when(orderServiceMock).createOrder(order);

        // Appeler la méthode à tester
        orderController.createOrder(order);

        // Vérification que OrderService.createOrder a été appelé avec l'objet order
        verify(orderServiceMock).createOrder(order);
    }
}
