package github.vikram.javaee.jsf;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {

	@Produces
	@PersistenceContext(unitName="persistence-unit")
	private EntityManager em;

}
