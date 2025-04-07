package BackEnd_Packge;

public class Responsavel extends ContatoTelEmail{
    private long idResponsavel;
    private String nomeResponsavel;//Verificar depois

    public Responsavel(
            String telefone,
            String celular,
            String email,
            long idResponsavel,
            String nomeResponsavel
    ){
        super(telefone,celular,email);
        this.setIdResponsavel(idResponsavel);
        this.setNomeResponsavel(nomeResponsavel);
    }
        public Responsavel(
            String telefone,
            String celular,
            String email,
           // long idResponsavel,
            String nomeResponsavel
    ){
        super(telefone,celular,email);
        this.setIdResponsavel(idResponsavel);
        this.setNomeResponsavel(nomeResponsavel);
    }
    public long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}
