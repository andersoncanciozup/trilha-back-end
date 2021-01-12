package br.com.zup.cliente;

public class Cliente {
    
   
    private String cpf;
    
    
    private String nome;
    
    
    private Integer idade;
    
    private String email;
    
    
    private String telefone;
    
    private String endereco;

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", email=" + email
                + ", telefone=" + telefone + ", endereco=" + endereco + "]\n";
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
