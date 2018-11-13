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
import modelos.Fornecedor;

/**
 *
 * @author Laboratorio
 */
public class FornecedorDAO extends DAO<Fornecedor>{
    
    @Override
    protected boolean inserir(Fornecedor element) {
        String sql = "INSERT INTO fornecedor "
                + "(cnpj, telefone, endereco, razaosocial, nomefantasia) values "
                + "(?, ?, ?, ?, ?)";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, element.getCnpj());
            stmt.setString(2, element.getTelefone());
            stmt.setString(3, element.getEndereco());
            stmt.setString(4, element.getRazaoSocial());
            stmt.setString(5, element.getNomeFantasia());
            
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
    public List<Fornecedor> listar() {
        List<Fornecedor> lst = new LinkedList<>();
        lst = org.jdesktop.observablecollections.ObservableCollections.
                                                            observableList(lst);
        
        String sql = "SELECT * FROM fornecedor;";
        try(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()){
                Fornecedor c = new Fornecedor();
                c.setId(rs.getInt("id_fornecedor"));
                c.setCnpj(rs.getString("cnpj"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setRazaoSocial(rs.getString("razaosocial"));
                c.setNomeFantasia(rs.getString("nomefantasia"));
                lst.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lst;
    }

    @Override
    protected boolean alterar(Fornecedor element) {
        String sql = "UPDATE fornecedor "
                + "SET cnpj = ?, telefone = ?, endereco = ?, razaosocial = ?, nomefantasia = ? "
                + "WHERE id_fornecedor = ?";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, element.getCnpj());
            stmt.setString(2, element.getTelefone());
            stmt.setString(3, element.getEndereco());
            stmt.setString(4, element.getRazaoSocial());
            stmt.setString(5, element.getNomeFantasia());
            stmt.setInt(6, element.getId());
            
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
    public boolean gravar(Fornecedor element) {
        
        if(element.getId()==null){
            return inserir(element);
        }else{
            return alterar(element);
        }
        
    }
    
    public boolean buscar(String busca, List<Fornecedor> lst){
        lst.clear();
        
        String sql = "SELECT * FROM fornecedor WHERE nomefantasia LIKE ?;";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1,"%"+busca+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor c = new Fornecedor();
                c.setId(rs.getInt("id_fornecedor"));
                c.setCnpj(rs.getString("cnpj"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setRazaoSocial(rs.getString("razaosocial"));
                c.setNomeFantasia(rs.getString("nomefantasia"));
                lst.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public Fornecedor getById(int id){
        Fornecedor c = null;
        
        String sql = "SELECT * "
                + "FROM fornecedor "
                + "WHERE id_fornecedor = "+id;
        try(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()){
                c = new Fornecedor();
                c.setId(rs.getInt("id_fornecedor"));
                c.setCnpj(rs.getString("cnpj"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setRazaoSocial(rs.getString("razaosocial"));
                c.setNomeFantasia(rs.getString("nomefantasia"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return c;
    }
    
    public boolean apagar(Fornecedor item) {
        if (item.getId() == null) {
            return false;
        }
        
        String sql = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
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
