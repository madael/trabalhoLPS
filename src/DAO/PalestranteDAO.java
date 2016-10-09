/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import objetos.Palestrante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel Lucarelli
 */
public class PalestranteDAO {
    
    public static void update(Palestrante palestrante) {
        String sql = "UPDATE tblpalestrante SET palestrante_nome = ?,"
                + "palestrante_universidade=?, "
                + "palestrante_area=?, "
                + "palestrante_minicurriculo=? WHERE palestrante_id =?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, palestrante.getNome());
            stmt.setString(2, palestrante.getUniversidade());
            stmt.setString(3, palestrante.getArea());
            stmt.setString(4, palestrante.getMinicurso());
            stmt.setInt(5, palestrante.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql update palestrante: " + e);
        }
    }
    
    public static void remover(Palestrante palestrante) {
        String sql = "DELETE FROM tblpalestrante WHERE palestrante_id = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setInt(1, palestrante.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql remover palestrante: " + e);
        }
    }
    
    public static void adiciona(Palestrante palestrante) {
        String sql  ="INSERT INTO tblpalestrante(palestrante_nome,palestrante_universidade,palestrante_area,palestrante_minicurriculo) "
                    +"VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, palestrante.getNome());
            stmt.setString(2, palestrante.getUniversidade());
            stmt.setString(3, palestrante.getArea());
            stmt.setString(4, palestrante.getMinicurso());
            stmt.setInt(5, palestrante.getId());       
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql adicionar palestrante: " + e);
        }
    }   
    
    public static Palestrante buscar(int texto){
        Palestrante palestrante = new Palestrante();
        String sql = "Select * from tblpalestrante where palestrante_id="+texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            palestrante = new Palestrante(resultset.getInt(1),
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql buscar patrocinador" + e);
        }
        return palestrante;
    }
    
    public static Palestrante buscar(String sql){
        Palestrante palestrante = new Palestrante();
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            palestrante = new Palestrante(resultset.getInt(1),
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql buscar patrocinador" + e);
        }
        return palestrante;
    }
    
    public static ArrayList<Palestrante> consulta() {
        ArrayList<Palestrante> list = new ArrayList<>();

        String sql = "Select * from tblpalestrante";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Palestrante palestrante = new Palestrante(resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5));
                list.add(palestrante);
             }                           
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql consulta patrocinador" + e);
        }

        return list;

    }
    
    public static Palestrante[] consulta(ArrayList<Palestrante> list) {
        Palestrante[] palestrante = new Palestrante[list.size()];
        int cont = palestrante.length-1;
        for(int k=0;k<list.size();k++){
            palestrante[cont--]=list.get(k);
        }

        return palestrante;

    }
    

}
