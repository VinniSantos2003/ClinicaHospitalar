package BackEnd_Packge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Paciente extends DadoPessoal{
    private long idPaciente;
    private int idade;
    private Date dataCadastro;
    private String obsGeral;
    private ArrayList<ConsultaMedica> historicoConsultasMedicas;
    private Responsavel contatoResponsavel;
/*
    public Paciente(
            String nomeCompleto,
            LocalDate dataNascimento,
            Endereco endereco,
            ContatoTelEmail contato,
            Genero genero,
            int idade,
            Date dataCadastro,
            String obsGeral,
            ArrayList<ConsultaMedica> historicoConsultasMedicas,
            Responsavel contatoResponsavel
    ){
        this.setNomeCompleto(nomeCompleto);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setContato(contato);
        this.setGenero(genero);
        this.setIdade(idade);
        this.setDataCadastro(dataCadastro);
        this.setObsGeral(obsGeral);


    }*/
        public Paciente(
            String nomeCompleto,
            LocalDate dataNascimento,
            Endereco endereco,
            ContatoTelEmail contato,
            Genero genero,
            int idade,
            Date dataCadastro,
            String obsGeral,
            //ConsultaMedica[] historicoConsultasMedicas,
            Responsavel contatoResponsavel
    ){

        this.setIdPaciente(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        this.setNomeCompleto(nomeCompleto);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setContato(contato);
        this.setGenero(genero);
        this.setIdade(idade);
        this.setDataCadastro(dataCadastro);
        this.setObsGeral(obsGeral);
        this.setContatoResponsavel(contatoResponsavel);
        this.historicoConsultasMedicas = new ArrayList<>();
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObsGeral() {
        return obsGeral;
    }

    public void setObsGeral(String obsGeral) {
        this.obsGeral = obsGeral;
    }

    public ArrayList<ConsultaMedica> getHistoricoConsultasMedicas() {
        return historicoConsultasMedicas;
    }

    public void setHistoricoConsultasMedicas(ConsultaMedica historicoConsultasMedicas) {
         this.historicoConsultasMedicas.add(historicoConsultasMedicas);
    }

    public Responsavel getContatoResponsavel() {
        return contatoResponsavel;
    }

    public void setContatoResponsavel(Responsavel contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }
}
