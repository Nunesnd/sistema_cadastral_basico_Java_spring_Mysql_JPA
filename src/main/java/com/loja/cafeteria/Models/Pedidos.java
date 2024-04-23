package com.loja.cafeteria.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Pedidos")
public class Pedidos implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pedido")
    private Date dataPedido;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    private List<ListaProdutosPedidos> listaProdPedidos;
    
    private double total;
    
    @ManyToOne
    private Pessoa pessoa;

    public Pedidos() {
    }

    public Pedidos(Date dataPedido, List<ListaProdutosPedidos> listaProdPedidos, double total, Pessoa pessoa) {
        this.dataPedido = dataPedido;
        this.listaProdPedidos = listaProdPedidos;
        this.total = total;
        this.pessoa = pessoa;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public List<ListaProdutosPedidos> getListaProdPedidos() {
        return listaProdPedidos;
    }

    public void setListaProdPedidos(List<ListaProdutosPedidos> listaProdPedidos) {
        this.listaProdPedidos = listaProdPedidos;
    }

}
