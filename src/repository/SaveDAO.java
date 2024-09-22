package src.repository;

import src.model.Save;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaveDAO {


    public static Save consultarSave(String jogador) throws SQLException {
        Connection conn = repository.Mysql.getConnection();
        String sql = "select * from save where jogador = ? order by id_save desc limit 1";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, jogador);
        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs.getInt("id"));

        Save save = new Save();
        if(rs.next()) {
            save.setId_save(rs.getInt("id_save"));
            save.setId_fase(rs.getInt("id_fase"));
            save.setJogador(rs.getString("jogador"));
            //System.out.println(save);
        }
        return save;
    }

    public static String salvarJogo(Integer id,String jogador) throws SQLException {
        Connection conn = repository.Mysql.getConnection();
        String sql = " insert into save values (null,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, jogador);
        int rowsAffected = stmt.executeUpdate();
        String resultado = (rowsAffected > 0) ? "Sucesso!" : "Erro!";
        return resultado;
    }

    //teste do sql
    public static void main(String[] args) throws SQLException {

        try {
            System.out.println(salvarJogo(4,"Camila"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
