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
        }
        catch (SQLException ex)
        {
            c.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
}
