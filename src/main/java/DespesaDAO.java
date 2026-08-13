import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public DespesaDAO() {
        this.connection = new Conexao().conectar();
    }

    public void inserir(Despesa despesa) {
        sql = "insert into java_despesa(descricao, valor, data, id_categoria)" +
                " values(?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setDate(3, Date.valueOf(despesa.getDataDespesa()));
            ps.setInt(4, despesa.getCategoria().getId());
            ps.execute();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Despesa> listar() {
        List<Despesa> lista = new ArrayList<>();
        sql = "select * from java_despesa";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Despesa despesa = new Despesa();
                despesa.setId(rs.getInt("id"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setDataDespesa(rs.getDate("data").toLocalDate());
                Categoria categoria = new Categoria(rs.getInt("id_categoria"));
                despesa.setCategoria(categoria);
                lista.add(despesa);
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
