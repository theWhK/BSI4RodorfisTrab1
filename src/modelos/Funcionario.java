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
public class Funcionario extends Pessoa implements Cloneable 
{
    public Funcionario getClone(){
        try{
            return (Funcionario)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
    
    private String codInterno;

    public static final String PROP_CODINTERNO = "codInterno";

    public String getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(String codInterno) {
        String oldCodInterno = this.codInterno;
        this.codInterno = codInterno;
        propertyChangeSupport.firePropertyChange(PROP_CODINTERNO, oldCodInterno, codInterno);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
}
