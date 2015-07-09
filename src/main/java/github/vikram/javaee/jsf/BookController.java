package github.vikram.javaee.jsf;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BookController {

	@Inject
	BookEJB ejbBook;
	
	private Book book = new Book();

	public String doCreateBook() {
		
		ejbBook.createBook(book);
		
		FacesContext.getCurrentInstance().addMessage(null, 
	            new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created", 
	            "The book" + book.getTitle() + " has been created with id=" + book.getId()));
	 
	    return " newBook.xhtml ";
	}
	
	public void findBookById() {
		
		book = ejbBook.findBookById(book.getId());
	}
	
}
