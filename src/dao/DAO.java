/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Laboratorio
 */
public abstract class DAO<E> {
    
    protected Connection conn;
    
    public DAO(){
        String url = "jdbc:mysql://localhost/mercadomais";
        String user = "root";
        String password = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,
                                                password);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    protected boolean close(){
        try{
            conn.close();
            return true;
        }
        catch(SQLException e){e.printStackTrace();}
        return false;
    }
    
    protected abstract boolean inserir(E element);
    public abstract List<E> listar();
    protected abstract boolean alterar(E element);
    public abstract boolean gravar(E element);
    public abstract boolean apagar(E element);
    
}
