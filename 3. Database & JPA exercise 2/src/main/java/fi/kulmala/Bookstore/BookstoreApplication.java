package fi.kulmala.Bookstore;

import fi.kulmala.Bookstore.domain.*;

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
	public CommandLineRunner productionDemo(BookRepository repository, CategoryRepository repository2) {
		return (args) -> {
			
			// Empty database on startup
			// repository.deleteAll();
			// repository2.deleteAll();
			
			// Hard coded Category data
			repository2.save(new Category("Science"));
			repository2.save(new Category("Fiction"));
			repository2.save(new Category("History"));

			// Hard coded Book data
			repository.save(new Book("Example Title", "Example Author", 2000, "Example ISBN", 20, repository2.findByName("Science").get(0)));
			repository.save(new Book("Spring Database & JPA", "Haaga-Helia", 2021,"isbn123", 0.0, repository2.findByName("Fiction").get(0)));

		};
	}

}
