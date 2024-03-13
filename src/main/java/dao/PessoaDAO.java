package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Pessoa;

import java.util.List;

public class PessoaDAO {

    private EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarPessoa(Pessoa pessoa) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(pessoa);
        transaction.commit();
    }

    public Pessoa buscarPessoaPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> buscarTodasPessoas() {
        String jpql = "SELECT p FROM Pessoa p";
        TypedQuery<Pessoa> query = entityManager.createQuery(jpql, Pessoa.class);
        return query.getResultList();
    }

    public void atualizarPessoa(Pessoa pessoa) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(pessoa);
        transaction.commit();
    }

    public void deletarPessoa(Pessoa pessoa) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(pessoa) ? pessoa : entityManager.merge(pessoa));
        transaction.commit();
    }
}
