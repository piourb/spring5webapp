package guru.springframework.spring5webapp.bootstrap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
  
		setupDataToDb();
		System.out.println("-".repeat(100));
		System.out.println("Start bootstrap");
		System.out.println("Registred Authors:" + authorRepository.count());
		System.out.println("Registred Books:" + bookRepository.count());
		System.out.println("Registred Publishers:" + publisherRepository.count());
		System.out.println("-".repeat(100));
		// not save for only test
		System.out.println("Author id:" + authorRepository.findAll().iterator().next().getId());
		System.out.println("Book id:" + bookRepository.findAll().iterator().next().getId());
		System.out.println("Publisher id:" + publisherRepository.findAll().iterator().next().getId());
		System.out.println("\t\tPublisher book count:" + publisherRepository.findAll().iterator().next().getBooks().size());
	}
	
	private void setupDataToDb() {

		Author a=new Author("xxxx:1", "xxxx:2", Collections.EMPTY_SET);
		
		Book b0=new Book("book:1", "isbn:1", Collections.EMPTY_SET);		
		b0.setAuthors(new HashSet<Author>(Arrays.asList(a)));
				
		Book b1=new Book("book:2", "isbn:2", Collections.EMPTY_SET);		
		b1.setAuthors(new HashSet<Author>(Arrays.asList(a)));
		
		a.setBooks(new HashSet<Book>(Arrays.asList(b0,b1)));
		authorRepository.save(a);
		bookRepository.save(b0);
		bookRepository.save(b1);
		
		Publisher p=new Publisher("pub:1", "my adress:1");
		p.getBooks().add(b0);
		p.getBooks().add(b1);
		b0.setPublisher(p);
		b1.setPublisher(p);	
		publisherRepository.save(p);		
	}

}

