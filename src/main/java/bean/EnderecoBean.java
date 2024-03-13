package bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import model.Endereco;
import java.util.List;

@javax.faces.view.ViewScoped
public class EnderecoBean {

    @PersistenceContext
    private EntityManager entityManager;

    private Endereco novoEndereco = new Endereco();
    private Endereco enderecoSelecionado;
    private List<Endereco> enderecos;

    public List<Endereco> getEnderecos() {
        if (enderecos == null) {
            enderecos = entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
        }
        return enderecos;
    }

    public Endereco getNovoEndereco() {
        return novoEndereco;
    }

    public void setNovoEndereco(Endereco novoEndereco) {
        this.novoEndereco = novoEndereco;
    }

    public Endereco getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }

    @Transactional
    public void adicionarEndereco() {
        entityManager.persist(novoEndereco);
        novoEndereco = new Endereco();
        enderecos = null;
    }

    @Transactional
    public void editarEndereco() {
        entityManager.merge(enderecoSelecionado);
        enderecos = null;
    }

    @Transactional
    public void excluirEndereco() {
        entityManager.remove(entityManager.merge(enderecoSelecionado));
        enderecos = null;
    }
}
