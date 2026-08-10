import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // testa a inserção da categoria
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria  = new Categoria("def");
        //categoriaDAO.inserir(categoria);

        // testa a listagem
        List<Categoria> lista = categoriaDAO.listar();
        for(Categoria c : lista) {
            System.out.print("ID: " + c.getId() + "  ");
            System.out.println("Categoria: " + c.getCategoria());
        }


    }
}
