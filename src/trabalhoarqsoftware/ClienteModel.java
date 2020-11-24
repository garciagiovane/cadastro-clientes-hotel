package trabalhoarqsoftware;

public class ClienteModel {
    
    private int id;
    private String nomeCompleto;
    private String rg;
    private String cpf;
    private String cep;
    private String endereço;
    private String telefone;
    private String dataNascimento;
    private String Sexo;
    private String estadoCivil;

    public ClienteModel() {
    }

    public ClienteModel(String nomeCompleto, String rg, String cpf, String cep, String endereço, String telefone,
            String dataNascimento, String sexo, String estadoCivil) {
        this.nomeCompleto = nomeCompleto;
        this.rg = rg;
        this.cpf = cpf;
        this.cep = cep;
        this.endereço = endereço;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        Sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereco(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return nomeCompleto + ";" + cpf + ";" + cep + ";" + telefone + ";";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
