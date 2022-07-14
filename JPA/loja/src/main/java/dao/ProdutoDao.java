package dao;

import javax.persistence.EntityManager;

import modelo.Produto;

public class ProdutoDao {
    
    private EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        this.entityManager.persist(produto);
    }
    

}
