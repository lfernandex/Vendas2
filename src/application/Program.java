package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import entities.Sales;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a file path: ");
		String path = sc.nextLine();
		System.out.println();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Sales> set = new ArrayList<>();
			
			String name = br.readLine();
			while (name != null) {
				String[] fiealds = name.split(",");
				set.add(new Sales(Integer.parseInt(fiealds[0]),Integer.parseInt(fiealds[1]),fiealds[2], Integer.parseInt(fiealds[3]), Double.parseDouble(fiealds[4])));
				name = br.readLine();
			}
			
		Set<String> vend = set.stream()
						   .map(p -> p.getSeller())
						   .collect(Collectors.toSet());
		
		System.out.println("Total de vendas por vendedor: ");
		System.out.println();
		
// Precisei encontrar uma forma do meu .map aceitar double 
// Onde meu tot percorre vend do tipo String
// encontrei o mapToDouble no stackerOverFlow :)
		
		for(String tot : vend) {
			double total = set.stream()
					.filter( p -> p.getSeller().equals(tot))
					.mapToDouble(p -> p.getTotal())
					.sum();
			System.out.println(tot + " - R$: " + String.format("%.2f", total));
		}
		
		}			
		catch (IOException e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}

		sc.close();
	}

}
