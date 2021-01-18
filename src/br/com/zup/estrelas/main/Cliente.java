package br.com.zup.estrelas.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String cpf;
 
    @Column(name = "telefone", nullable = false)
    private String telefone;
    
    @Column(name = "endereco", nullable = false)
    private String endereco;
    
    @Column(name = "idade", nullable = false)
    private String idade;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    
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
