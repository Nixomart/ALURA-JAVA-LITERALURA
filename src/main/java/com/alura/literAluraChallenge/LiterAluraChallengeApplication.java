package com.alura.literAluraChallenge;

import com.alura.literAluraChallenge.entities.Book;
import com.alura.literAluraChallenge.service.BookService;
import com.alura.literAluraChallenge.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiterAluraChallengeApplication implements CommandLineRunner {
	@Autowired
	private BookService bookService;
	@Autowired
	private GutendexService gutendexService;
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);


	}
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Buscar libros");
			System.out.println("2. Listar libros por idioma");
			System.out.println("3. Salir");
			System.out.print("Elige una opción: ");
			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1:
					System.out.print("Ingrese el término de búsqueda: ");
					String query = scanner.nextLine();
					List<Book> books = gutendexService.getBooks(query);
					bookService.saveBooks(books);
					books.forEach(System.out::println);
					break;
				case 2:
					System.out.print("Ingrese el idioma: ");
					String language = scanner.nextLine();
					bookService.getBooksByLanguage(language).forEach(System.out::println);
					break;
				case 3:
					System.out.println("¡Adiós!");
					return;
				default:
					System.out.println("Opción inválida.");
			}
		}
	}


}
