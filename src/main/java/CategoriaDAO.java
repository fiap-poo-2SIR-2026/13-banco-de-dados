import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Conexao conexao;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public CategoriaDAO() {
        this.conexao = new Conexao();
        this.connection = conexao.conectar();
    }

    public void inserir(Categoria categoria) {
        sql = "insert into java_categoria(categoria) values (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
            ps.execute();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Categoria> listar() {
        sql = "select * from java_categoria";
        List<Categoria> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                lista.add(new Categoria(rs.getInt("id"),
                        rs.getString("categoria")));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public String pesquisar(int id) {
        sql = "select * from java_categoria where id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getString("categoria");
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
