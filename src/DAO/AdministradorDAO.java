/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import objetos.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel Lucarelli
 */
public class AdministradorDAO {
    
    public static void update(Administrador adm) {
        String sql = "UPDATE tbladministrador SET aluno_nome=?, senha = ? WHERE idAdm=?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getSenha());
            stmt.setInt(3, adm.getIdAdm());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql update adm: " + e);
        }
    }
    
    public static void remover(Administrador adm) {
        String sql = "DELETE FROM tbladministrador WHERE idAdm = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setInt(1, adm.getIdAdm());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql remover adm: " + e);
        }
    }
    
    public static void adiciona(Administrador adm) {
        String sql = "INSERT INTO tbladministrador(idAdm,nome,senha) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setInt(1, adm.getIdAdm()); 
            stmt.setString(2, adm.getNome());
            stmt.setString(3, adm.getSenha());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql adicionar adm: " + e);
        }
    }   
    
    public static Administrador buscar(int texto){
        Administrador adm = new Administrador();
        String sql = "Select * from tbladministrador where aluno_matricula="+texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            adm = new Administrador(resultset.getInt(1), resultset.getString(2),resultset.getString(3));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql buscar adm: " + e);
        }
        return adm;
    }
    
    public static Administrador buscar(String texto){
        Administrador adm = new Administrador();
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(texto);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            adm = new Administrador(resultset.getInt(1),resultset.getString(2),resultset.getString(3));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql buscar adm" + e);
        }
        return adm;
    }
    
    public static ArrayList<Administrador> consulta() {
        ArrayList<Administrador> list = new ArrayList<>();

        String sql = "Select * from tbladministrador";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Administrador adm = new Administrador(resultset.getInt(1),resultset.getString(2),resultset.getString(3));
                list.add(adm);
             }                           
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql consultar adm: "+e);
        }

        return list;

    }
    
    public static Administrador[] consulta(ArrayList<Administrador> list) {
        Administrador[] usuario = new Administrador[list.size()];
        int cont = usuario.length-1;
        for(int k=0;k<list.size();k++){
            usuario[cont--]=list.get(k);
        }

        return usuario;

    }
    

}
