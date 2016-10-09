/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import objetos.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel Lucarelli
 */
public class AlunoDAO {
    
    public static void update(Aluno usuario) {
        String sql = "UPDATE tblaluno SET "
                + "aluno_senha = ?, "
                + "aluno_nome=?, "
                + "aluno_cpf=?, "
                + "aluno_rg=?, "
                + "aluno_email=?, "
                + "aluno_nickname=?, " 
                + "curso_ID=? WHERE aluno_matricula=?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getRg());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getNickname());
            stmt.setInt(7, usuario.getIdCurso());
            stmt.setString(8, usuario.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql update usuario: " + e);
        }
    }
    
    public static void remover(Aluno usuario) {
        String sql = "DELETE FROM tblaluno WHERE aluno_matricula = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, usuario.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql remover usuario: " + e);
        }
    }
    
    public static void adiciona(Aluno usuario) {
        String sql = "INSERT INTO tblaluno(aluno_matricula,aluno_senha,aluno_nome,aluno_cpf,aluno_rg,aluno_email,aluno_nickname,curso_ID)"
                    +" VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, usuario.getMatricula());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getRg());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getNickname());
            stmt.setInt(8, usuario.getIdCurso());            
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql adicionar usuario: " + e);
        }
    }   
    
    public static Aluno buscar(int texto){
        Aluno usuario = new Aluno();
        String sql = "Select * from aluno where codigo_aluno="+texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            usuario = new Aluno(resultset.getString(1), 
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
                    resultset.getString(6),
                    resultset.getString(7), 
                    resultset.getInt(8));
            
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql aluno" + e);
        }
        return usuario;
    }
    
    public static Aluno buscar(String texto){
        Aluno usuario = new Aluno();
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(texto);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            usuario = new Aluno(resultset.getString(1), 
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
                    resultset.getString(6),
                    resultset.getString(7), 
                    resultset.getInt(8));
            resultset.close();
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql aluno" + e);
        }
        return usuario;
    }
    
    public static ArrayList<Aluno> consulta() {
        ArrayList<Aluno> list = new ArrayList<>();

        String sql = "Select * from aluno";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Aluno usuario = new Aluno(resultset.getString(1), 
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
                    resultset.getString(6),
                    resultset.getString(7), 
                    resultset.getInt(8));
                list.add(usuario);
             }                           
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql aluno");
        }

        return list;

    }
    
    public static Aluno[] consulta(ArrayList<Aluno> list) {
        Aluno[] usuario = new Aluno[list.size()];
        int cont = usuario.length-1;
        for(int k=0;k<list.size();k++){
            usuario[cont--]=list.get(k);
        }

        return usuario;

    }
    

}
