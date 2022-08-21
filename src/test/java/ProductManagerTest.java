import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book(10, "Harry Potter", 200, "Joanne Rowling");
    Product book2 = new Book(20, "Generation P", 300, "Pelevin");
    Product book3 = new Book(3, "It", 500, "King");
    Product book4 = new Book(44, "Harry", 600, "Rowling");
    Product smarthphone1 = new Smartphone(5, "Samsung", 5000, "China");
    Product smarthphone2 = new Smartphone(666, "Iphone", 10_000, "China");

    @Test
    public void shouldAddOneProduct() {

        manager.add(book1);


        Product[] actual = manager.findAll();
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddProducts() {

        manager.add(book1);
        manager.add(smarthphone1);
        manager.add(smarthphone2);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, smarthphone1, smarthphone2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByText() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("It");
        Product[] expected = {book3};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByTextMoreOneResult() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {book1,book4};

        assertArrayEquals(expected, actual);
}

    @Test
    public void shouldRemoveById() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.removeById(10);

        Product[] actual = {book2, book3, book4};
        Product[] expected = {book2, book3, book4};

        assertArrayEquals(expected, actual);

    }
}
