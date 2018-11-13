/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visoes;

import java.util.List;
import modelos.Cargo;
import modelos.Cliente;
import modelos.Fornecedor;
import modelos.Setor;

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
    
    public void abrirJanelaGerirCliente(List<Cliente> lstClientes) {
        abrirJanelaGerirCliente(lstClientes, null);
    }
    
    public void abrirJanelaGerirCliente(List<Cliente> lstClientes, Cliente c) {
        if(gerirCliente == null) {
            gerirCliente = new visoes.Cliente.GerirCliente(lstClientes, c);
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
    
    public void abrirJanelaGerirCargo(List<Cargo> lstCargos) {
        abrirJanelaGerirCargo(lstCargos, null);
    }
    
    public void abrirJanelaGerirCargo(List<Cargo> lstCargos, Cargo c) {
        if(gerirCargo == null) {
            gerirCargo = new visoes.Cargo.GerirCargo(lstCargos, c);
            gerirCargo.setVisible(true);
            add(gerirCargo);
            gerirCargo.toFront();
        } else {
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
    
    public void abrirJanelaGerirFornecedor(List<Fornecedor> lstFornecedores) {
        abrirJanelaGerirFornecedor(lstFornecedores, null);
    }
    
    public void abrirJanelaGerirFornecedor(List<Fornecedor> lstFornecedores, Fornecedor f) {
        if(gerirFornecedor == null) {
            gerirFornecedor = new visoes.Fornecedor.GerirFornecedor(lstFornecedores, f);
            gerirFornecedor.setVisible(true);
            add(gerirFornecedor);
            gerirFornecedor.toFront();
        }
    }
    
    public void fecharJanelaGerirFornecedor() {
        gerirFornecedor = null;
    }
    
    private visoes.Setor.ListarSetores listarSetores;
    
    public void abrirJanelaListarSetores() {
        if(listarSetores == null) {
            listarSetores = new visoes.Setor.ListarSetores();
            listarSetores.setVisible(true);
            add(listarSetores);
        }
    }
    
    public void fecharJanelaListarSetores() {
        listarSetores = null;
    }
    
    private visoes.Setor.GerirSetor gerirSetor;
    
    public void abrirJanelaGerirSetor(List<Setor> lstSetor) {
        abrirJanelaGerirSetor(lstSetor, null);
    }
    
    public void abrirJanelaGerirSetor(List<Setor> lstSetores, Setor f) {
        if(gerirSetor == null) {
            gerirSetor = new visoes.Setor.GerirSetor(lstSetores, f);
            gerirSetor.setVisible(true);
            add(gerirSetor);
            gerirSetor.toFront();
        }
    }
    
    public void fecharJanelaGerirSetor() {
        gerirSetor = null;
    }
}
