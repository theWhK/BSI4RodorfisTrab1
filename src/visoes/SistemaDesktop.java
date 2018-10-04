/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visoes;

import modelos.Cargo;
import modelos.Cliente;
import modelos.Fornecedor;

/**
 *
 * @author willh
 */
public class SistemaDesktop extends javax.swing.JDesktopPane {
    
    private visoes.Cliente.ListarClientes listarClientes;
    
    public void abrirJanelaListarClientes() {
        if(listarClientes == null) {
            listarClientes = new visoes.Cliente.ListarClientes();
            listarClientes.setVisible(true);
            add(listarClientes);
        }
    }
    
    public void fecharJanelaListarClientes() {
        listarClientes = null;
    }
    
    private visoes.Cliente.GerirCliente gerirCliente;
    
    public void abrirJanelaGerirCliente() {
        abrirJanelaGerirCliente(null);
    }
    
    public void abrirJanelaGerirCliente(Cliente c) {
        if(gerirCliente == null) {
            gerirCliente = new visoes.Cliente.GerirCliente(c);
            gerirCliente.setVisible(true);
            add(gerirCliente);
            gerirCliente.toFront();
        }
    }
    
    public void fecharJanelaGerirCliente() {
        gerirCliente = null;
    }
    
    private visoes.Cargo.ListarCargos listarCargos;
    
    public void abrirJanelaListarCargos() {
        if(listarCargos == null) {
            listarCargos = new visoes.Cargo.ListarCargos();
            listarCargos.setVisible(true);
            add(listarCargos);
        }
    }
    
    public void fecharJanelaListarCargos() {
        listarCargos = null;
    }
    
    private visoes.Cargo.GerirCargo gerirCargo;
    
    public void abrirJanelaGerirCargo() {
        abrirJanelaGerirCargo(null);
    }
    
    public void abrirJanelaGerirCargo(Cargo c) {
        if(gerirCargo == null) {
            gerirCargo = new visoes.Cargo.GerirCargo(c);
            gerirCargo.setVisible(true);
            add(gerirCargo);
            gerirCargo.toFront();
        }
    }
    
    public void fecharJanelaGerirCargo() {
        gerirCargo = null;
    }
    
    private visoes.Fornecedor.ListarFornecedores listarFornecedores;
    
    public void abrirJanelaListarFornecedores() {
        if(listarFornecedores == null) {
            listarFornecedores = new visoes.Fornecedor.ListarFornecedores();
            listarFornecedores.setVisible(true);
            add(listarFornecedores);
        }
    }
    
    public void fecharJanelaListarFornecedores() {
        listarFornecedores = null;
    }
    
    private visoes.Fornecedor.GerirFornecedor gerirFornecedor;
    
    public void abrirJanelaGerirFornecedor() {
        abrirJanelaGerirFornecedor(null);
    }
    
    public void abrirJanelaGerirFornecedor(Fornecedor f) {
        if(gerirFornecedor == null) {
            gerirFornecedor = new visoes.Fornecedor.GerirFornecedor(f);
            gerirFornecedor.setVisible(true);
            add(gerirFornecedor);
            gerirFornecedor.toFront();
        }
    }
    
    public void fecharJanelaGerirFornecedor() {
        gerirFornecedor = null;
    }
}
