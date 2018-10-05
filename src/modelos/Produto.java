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
public class Produto implements Cloneable {
    
    public Produto getClone(){
        try{
            return (Produto)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
    
    private String descricao;

    public static final String PROP_DESCRICAO = "descricao";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }

    private String ean;

    public static final String PROP_EAN = "ean";

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        String oldEan = this.ean;
        this.ean = ean;
        propertyChangeSupport.firePropertyChange(PROP_EAN, oldEan, ean);
    }
    
    private float qtdEstoque;

    public static final String PROP_QTDESTOQUE = "qtdEstoque";

    public float getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(float qtdEstoque) {
        float oldQtdEstoque = this.qtdEstoque;
        this.qtdEstoque = qtdEstoque;
        propertyChangeSupport.firePropertyChange(PROP_QTDESTOQUE, oldQtdEstoque, qtdEstoque);
    }

    private float preco;

    public static final String PROP_PRECO = "preco";

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        float oldPreco = this.preco;
        this.preco = preco;
        propertyChangeSupport.firePropertyChange(PROP_PRECO, oldPreco, preco);
    }

    private float custo;

    public static final String PROP_CUSTO = "custo";

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        float oldCusto = this.custo;
        this.custo = custo;
        propertyChangeSupport.firePropertyChange(PROP_CUSTO, oldCusto, custo);
    }
    
    final transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
