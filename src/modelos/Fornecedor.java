/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author willh
 */
public class Fornecedor implements Cloneable {
    
    public Fornecedor getClone(){
        try{
            return (Fornecedor)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    private String nomeFantasia;

    public static final String PROP_NOMEFANTASIA = "nomeFantasia";

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        String oldNomeFantasia = this.nomeFantasia;
        this.nomeFantasia = nomeFantasia;
        propertyChangeSupport.firePropertyChange(PROP_NOMEFANTASIA, oldNomeFantasia, nomeFantasia);
    }


    private String cnpj;

    public static final String PROP_CNPJ = "cnpj";

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        String oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        propertyChangeSupport.firePropertyChange(PROP_CNPJ, oldCnpj, cnpj);
    }

    private String endereco;

    public static final String PROP_ENDERECO = "endereco";

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, endereco);
    }


    private String telefone;

    public static final String PROP_TELEFONE = "telefone";

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        propertyChangeSupport.firePropertyChange(PROP_TELEFONE, oldTelefone, telefone);
    }


    private String razaoSocial;

    public static final String PROP_RAZAOSOCIAL = "razaoSocial";

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        String oldRazaoSocial = this.razaoSocial;
        this.razaoSocial = razaoSocial;
        propertyChangeSupport.firePropertyChange(PROP_RAZAOSOCIAL, oldRazaoSocial, razaoSocial);
    }

    final transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
}
