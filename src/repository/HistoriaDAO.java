package src.repository;

import src.model.Historia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoriaDAO {


    public static Historia consultarHistoria(Integer id) throws SQLException {
        Connection conn = repository.Mysql.getConnection();
        String sql = "select * from historia where id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs.getInt("id"));

        Historia historia = new Historia();
        if(rs.next()) {
            historia.setId(rs.getInt("id"));
            historia.setTitulo(rs.getString("titulo"));
            //System.out.println(historia);
        }
        return historia;
    }

    public static List<Historia> todasHistorias() throws SQLException {
        Connection conn = repository.Mysql.getConnection();
        String sql = "select * from historia";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Historia> historias1 = new ArrayList<>();
        while (rs.next()){
            Historia historia = new Historia();
            historia.setId(rs.getInt("id"));
            historia.setTitulo(rs.getString("titulo"));

            historias1.add(historia);
        }
        return historias1;
    }

    //teste do sql
    /*public static void main(String[] args) throws SQLException {

        try {
            System.out.println(todasHistorias());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
