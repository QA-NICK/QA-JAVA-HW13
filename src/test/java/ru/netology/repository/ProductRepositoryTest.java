package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Product one = new Book(1, "testBook", 50, "Petrov");
    Product two = new Smartphone(2, "TestPhone", 1000, "Nokia");
    Product three = new Smartphone(3, "TestPhone", 1000, "LG");
    Product four = new Book(4, "testBook", 50, "Petrov");
    ProductRepository repository = new ProductRepository();

    @BeforeEach
    public void setUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
    }

    @Test
    public void shouldRemoveById() {

        Product [] actual = repository.removeById(2);
        Product [] expected = new Product[] {one, three,four};
        assertArrayEquals(actual, expected);

    }
    @Test
    public void shouldRemoveByNonexistentId() {
        assertThrows(NotFoundException.class, () ->{
         repository.removeById(5);
        });

    }
}