package br.com.callCenterVendas.model.domain;

public class Cliente {

    private String telefone;

    private String cpf;

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String endereco;

    private String idade;

    private String email;

    private String nome;



//    public Cliente(String telefone, String cpf, String endereco, String idade, String email,
//            String nome) {
//       
//        this.telefone = telefone;
//        this.cpf = cpf;
//        this.endereco = endereco;
//        this.idade = idade;
//        this.email = email;
//        this.nome = nome;
//    }
    
    public Cliente() {
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
