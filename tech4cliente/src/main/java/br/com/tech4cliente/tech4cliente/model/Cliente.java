package br.com.tech4cliente.tech4cliente.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clientes")
public class Cliente {
    @Id
    private String id;
    private String nome;
    private String paiOuMae;
    private String lugarDeNascimento;
    private Integer anoNascimento;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPaiOuMae() {
        return paiOuMae;
    }
    public void setPaiOuMae(String paiOuMae) {
        this.paiOuMae = paiOuMae;
    }
    public String getLugarDeNascimento() {
        return lugarDeNascimento;
    }
    public void setLugarDeNascimento(String lugarDeNascimento) {
        this.lugarDeNascimento = lugarDeNascimento;
    }
    public Integer getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    
}
