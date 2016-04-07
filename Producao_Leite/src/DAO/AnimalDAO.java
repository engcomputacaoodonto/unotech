package DAO;

import util.Conecta;
import Model.Animal;
import java.sql.SQLException;
/**
 *
 * @author Shelmo
 */
public class AnimalDAO
{
    public void registrarAnimal(Animal animal)
    {
        Conecta c = new Conecta();
        String sql = "INSERT INTO Animal VALUES (NULL, ?, ?, ?, ?, ?, ?)";
        c.pStmt(sql);
        
        try
        {
            c.getPreparedStatement().setString(1, animal.getNome());
            c.getPreparedStatement().setString(2, animal.getNumero());
            c.getPreparedStatement().setString(3, animal.getRaca());
            c.getPreparedStatement().setDate(4, animal.getDataNasc());
        }
        catch (SQLException ex)
        {
            c.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
}
