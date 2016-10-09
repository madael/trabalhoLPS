/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import objetos.Patrocinador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel Lucarelli
 */
public class PatrocinadorDAO {
    
    public static void update(Patrocinador patrocinador) {
        String sql = "UPDATE tblpatrocinador SET patrocinador_nome = ? WHERE patrocinador_id =?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, patrocinador.getNome());
            stmt.setString(2, patrocinador.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql update patrocinador: " + e);
        }
    }
    
    public static void remover(Patrocinador patrocinador) {
        String sql = "DELETE FROM tblpatrocinador WHERE patrocinador_id = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, patrocinador.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql remover patrocinador: " + e);
        }
    }
    
    public static void adiciona(Patrocinador patrocinador) {
        String sql = "INSERT INTO tblpatrocinador(patrocinador_nome) VALUES(?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, patrocinador.getNome());       
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql adicionar patrocinador: " + e);
        }
    }   
    
    public static Patrocinador buscar(int texto){
        Patrocinador patrocinador = new Patrocinador();
        String sql = "Select * from tblpatrocinador where patrocinador_id="+texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            patrocinador = new Patrocinador(resultset.getString(1),resultset.getString(2));
            
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql buscar patrocinador" + e);
        }
        return patrocinador;
    }
    
    public static Patrocinador buscar(String sql){
        Patrocinador patrocinador = new Patrocinador();
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            patrocinador = new Patrocinador(resultset.getString(1),resultset.getString(2));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql buscar patrocinador" + e);
        }
        return patrocinador;
    }
    
    public static ArrayList<Patrocinador> consulta() {
        ArrayList<Patrocinador> list = new ArrayList<>();

        String sql = "Select * from tblpatrocinador";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Patrocinador patrocinador = new Patrocinador(resultset.getString(1), resultset.getString(2));
                list.add(patrocinador);
             }                           
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql consulta patrocinador" + e);
        }

        return list;

    }
    
    public static Patrocinador[] consulta(ArrayList<Patrocinador> list) {
        Patrocinador[] patrocinador = new Patrocinador[list.size()];
        int cont = patrocinador.length-1;
        for(int k=0;k<list.size();k++){
            patrocinador[cont--]=list.get(k);
        }

        return patrocinador;

    }
    

}
