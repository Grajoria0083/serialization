package com.serialization;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SerializationApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {


		CustomerService customerService = new CustomerService();
		Scanner scanner = new Scanner(System.in);


		while (true) {
			System.out.println("Select an option:");
			System.out.println("1. Resister User");
			System.out.println("3. Get User");
			System.out.println("2. Add Product");
			System.out.println("4. Get Product");
			System.out.println("5. Order Product");


			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter name: ");
					String name = scanner.next();
					System.out.print("Enter email: ");
					String email = scanner.next();
					System.out.print("Enter mobileNo: ");
					String mobile = scanner.next();
					System.out.print("Enter address: ");
					String address = scanner.next();
					System.out.println(customerService.addCustomer(new Customer(name, email, mobile, address)));
					break;
				case 2:
					System.out.print("Enter product name: ");
					String pname = scanner.next();
					System.out.print("Enter product brand: ");
					String brand = scanner.next();
					System.out.print("Enter product quantity: ");
					String quantity = scanner.next();
					System.out.print("Enter price: ");
					String price = scanner.next();
					System.out.println(customerService.addproduct(new Product(pname, brand, quantity, price)));
					break;
				case 3:
					System.out.print("Enter customer id: ");
					long cusId = scanner.nextLong();
					System.out.println(customerService.getCustomer(cusId));;
					break;
				case 4:
					System.out.print("Enter product id: ");
					long proId = scanner.nextLong();
					System.out.println(customerService.getproduct(proId));;
					break;
				default:
					System.out.println("invalid id");


//		long timestamp =  LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC);
//
//		FileOutputStream fos = new FileOutputStream("file1.txt");
//
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//			oos.writeObject(new Student("aman","aman@gmail","12345","noida"));
//
//			FileInputStream fis = new FileInputStream("file1.txt");
//
//			ObjectInputStream ois = new ObjectInputStream(fis);
//
//			Student student = (Student) ois.readObject();
//
//		System.out.println(student);

			}
		}
	}
}


