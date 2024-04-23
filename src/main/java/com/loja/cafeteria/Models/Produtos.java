package com.loja.cafeteria.Models;

import jakarta.persistence.CascadeType;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="Produtos")
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double precoCusto;
    private double precoVenda;

    @OneToMany(mappedBy = "produtos", cascade = CascadeType.ALL)
    private List<ListaProdutosPedidos> listaProdPedidos;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Fornecedores fornecedor;

    public Produtos(){}

    public Produtos(String nome, double precoCusto, double precoVenda, List<ListaProdutosPedidos> listaProdPedidos, Fornecedores fornecedor) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.listaProdPedidos = listaProdPedidos;
        this.fornecedor = fornecedor;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<ListaProdutosPedidos> getListaProdPedidos() {
        return listaProdPedidos;
    }

    public void setListaProdPedidos(List<ListaProdutosPedidos> listaProdPedidos) {
        this.listaProdPedidos = listaProdPedidos;
    }
    

}
