package github.vikram.javaee.jsf;

import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Named
@Stateless
public class BookEJB {
	
	@Inject
	EntityManager em;
	
	public Book findBookById(Long id) {
		return em.find(Book.class, id);
	}

	public List<Book> findAllBooks() {
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
		return query.getResultList();
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	public void deleteBook(Book book) {
		em.remove(em.merge(book));
		
	}

	public Book updateBook(Book book) {
		em.merge(book);
		return book;
	}
	
	

}
