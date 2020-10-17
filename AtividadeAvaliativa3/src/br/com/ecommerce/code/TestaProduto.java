package br.com.ecommerce.code;

import javax.persistence.EntityManager;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.utils.JPAUtil;


public class TestaProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin(); //inicia a transação
		
		
		Produto produto = new Produto();
		
		produto.setCategoria("pirulito");
		produto.setImagem("imagem/bagaca");
		produto.setNome("pirulito azul");
		produto.setPreco("1000");
		
		manager.persist(produto);
		
		manager.getTransaction().commit();
		
		manager.close();

	}

}
