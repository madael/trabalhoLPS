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
    
    public static void update(Aluno aluno) {
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
            stmt.setString(1, aluno.getSenha());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getRg());
            stmt.setString(5, aluno.getEmail());
            stmt.setString(6, aluno.getNickname());
            stmt.setInt(7, aluno.getIdCurso());
            stmt.setString(8, aluno.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql update aluno: " + e);
        }
    }
    
    public static void remover(Aluno aluno) {
        String sql = "DELETE FROM tblaluno WHERE aluno_matricula = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, aluno.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql remover aluno: " + e);
        }
    }
    
    public static void adiciona(Aluno aluno) {
        String sql = "INSERT INTO tblaluno(aluno_matricula,aluno_senha,aluno_nome,aluno_cpf,aluno_rg,aluno_email,aluno_nickname,curso_ID)"
                    +" VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getSenha());
            stmt.setString(3, aluno.getNome());
            stmt.setString(4, aluno.getCpf());
            stmt.setString(5, aluno.getRg());
            stmt.setString(6, aluno.getEmail());
            stmt.setString(7, aluno.getNickname());
            stmt.setInt(8, aluno.getIdCurso());            
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql adicionar aluno: " + e);
        }
    }   
    
    public static Aluno buscar(int texto){
        Aluno aluno = new Aluno();
        String sql = "Select * from tblaluno where aluno_matricula="+texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            aluno = new Aluno(resultset.getString(1), 
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
            System.out.println("Não foi possivel executar o sql buscar aluno: " + e);
        }
        return aluno;
    }
    
    public static Aluno buscar(String texto){
        Aluno aluno = new Aluno();
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(texto);
            ResultSet resultset = stmt.executeQuery();
            resultset.next();
            aluno = new Aluno(resultset.getString(1), 
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
            System.out.println("Não foi possivel executar o sql buscar aluno" + e);
        }
        return aluno;
    }
    
    public static ArrayList<Aluno> consulta() {
        ArrayList<Aluno> list = new ArrayList<>();

        String sql = "Select * from tblaluno";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Aluno aluno = new Aluno(resultset.getString(1), 
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
                    resultset.getString(6),
                    resultset.getString(7), 
                    resultset.getInt(8));
                list.add(aluno);
             }                           
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql consultar aluno: "+e);
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
