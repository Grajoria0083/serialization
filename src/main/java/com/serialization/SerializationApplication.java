package com.serialization;


import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SerializationApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {


		CustomerService customerService = new CustomerService();
		Scanner scanner = new Scanner(System.in);


		while (true) {
			System.out.println("Select an option:");
			System.out.println("1. Resister User");
			System.out.println("2. Add Product");
			System.out.println("3. Get User");
			System.out.println("4. Get Product");
			System.out.println("5. Order Product");
			System.out.println("6. Get Order");


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

					Date currentDate = new Date();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(currentDate);
					Date todayDate = calendar.getTime();

					System.out.println(customerService.addCustomer(new Customer(name, email, mobile,todayDate , address)));
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
					System.out.println(customerService.getCustomer(cusId));
					break;
				case 4:
					System.out.print("Enter product id: ");
					long proId = scanner.nextLong();
					System.out.println(customerService.getproduct(proId));;
					break;
				case 5:
					System.out.print("Enter customer id: ");
					long custId = scanner.nextLong();
					System.out.print("Enter product id: ");
					long prodId = scanner.nextLong();
					System.out.print("Enter address: ");
					address = scanner.next();

					currentDate = new Date();
					calendar = Calendar.getInstance();
					calendar.setTime(currentDate);
					todayDate = calendar.getTime();

					System.out.println(customerService.order(custId, prodId, new Order(custId, prodId, todayDate, address)));
					break;
				case 6:
					System.out.print("Enter Order id: ");
					long orderId = scanner.nextLong();
					System.out.println(customerService.getOrder(orderId));
					break;
				default:
					System.out.println("invalid id");

			}
		}
	}
}


