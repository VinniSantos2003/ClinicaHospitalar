package BackEnd_Packge;

public class ConsultaMedica {
    private long idConsulta; //
    private long idPaciente; //Referencia direta ao ID do paciente
    private long idMedico; //Referencia direta ao ID do medico
    private String exameQueixa;
    private String diagnostico;
    private String prescricao;
    private boolean indicacaoCirurgica;

    public ConsultaMedica(
        long idConsulta,
        long idPaciente,
        long idMedico,
        String exameQueixa,
        String diagnostico,
        String prescricao,
        boolean indicacaoCirurgica
    ){
        this.setIdConsulta(idConsulta);
        this.setIdPaciente(idPaciente);
        this.setIdMedico(idMedico);
        this.setExameQueixa(exameQueixa);
        this.setDiagnostico(diagnostico);
        this.setPrescricao(prescricao);
        this.setIndicacaoCirurgica(indicacaoCirurgica);
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public String getExameQueixa() {
        return exameQueixa;
    }

    public void setExameQueixa(String exameQueixa) {
        this.exameQueixa = exameQueixa;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public boolean getIndicacaoCirurgica() {
        return indicacaoCirurgica;
    }

    public void setIndicacaoCirurgica(boolean indicacaoCirurgica) {
        this.indicacaoCirurgica = indicacaoCirurgica;
    }
}
