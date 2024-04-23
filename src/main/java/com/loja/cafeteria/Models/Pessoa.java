package com.loja.cafeteria.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="Pessoa")
public class Pessoa implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Contatos> contatos;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Pedidos> pedidos;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, List<Contatos> contatos, List<Pedidos> pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Contatos> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contatos> contatos) {
        this.contatos = contatos;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
    
}
