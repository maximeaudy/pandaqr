package pizza.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import pizza.spring.modele.Pizza;

public class PizzaDao {
	
	private EntityManager em;
	
	public List<Pizza> getListePizza() {
		return em.createQuery("select p from Pizza p", Pizza.class)
				 .getResultList();
	}
	
}
