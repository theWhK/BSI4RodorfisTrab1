/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import java.util.List;
import modelos.Cargo;
import modelos.Cliente;
import modelos.Fornecedor;
import modelos.Funcionario;
import modelos.Produto;
import modelos.Setor;

/**
 *
 * @author willh
 */
public class Data {
    private static Data instancia;
    private List<Cliente> lstClientes;
    private List<Setor> lstSetores;
    private List<Fornecedor> lstFornecedores;
    private List<Produto> lstProdutos;
    private List<Funcionario> lstFuncionarios;
    private List<Cargo> lstCargos;
    
    private Data() {
        this.lstCargos = new ArrayList<>();
        this.lstCargos = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstCargos);
        this.lstClientes = new ArrayList<>();
        this.lstClientes = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstClientes);
        this.lstSetores = new ArrayList<>();
        this.lstSetores = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstSetores);
        this.lstFornecedores = new ArrayList<>();
        this.lstFornecedores = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstFornecedores);
        this.lstProdutos = new ArrayList<>();
        this.lstProdutos = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstProdutos);
        this.lstFuncionarios = new ArrayList<>();
        this.lstFuncionarios = org.jdesktop.observablecollections.ObservableCollections.observableList(this.lstFuncionarios);
    }
    
    public static Data hi() {
        if (instancia == null) {
            instancia = new Data();
        }
        
        return instancia;
    }

    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    public List<Setor> getLstSetores() {
        return lstSetores;
    }

    public List<Fornecedor> getLstFornecedores() {
        return lstFornecedores;
    }

    public List<Produto> getLstProdutos() {
        return lstProdutos;
    }

    public List<Funcionario> getLstFuncionarios() {
        return lstFuncionarios;
    }

    public List<Cargo> getLstCargos() {
        return lstCargos;
    }
}
