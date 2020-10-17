package br.com.ecommerce.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
 //deixa a conexão prontinha
	
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemarapaduralivre");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
