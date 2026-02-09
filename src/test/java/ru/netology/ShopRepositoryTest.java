package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 40);
        Product product2 = new Product(2, "Молоко", 80);
        Product product3 = new Product(3, "Яйца", 100);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product[] expected = { product1, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenRemovingNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 40);
        Product product2 = new Product(2, "Молоко", 80);

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(100);
        });
    }
}