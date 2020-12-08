package ru.geekbrains.spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void add(Product product){
        products.add(product);
    }

    public void remove(int id){
        products.remove(id);
    }

    public Product getProductById(int id) {
        for (Product p : products)
            if (p.getId() == id) {
                return p;
            }
        return null;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1, "test1", 100));
        products.add(new Product(2, "test2", 200));
        products.add(new Product(3, "test3", 300));
        products.add(new Product(4, "test4", 400));
        products.add(new Product(5, "test5", 500));
    }

}



