package br.com.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ecommerce.utils.JPAUtil;


public abstract class GenericoDao <T> {
	private final EntityManager manager = JPAUtil.getEntityManager();
	private final Class<T> clazz;
	
	public GenericoDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	public T getById(int i) {
		return manager.find(clazz, i);
	}
	
	public List<T> findAll(){
		TypedQuery<T> q = manager.createQuery(" FROM " + clazz.getSimpleName(), clazz);
		return q.getResultList();
	}
	public void salvar(T clazz) {
		manager.getTransaction().begin();
		manager.persist(clazz);
		manager.getTransaction().commit();
		manager.close();
	}
	public void update(T clazz) {
		manager.getTransaction().begin();
		manager.merge(clazz);
		manager.getTransaction().commit();
		manager.close();
	}
	public void excluir(T clazz) {
		manager.getTransaction().begin();
		manager.remove(clazz);
		manager.getTransaction().commit();
		manager.close();
	}
	public void excluir(Integer id) {
		manager.remove(getById(id));
	}
}
