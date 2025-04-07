package BackEnd_Packge;

public abstract class AtendenteHospitalar extends DadoPessoal{
    private String setor;
    private int chSemanal;//CH = Carga Horária

    public AtendenteHospitalar(){

    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getChSemanal() {
        return chSemanal;
    }

    public void setChSemanal(int chSemanal) {
        this.chSemanal = chSemanal;
    }
}
