package repository;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1,"iphone ", 9000,"new","America"));
        productMap.put(2, new Product(2,"oppo", 8000,"out-stocked","Vietnam"));
        productMap.put(3, new Product(3,"xiaomi", 7000,"new","China"));
        productMap.put(4, new Product(4,"huwei", 6000,"new","China"));
        productMap.put(5, new Product(5,"motorola", 5000,"out-stocked","Japan"));
        productMap.put(6, new Product(6,"blackberry", 4000,"new","America"));
        productMap.put(7, new Product(7,"galaxy", 3000,"out-stocked","Korea"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}