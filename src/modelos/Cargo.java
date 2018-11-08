/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author willh
 */
public class Cargo implements Cloneable {
    
    public Cargo() {
        if (this.setoresPermitidos == null) {
            this.setoresPermitidos = new ArrayList<>();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public Cargo getClone(){
        try{
            return (Cargo)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private List<Setor> setoresPermitidos;

    public List<Setor> getSetoresPermitidos() {
        return setoresPermitidos;
    }

    public void setSetoresPermitidos(List<Setor> setoresPermitidos) {
        this.setoresPermitidos = setoresPermitidos;
    }
    
    public boolean addSetorPermitido(Setor s) {
        if (this.setoresPermitidos.contains(s)) return true;
        
        return this.setoresPermitidos.add(s);
    }
    
    public boolean removeSetorPermitido(Setor s) {
        if (!this.setoresPermitidos.contains(s)) return true;
        
        return this.setoresPermitidos.remove(s);
    }
}
