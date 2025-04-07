package BackEnd_Packge;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Enfermeiro extends AtendenteHospitalar{
    private long idEnfermeiro;
    private boolean treinadoOpRx;

    public Enfermeiro(
        String nomeCompleto,
        LocalDate dataNascimento,
        Endereco endereco,
        ContatoTelEmail contato,
        Genero genero,
        String setor,
        int chSemanal,
       // long idEnfermeiro,
        boolean treinadoOpRx
    ){
        this.setNomeCompleto(nomeCompleto);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setContato(contato);
        this.setGenero(genero);
        this.setSetor(setor);
        this.setChSemanal(chSemanal);
        this.setIdEnfermeiro(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        this.setTreinadoOpRx(treinadoOpRx);
    }

    public long getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(long idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public boolean getTreinadoOpRx() {
        return treinadoOpRx;
    }

    public void setTreinadoOpRx(boolean treinadoOpRx) {
        this.treinadoOpRx = treinadoOpRx;
    }
}
