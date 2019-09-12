package course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.OrderItem;
import entities.OrderStatus;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.ENGLISH);
		Scanner sc = new Scanner(System.in);
		
		List<OrderItem> orderItem =  new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		OrderStatus status;
				
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MNM/YYYY): ");
		Date birthDay = sdf.parse(sc.nextLine());
		Date moment = new Date (System.currentTimeMillis());
		
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		status = OrderStatus.valueOf(sc.nextLine());
		System.out.print("How many items to this order? ");
		int nOrders = sc.nextInt();		
		
		
		for (int i = 0; i < nOrders; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i+1 + " item data:");
			System.out.print("Product name: ");
			String nameFor = sc.nextLine(); 
			System.out.print("Product price: ");
			Double priceFor = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityFor = sc.nextInt();
			OrderItem pFor = new OrderItem(nameFor, quantityFor,priceFor);			
			orderItem.add(pFor);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY");
		System.out.println("Order moment: " + sdf2.format(moment));
		System.out.println("Order status: " + status);
		System.out.println("Client: " + name + "(" + sdf.format(birthDay) + ") - " + email);
		
		System.out.println("ORDER ITEMS");
		Double sum = (double) 0;
		for (OrderItem x : orderItem) {
			System.out.println(x);
			sum += x.subTotal();
		}
		
		System.out.println("Total: " + sum);
		
	
		
		sc.close();
		
	
		
	}
	
	
	

}
