package BackEnd_Packge;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Medico extends AtendenteHospitalar{
    private long idMedico;
    private int numeroCRM;
    private String[] areasEspecialidade;
    private boolean cirugiao;

    public Medico(
        String nomeCompleto,
        LocalDate dataNascimento,
        Endereco endereco,
        ContatoTelEmail contato,
        Genero genero,
        int numeroCRM,
        String[] areasEspecialidade,
        boolean cirugiao,
        int chSemanal,
        String setor
    ){
        this.setNomeCompleto(nomeCompleto);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setContato(contato);
        this.setGenero(genero);
        this.setNumeroCRM(numeroCRM);
        this.setAreasEspecialidade(areasEspecialidade);
        this.setCirugiao(cirugiao);
        this.setChSemanal(chSemanal);
        this.setSetor(setor);
        this.setIdMedico(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public int getNumeroCRM() {
        return numeroCRM;
    }

    public void setNumeroCRM(int numeroCRM) {
        this.numeroCRM = numeroCRM;
    }

    public String[] getAreasEspecialidade() {
        return areasEspecialidade;
    }

    public void setAreasEspecialidade(String[] areasEspecialidade) {
        this.areasEspecialidade = areasEspecialidade;
    }

    public boolean getCirugiao() {
        return cirugiao;
    }

    public void setCirugiao(boolean cirugiao) {
        this.cirugiao = cirugiao;
    }
}
