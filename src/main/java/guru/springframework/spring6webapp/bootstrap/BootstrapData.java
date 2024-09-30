package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repository.AuthorRepository;
import guru.springframework.spring6webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("eric");
        eric.setLastName("eric last name ");

        Book firstBook = new Book();
        firstBook.setName("firstBook");
        firstBook.setIsbn("1245");

        Author savedEric = authorRepository.save(eric);
        Book savedFirstBook = bookRepository.save(firstBook);

        Author secondAuthor = new Author();
        eric.setFirstName("eric");
        eric.setLastName("eric last name ");

        Book secondBook = new Book();
        firstBook.setName("secondBook");
        firstBook.setIsbn("1234");

        Author savedsecondAuthor = authorRepository.save(secondAuthor);
        Book savedSecondBook = bookRepository.save(secondBook);

        savedEric.getBooks().add(savedFirstBook);
        savedsecondAuthor.getBooks().add(savedSecondBook);

        authorRepository.save(savedEric);
        authorRepository.save(savedsecondAuthor);

        System.out.println("from bootStrap ");
        System.out.println("author count ; " + authorRepository.count());
        System.out.println("book count ; " + bookRepository.count());


    }
}
