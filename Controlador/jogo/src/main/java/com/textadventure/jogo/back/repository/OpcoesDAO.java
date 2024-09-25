package com.textadventure.jogo.back.repository;


import com.textadventure.jogo.back.model.Opcoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpcoesDAO {


    public static Opcoes consultarOpcao(String opcaot) throws SQLException {
        Connection conn = com.textadventure.jogo.back.repository.Mysql.getConnection();
        String sql = "select * from opcoes where opcao = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, opcaot);
        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs.getInt("id"));

        Opcoes opcao = new Opcoes();
        if(rs.next()) {
            opcao.setId_opcoes(rs.getInt("id_opcoes"));
            opcao.setId_fase(rs.getInt("id_fase"));
            opcao.setOpcao(rs.getString("opcao"));
            opcao.setDestino(rs.getInt("destino"));
            //System.out.println(opcao);
        }
        return opcao;
    }

    public static List<Opcoes> todasOpcoes(Integer id) throws SQLException {
        Connection conn = com.textadventure.jogo.back.repository.Mysql.getConnection();
        String sql = "select * from opcoes where id_fase = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        List<Opcoes> opcoes = new ArrayList<>();
        while (rs.next()){
            Opcoes opcoes1 = new Opcoes();
            opcoes1.setId_opcoes(rs.getInt("id_opcoes"));
            opcoes1.setId_fase(rs.getInt("id_fase"));
            opcoes1.setOpcao(rs.getString("opcao"));
            opcoes1.setDestino(rs.getInt("destino"));
            opcoes.add(opcoes1);
        }
        return opcoes;
    }

    //teste do sql
    /*public static void main(String[] args) throws SQLException {

        try {
            System.out.println(consultarOpcao("marea"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
