package com.textadventure.jogo.back.repository;

import com.textadventure.jogo.back.model.Fases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaseDAO {


    public static Fases consultarFase(Integer id) throws SQLException {
        Connection conn = com.textadventure.jogo.back.repository.Mysql.getConnection();
        String sql = "select * from Fase where id_fase = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs.getInt("id"));

        Fases fase = new Fases();
        if(rs.next()) {
            fase.setId_fase(rs.getInt("id_fase"));
            fase.setId_historia(rs.getInt("id_historia"));
            fase.setNumero(rs.getInt("numero"));
            fase.setDescricao(rs.getString("descricao"));
            //System.out.println(fase);
        }
        return fase;
    }

    public static Fases novaFase(Integer id) throws SQLException {
        Connection conn = com.textadventure.jogo.back.repository.Mysql.getConnection();
        String sql = "select * from Fase where id_fase = ? and id_historia = 1";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs.getInt("id"));

        Fases fase = new Fases();
        if(rs.next()) {
            fase.setId_fase(rs.getInt("id_fase"));
            fase.setId_historia(rs.getInt("id_historia"));
            fase.setNumero(rs.getInt("numero"));
            fase.setDescricao(rs.getString("descricao"));
            //System.out.println(fase);
        }
        return fase;
    }

    public static List<String> todasOpcoes(Integer id) throws SQLException {
        Connection conn = com.textadventure.jogo.back.repository.Mysql.getConnection();
        String sql = "select * from opcoes where id_fase = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<String> opcoes1 = new ArrayList<>();
        while (rs.next()){
            opcoes1.add(rs.getString("opcao"));
        }
        return opcoes1;
    }

    public static List<String> proximaFase(String opcao) throws SQLException {
        OpcoesDAO opcaoatual = new OpcoesDAO();
        Integer destino = opcaoatual.consultarOpcao(opcao).getDestino();

        List<String> opcoes1 = new ArrayList<>();
        //System.out.println(destino);

        if(!(destino == null)){
            if (!(todasOpcoes(destino).isEmpty())) {
                opcoes1 = todasOpcoes(destino);

                Fases novafase = consultarFase(destino);
                opcoes1.add(0, novafase.getDescricao());
                opcoes1.add(1, "Escolha uma das opções: ");
            } else {
                Fases novafase = consultarFase(destino);
                opcoes1.add(0, novafase.getDescricao());
                opcoes1.add(1, "Parabéns, você concluiu o jogo!");
            }
        } else {
            opcoes1.add("Comando Inválido");
            opcoes1.add("Digite um comando válido!");
        }


        return opcoes1;
    }

    public static List<String> carregarFase(Integer id) throws SQLException {
        Fases faseatual = novaFase(id);

        List<String> opcoes1 = new ArrayList<>();

        if(!faseatual.getDescricao().isEmpty()){
            opcoes1 = todasOpcoes(id);

            opcoes1.add(0, faseatual.getDescricao());
            opcoes1.add(1, "Escolha uma das opções: ");
        } else {
            opcoes1.add("Comando Inválido");
        }


        return opcoes1;
    }

    public static Integer idFase(String opcao) throws SQLException {
        OpcoesDAO opcaoatual = new OpcoesDAO();
        Integer destino = opcaoatual.consultarOpcao(opcao).getDestino();

        Integer faseid = null;

        if(!(destino == null)){


            faseid = consultarFase(destino).getId_fase();

        }


        return faseid;
    }

    //teste do sql
 /*public static void main(String[] args) throws SQLException {

        try {
            System.out.println(proximaFase("adentro"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
