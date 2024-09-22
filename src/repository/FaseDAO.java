package src.repository;

import src.model.Fases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaseDAO {


    public static Fases consultarFase(Integer id) throws SQLException {
        Connection conn = repository.Mysql.getConnection();
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


    //teste do sql
    /*public static void main(String[] args) throws SQLException {

        try {
            System.out.println(consultarFase(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
