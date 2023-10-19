package com.serialization;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {



    List<Customer> customers = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<Order> orders = new ArrayList<>();


    public CustomerService()  {
    }

    public Customer addCustomer(Customer customer) throws IOException {

        customer.setCustomerId(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
        customers.add(customer);

        FileOutputStream fos = new FileOutputStream("customer.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(customers);

        return customer;
    }

    public Customer getCustomer(long id) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("customer.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Customer> customersOP = (List<Customer>)ois.readObject();

        for (Customer customer : customersOP) {
            if (customer.getCustomerId()==id)
                return customer;
        }
        return null;
    }

    public Product addproduct(Product product) throws IOException, ClassNotFoundException {

//        if (getCustomer(product.getCustomerId()) instanceof Customer){
            product.setProductId(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));

        FileInputStream fis = new FileInputStream("product.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            List<Product> products = (List<Product>)ois.readObject();
            products.add(product);
        }catch (Exception e){
            products.add(product);
        }

            FileOutputStream fos = new FileOutputStream("product.txt");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(products);

            return product;
//        }
//        return null;
    }


    public Product getproduct(long id) throws IOException, ClassNotFoundException{

        FileInputStream fis = new FileInputStream("product.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Product> productsOP = (List<Product>)ois.readObject();

        for (Product product : productsOP) {
            if (product.getProductId()==id)
                return product;
        }
        return null;
    }

//     List<Customer> readToFile() throws IOException, ClassNotFoundException {
//        FileInputStream fis = new FileInputStream("file1.txt");
//
//        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        return (List<Customer>)ois.readObject();
//    }

//    writetofile() {
//
//    }
}
