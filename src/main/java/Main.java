import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // testa a inserção da categoria
        /*CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria  = new Categoria("def");
        //categoriaDAO.inserir(categoria);

        // testa a listagem
        List<Categoria> lista = categoriaDAO.listar();
        for(Categoria c : lista) {
            System.out.print("ID: " + c.getId() + "  ");
            System.out.println("Categoria: " + c.getCategoria());
        }

        System.out.println(categoriaDAO.pesquisar(31));*/

        // testando a insrção na tabela java_despesa
        DespesaDAO despesaDAO = new DespesaDAO();
        Despesa despesa = new Despesa();
        despesa.setDescricao("camiseta");
        despesa.setValor(100.32);
        despesa.setDataDespesa(LocalDate.now());
        despesa.setCategoria(new Categoria(31));
        despesaDAO.inserir(despesa);

    }
}
