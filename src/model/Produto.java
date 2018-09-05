/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author willh
 */
public class Produto {
    
        private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

        private String ean;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
    
        private float qtdEstoque;

    public float getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(float qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

        private float preco;

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

        private float custo;

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

}
