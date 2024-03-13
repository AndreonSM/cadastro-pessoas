package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Endereco;

import java.util.List;

public class EnderecoDAO {

    private EntityManager entityManager;

    public EnderecoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvarEndereco(Endereco endereco) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(endereco);
        transaction.commit();
    }

    public Endereco buscarEnderecoPorId(Long id) {
        return entityManager.find(Endereco.class, id);
    }

    public List<Endereco> buscarTodosEnderecos() {
        String jpql = "SELECT e FROM Endereco e";
        TypedQuery<Endereco> query = entityManager.createQuery(jpql, Endereco.class);
        return query.getResultList();
    }

    public void atualizarEndereco(Endereco endereco) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(endereco);
        transaction.commit();
    }

    public void deletarEndereco(Endereco endereco) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(endereco) ? endereco : entityManager.merge(endereco));
        transaction.commit();
    }
}
