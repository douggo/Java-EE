package action;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Produto;

public class InsereProduto {
    
    private static Produto livro;

    public static void main(String[] args) {
        criaLivro();
        insereLivro();
        System.out.println("Livro " + livro.getNome() + " inserido com sucesso");
    }

    private static void criaLivro() {
        livro = new Produto();
        livro.setNome("Java Efetivo - Terceira Edição");
        livro.setDescricao("Livro focado nas melhores "
            + "práticas para o desenvolvimento de aplicações em Java");
        livro.setPreco(new BigDecimal("84.99"));
    }

    private static void insereLivro() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
