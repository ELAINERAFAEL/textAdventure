import model.Cena;
import model.Item;
import repository.CenaDAO;
import repository.ItemDAO;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Cena cena = CenaDAO.findCenaById(1);
            System.out.println(cena.toString());

            List<Item> itens = ItemDAO.findItensByScene(cena);
            System.out.println("Itens: " + itens);

            List<Cena> cenas = CenaDAO.findAll();
            System.out.println("Cenas antes do insert:");
            System.out.println(cenas);

            Cena novaCena = new Cena();
            novaCena.setDescricao("Nova cena que foi inserida pelo java brabíssimo");
            CenaDAO.insertCena(novaCena);

            cenas = CenaDAO.findAll();
            System.out.println("Cenas depois do insert:");
            System.out.println(cenas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}