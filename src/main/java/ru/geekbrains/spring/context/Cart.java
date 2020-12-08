package ru.geekbrains.spring.context;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@Component
@Scope(value = "prototype")
public class Cart {

    private ProductRepository productRepository;

    public Cart(ProductRepository productRepository){
        this.productRepository = productRepository;
    }



    public String show(){
        return String.valueOf(productRepository.getProducts());
    }

    public String getProductById(int id){
        if (productRepository.getProductById(id) == null){
            return "Нет товара с таким ID";
        } else return String.valueOf(productRepository.getProductById(id));
    }

    public void remove(int id){
        if (productRepository.getProductById(id) == null){
            System.out.println("Нет такого товара");
        } else productRepository.remove(id-1);
    }

    public void add(Product product){
        productRepository.add(product);
    }

//    public int calculateTotalPrice(){
//        int price = 0;
//        List<Product> products = productRepository.getProducts();
//        for (Product p : products) {
//            price += p.getPrice();
//        }
//            return price;
//        }
    }

