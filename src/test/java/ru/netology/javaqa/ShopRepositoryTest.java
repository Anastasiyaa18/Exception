package ru.netology.javaqa;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {
    @Test
    public void testRemoveExistingProducts() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(18, "кружка", 1_200);
        Product product2 = new Product(155, "помада", 5_399);
        Product product3 = new Product(3, "телевизор", 50_500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveDefunctProducts() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(18, "кружка", 1_200);
        Product product2 = new Product(155, "помада", 5_399);
        Product product3 = new Product(3, "телевизор", 50_500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(56));
    }
}

