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
import modelos.Setor;

/**
 *
 * @author Laboratorio
 */
public class SetorDAO extends DAO<Setor>{
    
    @Override
    protected boolean inserir(Setor element) {
        String sql = "INSERT INTO setor "
                + "(descricao) values "
                + "(?)";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, element.getDescricao());
            
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
    public List<Setor> listar() {
        List<Setor> lst = new LinkedList<>();
        lst = org.jdesktop.observablecollections.ObservableCollections.
                                                            observableList(lst);
        
        String sql = "SELECT * FROM setor;";
        try(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()){
                Setor c = new Setor();
                c.setId(rs.getInt("id_setor"));
                c.setDescricao(rs.getString("descricao"));
                lst.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lst;
    }

    @Override
    protected boolean alterar(Setor element) {
        String sql = "UPDATE setor "
                + "SET descricao = ? "
                + "WHERE id_setor = ?";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, element.getDescricao());
            stmt.setInt(2, element.getId());
            
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
    public boolean gravar(Setor element) {
        
        if(element.getId()==null){
            return inserir(element);
        }else{
            return alterar(element);
        }
        
    }
    
    public boolean buscar(String busca, List<Setor> lst){
        lst.clear();
        
        String sql = "SELECT * FROM setor WHERE descricao LIKE ?;";
        try(
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1,"%"+busca+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Setor c = new Setor();
                c.setId(rs.getInt("id_setor"));
                c.setDescricao(rs.getString("descricao"));
                lst.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public Setor getById(int id){
        Setor c = null;
        
        String sql = "SELECT * "
                + "FROM setor "
                + "WHERE id_setor = "+id;
        try(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            if(rs.next()){
                c = new Setor();
                c.setId(rs.getInt("id_setor"));
                c.setDescricao(rs.getString("descricao"));             
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return c;
    }
    
    public boolean apagar(Setor item) {
        if (item.getId() == null) {
            return false;
        }
        
        String sql = "DELETE FROM setor WHERE id_setor = ?";
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
