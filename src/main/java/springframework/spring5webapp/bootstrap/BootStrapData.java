package springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring5webapp.domain.Author;
import springframework.spring5webapp.domain.Book;
import springframework.spring5webapp.domain.Publisher;
import springframework.spring5webapp.repositories.AuthorRepository;
import springframework.spring5webapp.repositories.BookRepository;
import springframework.spring5webapp.repositories.PublisherRepository;


@Component
public class BootStrapData implements CommandLineRunner {


    private  final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Desing", "123123");
        Publisher apollo = new Publisher("Majaka 4", "Tallinn", "674536");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);



        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(apollo);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "56847547");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher: " + publisherRepository.count());

    }
}
