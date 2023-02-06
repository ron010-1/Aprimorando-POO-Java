package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
          System.out.println("Product #" + i + " data:");
          System.out.print("Common, used or imported (c/u/i)? ");
          char x = sc.next().charAt(0);
          sc.nextLine();
          System.out.print("Name:");
          String name = sc.nextLine();
          System.out.print("Price:");
          Double price = sc.nextDouble();
          if ( x == 'i'){
            System.out.print("Customs fee:");
            Double customsFee = sc.nextDouble();
            list.add(new ImportedProduct(name, price, customsFee));
          }
          else if ( x == 'u'){
            System.out.print("Manufacture date (DD/MM/YYYY): ");
            final LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            list.add(new UsedProduct(name, price, date));
          }
          else if ( x == 'c'){
            list.add(new Product(name, price));
          }
        }

        System.out.println("");
        System.out.println("PRICE TAGS:");
        for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
	}

}
