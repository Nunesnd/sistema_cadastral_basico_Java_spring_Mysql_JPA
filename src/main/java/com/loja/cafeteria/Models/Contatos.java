package com.loja.cafeteria.Models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Contatos")
public class Contatos implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeLink;
    private String contatoLink;
    
    @ManyToOne
    private Pessoa pessoa;
    
    @ManyToOne
    private Fornecedores fornecedor;
    
    public Contatos(){}

    public Contatos(String nomeLink, String contatoLink, Pessoa pessoa, Fornecedores fornecedor) {
        this.nomeLink = nomeLink;
        this.contatoLink = contatoLink;
        this.pessoa = pessoa;
        this.fornecedor = fornecedor;
    }
        

    public String getNomeLink() {
        return nomeLink;
    }

    public void setNomeLink(String nomeLink) {
        this.nomeLink = nomeLink;
    }

    public String getContatoLink() {
        return contatoLink;
    }

    public void setContatoLink(String contatoLink) {
        this.contatoLink = contatoLink;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
}
