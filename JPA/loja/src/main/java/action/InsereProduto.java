package action;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

public class InsereProduto {
    
    private static Produto livro;

    public static void main(String[] args) {
        criaLivro();
        insereLivro();
        //imprimeLivro();
        //buscaLivroFromNome("Java");
        //buscaLivroFromCategoria("Livro");
        buscaPrecoFromNomeProduto(1L);
    }

    private static void buscaPrecoFromNomeProduto(Long id) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.id = :id";
        BigDecimal preco = JPAUtil.getEntityManager()
            .createQuery(jpql, BigDecimal.class)
            .setParameter("id", id)
            .getSingleResult();
         System.out.println("Preco do Produto " + id + " é: R$ " + preco);
    }

    private static void buscaLivroFromCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        List<Produto> produtos = JPAUtil.getEntityManager()
            .createQuery(jpql, Produto.class)
            .setParameter("nome", nome)
            .getResultList();
        for(Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome());
        }
    }

    private static void buscaLivroFromNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        List<Produto> produtos = JPAUtil.getEntityManager()
            .createQuery(jpql, Produto.class)
            .setParameter("nome", nome)
            .getResultList();
        for(Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome());
        }
    }

    private static void imprimeLivro() {
        String jpql = "SELECT p FROM Produto p";
        List<Produto> produtos = JPAUtil.getEntityManager().createQuery(jpql, Produto.class).getResultList();
        for(Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome());
        }
        Produto produto2 = JPAUtil.getEntityManager().find(Produto.class, 1L);
        System.out.println("Produto2: " + produto2.getNome());
    }

    private static void criaLivro() {
        InsereProduto.livro = new Produto();
        InsereProduto.livro.setNome("Java Efetivo - Terceira Edição");
        InsereProduto.livro.setDescricao("Livro focado nas melhores práticas para o desenvolvimento de aplicações em Java");
        InsereProduto.livro.setPreco(new BigDecimal("84.99"));
        InsereProduto.livro.setCategoria(insereCategoria());
    }

    private static Categoria insereCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();
        return categoria;
    }

    private static void insereLivro() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        entityManager.getTransaction().begin();
        produtoDao.cadastrar(InsereProduto.livro);
        entityManager.flush();
        Produto livro = entityManager.merge(InsereProduto.livro);
        livro.setPreco(new BigDecimal("98.65"));
        entityManager.flush();
        //produtoDao.remover(livro);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Livro " + InsereProduto.livro.getNome() + " inserido com sucesso");
    }

}
