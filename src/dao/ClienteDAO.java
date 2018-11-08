/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import modelos.Cliente;

/**
 *
 * @author Laboratorio
 */
public class ClienteDAO extends DAO<Cliente>{
    
    @Override
    protected boolean inserir(Cliente element) {
        String sql = "INSERT INTO cliente "
                + "(cpf, telefone, endereco, nome) values "
                + "(?, ?, ?, ?)";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, element.getCpf());
            stmt.setString(2, element.getTelefone());
            stmt.setString(3, element.getEndereco());
            stmt.setString(4, element.getNome());
            
            System.out.println("sql:"+sql);
            if(stmt.executeUpdate()==1){
                ResultSet keys = stmt.getGeneratedKeys();
                keys.next();
                int key = keys.getInt(1);
                element.setId(key);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lst = new LinkedList<>();
        lst = org.jdesktop.observablecollections.ObservableCollections.
                                                            observableList(lst);
        
        String sql = "SELECT * FROM cliente;";
        try(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setNome(rs.getString("nome"));
                lst.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lst;
    }

    @Override
    protected boolean alterar(Cliente element) {
        String sql = "UPDATE cliente "
                + "SET cpf = ?, telefone = ?, endereco = ?, nome = ? "
                + "WHERE id_cliente = ?";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, element.getCpf());
            stmt.setString(2, element.getTelefone());
            stmt.setString(3, element.getEndereco());
            stmt.setString(4, element.getNome());
            stmt.setInt(5, element.getId());
            
            System.out.println("sql:"+sql);
            if(stmt.executeUpdate()==1){
                return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean gravar(Cliente element) {
        
        if(element.getId()==null){
            return inserir(element);
        }else{
            return alterar(element);
        }
        
    }
    
    public boolean buscar(String busca, List<Cliente> lst){
        lst.clear();
        
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?;";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1,"%"+busca+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setNome(rs.getString("nome"));
                lst.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public Cliente getById(int id){
        Cliente c = null;
        
        String sql = "SELECT * "
                + "FROM cliente "
                + "WHERE id_cliente = "+id;
        try(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()){
                c = new Cliente();
                c.setId(rs.getInt("id_cliente"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));    
                c.setNome(rs.getString("nome"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return c;
    }
    
    public boolean apagar(Cliente item) {
        if (item.getId() == null) {
            return false;
        }
        
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1,item.getId());
            
            if(stmt.executeUpdate()==1){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
