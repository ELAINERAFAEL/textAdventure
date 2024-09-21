package BancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {

    public static Save novoJogo() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "insert into historia values (null, 'teste')";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        System.out.println(save);


        return null;
    }
}