/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author willh
 */
public class Cargo implements Cloneable {
    
    public Cargo getClone(){
        try{
            return (Cargo)this.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

        private Setor[] setoresPermitidos;

    // TODO getter e setter do setor

    public Setor[] getSetoresPermitidos() {
        return setoresPermitidos;
    }

    public void setSetoresPermitidos(Setor[] setoresPermitidos) {
        this.setoresPermitidos = setoresPermitidos;
    }

    
}
