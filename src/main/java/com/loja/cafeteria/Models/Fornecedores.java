package com.loja.cafeteria.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="Fornecedores")
public class Fornecedores {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String cpfCnpj;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Contatos> contatos;
       
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Produtos> produtos;

    public Fornecedores() {
    }

    public Fornecedores(String nome, String cpfCnpj, List<Contatos> contatos, List<Produtos> produtos) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.contatos = contatos;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public List<Contatos> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contatos> contatos) {
        this.contatos = contatos;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

}
