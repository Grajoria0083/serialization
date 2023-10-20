package com.serialization;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerService {


    List<Customer> customers = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();
    File jsonC = new File("customer.json");
    File jsonP = new File("product.json");
    File jsonO = new File("order.json");


    public CustomerService()  {
    }

    public Customer addCustomer(Customer customer) throws IOException, ClassNotFoundException {

        customer.setCustomerId(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        customers.add(customer);

        objectMapper.writeValue(jsonC, customers);

        FileOutputStream fos = new FileOutputStream("customer.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(customers);

        return customer;

    }

    public Customer getCustomer(long id) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("customer.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Customer> customersOP = (List<Customer>)ois.readObject();
//
//        Customer[] customerList = objectMapper.readValue(jsonC, Customer[].class);
//        List<Customer> customerArray = Arrays.asList(customerList);

        for (Customer customer : customersOP) {
            if (customer.getCustomerId()==id)
                return customer;
        }
        return null;
    }

    public Product addproduct(Product product) throws IOException, ClassNotFoundException {

        product.setProductId(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));

        products.add(product);

        objectMapper.writeValue(jsonP, products);

        convertJsonToByteStream();

        return product;

    }

    void convertJsonToByteStream() throws IOException {

        FileOutputStream fos = new FileOutputStream("product.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(products);
    }


    public Product getproduct(long id) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("product.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Product> productsOP = (List<Product>) ois.readObject();

//        Product[] productsList = objectMapper.readValue(jsonP, Product[].class);
//        List<Product> productArray = Arrays.asList(productsList);

        for (Product product : productsOP) {
            if (product.getProductId() == id)
                return product;
        }
        return null;
    }

    public String order(long cusId, long proId, Order order) throws IOException, ClassNotFoundException {

        if (getCustomer(cusId)==null){
            return "invalid customer Id!";
        }
        if (getproduct(proId)==null){
            return "invalid product Id!";
        }

        order.setOrderId(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));

        order.setCustomerId(cusId);
        order.setProductId(proId);
        orders.add(order);

        objectMapper.writeValue(jsonO, orders);

        FileOutputStream fos = new FileOutputStream("order.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(orders);

        return "Order done by id "+order.getOrderId();

    }

    public Order getOrder(long id) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("order.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Order> ordersOP = (List<Order>) ois.readObject();

//        Order[] orderList = objectMapper.readValue(jsonO, Order[].class);
//        List<Order> orderArray = Arrays.asList(orderList);

        for (Order order : ordersOP) {
            if (order.getOrderId() == id)
                return order;
        }
        return null;
    }
}
