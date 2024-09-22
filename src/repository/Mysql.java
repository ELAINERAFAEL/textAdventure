package src.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost3306/Textadventure",
                    "root",
                    ""
            );
            return connection;
        } catch (SQLException e) {
            System.out.println("erro ao tentar  conectar");
        } catch (ClassNotFoundException e) {
            System.out.println("erro ao importar drive");
        }
        return null;
    }
}
