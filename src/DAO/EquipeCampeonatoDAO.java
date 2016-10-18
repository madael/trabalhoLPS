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
import objetos.EquipeCampeonato;

/**
 *
 * @author Daniel Lucarelli
 */
public class EquipeCampeonatoDAO {

    public static void update(EquipeCampeonato equipe) {
        String sql = "UPDATE tblaluno_equipe SET aluno_matricula=? WHERE equipe_id=? AND aluno_matricula=?";
        try {
            int i = 0;
            while (i < 5) {
                PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
                stmt.setString(1, equipe.getPlayers()[i] + "");
                stmt.setInt(2, equipe.getIdEquipe());
                stmt.setString(3, equipe.getPlayers()[i] + "");
                stmt.execute();
                stmt.close();
            }

        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql update equipe: " + e);
        }
    }

    public static void remover(EquipeCampeonato equipe) {
        String sql = "DELETE FROM tblaluno_equipe WHERE equipe_id = ?";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setInt(1, equipe.getIdEquipe());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql remover equipe: " + e);
        }
    }

    public static void adiciona(EquipeCampeonato equipe) {
        String sql = "INSERT INTO tblaluno_equipe(equipe_id,aluno_matricula) VALUES(?,?)";
        try {
            int i = 0;
            while (i < 5) {
                PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
                stmt.setString(2, equipe.getPlayers()[i] + "");
                stmt.setInt(1, equipe.getIdEquipe());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql adicionar equipe: " + e);
        }
    }

    public static EquipeCampeonato buscar(int texto) {
        EquipeCampeonato equipe = new EquipeCampeonato();
        String sql = "Select * from tblaluno_equipe where equipe_id=" + texto;
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            sql = "Select * from tblequipe where equipe_id=" + texto;
            PreparedStatement stmt1 = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset1 = stmt1.executeQuery();
            ResultSet resultset = stmt.executeQuery();
            int i = 0;
            int[] vet = new int[5];
            while (resultset.next()) {
                vet[i++] = resultset.getInt(2);
            }
            equipe = new EquipeCampeonato(resultset.getInt(1), resultset1.getString(2), vet);
            resultset.close();
            resultset1.close();
            stmt.close();
            stmt1.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql buscar equipe: " + e);
        }
        return equipe;
    }

    public static ArrayList<EquipeCampeonato> consulta() {
        ArrayList<EquipeCampeonato> list = new ArrayList<>();

        String sql = "Select * from tblaluno_equipe";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            sql = "Select * from tblequipe where equipe_id=" + resultset.getInt(1);
            PreparedStatement stmt1 = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset1 = stmt1.executeQuery();
            int i = 0, numero = -1;
            int[] vet = new int[5];
            while (resultset.next()) {
                if (numero != resultset.getInt(1)) {
                    if (numero != -1) {
                        EquipeCampeonato equipe = new EquipeCampeonato(resultset.getInt(1), resultset1.getString(2), vet);
                        list.add(equipe);
                    }
                    numero = resultset.getInt(1);
                    i=0;
                    vet = new int[5];
                    vet[i++] = resultset.getInt(2);
                } else {
                    vet[i++] = resultset.getInt(2);
                }
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel executar o sql consultar equipe: " + e);
        }

        return list;

    }

    public static EquipeCampeonato[] consulta(ArrayList<EquipeCampeonato> list) {
        EquipeCampeonato[] equipe = new EquipeCampeonato[list.size()];
        int cont = equipe.length - 1;
        for (int k = 0; k < list.size(); k++) {
            equipe[cont--] = list.get(k);
        }

        return equipe;

    }

}
