package BackEnd_Packge;

public class ContatoTelEmail {
    private String telefone;
    private String celular;
    private String email;

    public ContatoTelEmail(
            String telefone,
            String celular,
            String email
    ){
        this.setTelefone(telefone);
        this.setCelular(celular);
        this.setEmail(email);
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
