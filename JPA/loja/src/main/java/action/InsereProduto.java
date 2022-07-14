package action;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import dao.ProdutoDao;
import modelo.Produto;
import util.JPAUtil;

public class InsereProduto {
    
    private static Produto livro;

    public static void main(String[] args) {
        criaLivro();
        insereLivro();
    }

    private static void criaLivro() {
        InsereProduto.livro = new Produto();
        InsereProduto.livro.setNome("Java Efetivo - Terceira Edição");
        InsereProduto.livro.setDescricao("Livro focado nas melhores práticas para o desenvolvimento de aplicações em Java");
        InsereProduto.livro.setPreco(new BigDecimal("84.99"));
    }

    private static void insereLivro() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        entityManager.getTransaction().begin();
        produtoDao.cadastrar(InsereProduto.livro);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Livro " + InsereProduto.livro.getNome() + " inserido com sucesso");
    }

}
