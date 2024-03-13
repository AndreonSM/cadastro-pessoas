package bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import model.Pessoa;
import java.util.List;

@javax.faces.view.ViewScoped
public class PessoaBean {

    @PersistenceContext
    private EntityManager entityManager;

    private Pessoa novaPessoa = new Pessoa();
    private Pessoa pessoaSelecionada;
    private List<Pessoa> pessoas;

    public List<Pessoa> getPessoas() {
        if (pessoas == null) {
            pessoas = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
        }
        return pessoas;
    }

    public Pessoa getNovaPessoa() {
        return novaPessoa;
    }

    public void setNovaPessoa(Pessoa novaPessoa) {
        this.novaPessoa = novaPessoa;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    @Transactional
    public String adicionarPessoa() {
        entityManager.persist(novaPessoa);
        novaPessoa = new Pessoa();
        pessoas = null;
        return "listarPessoas"; // Redireciona para a página listarPessoas
    }

    @Transactional
    public String editarPessoa() {
        entityManager.merge(pessoaSelecionada);
        pessoas = null;
        return "listarPessoas"; // Redireciona para a página listarPessoas
    }

    @Transactional
    public String excluirPessoa() {
        entityManager.remove(entityManager.merge(pessoaSelecionada));
        pessoas = null;
        return "listarPessoas"; // Redireciona para a página listarPessoas
    }
}
