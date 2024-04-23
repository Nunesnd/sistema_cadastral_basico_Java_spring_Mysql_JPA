package com.loja.cafeteria.Models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ListaProdutosPedidos")
public class ListaProdutosPedidos implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Produtos produtos;
    
    @ManyToOne
    private Pedidos pedidos;

    public ListaProdutosPedidos(Produtos produtos, Pedidos pedidos) {
        this.produtos = produtos;
        this.pedidos = pedidos;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    
}
