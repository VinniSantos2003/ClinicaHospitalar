package BackEnd_Packge;

import java.time.LocalDate;
import java.util.Date;

public abstract class DadoPessoal {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private Endereco endereco;//Criar classe endereço depois
    private ContatoTelEmail contato;
    private Genero genero;


    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContatoTelEmail getContato() {
        return contato;
    }

    public void setContato(ContatoTelEmail contato) {
        this.contato = contato;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
