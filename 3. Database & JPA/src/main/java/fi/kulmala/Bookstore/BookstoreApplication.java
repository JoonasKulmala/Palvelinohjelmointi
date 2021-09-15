package fi.kulmala.Bookstore;

import fi.kulmala.Bookstore.domain.Book;
import fi.kulmala.Bookstore.domain.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner productionDemo(BookRepository repository) {
		return (args) -> {

			repository.deleteAll();

			// Title, Author, Year, ISBN, Price
			repository.save(new Book("Example Title", "Example Author", 10, "Example ISBN", 20));
			repository.save(new Book("Spring Database & JPA", "Haaga-Helia", 2021, "isbn123", 0));

		};
	}

}
