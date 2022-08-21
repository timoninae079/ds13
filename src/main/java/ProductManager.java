import org.jetbrains.annotations.NotNull;

public class ProductManager {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {

        this.repository = repository;
    }

    public void add(Product product) {

        repository.add(product);
    }

    public void removeById(int id) {
        repository.remove(id);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(@NotNull Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}
