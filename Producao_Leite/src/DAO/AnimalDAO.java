package DAO;

import util.Conecta;
import Model.Animal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Shelmo
 */
public class AnimalDAO
{
    public static void registrarAnimal(Animal animal)
    {
        Conecta c = new Conecta();
        String sql = "INSERT INTO CadastroAnimal VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        c.pStmt(sql);
        
        try
        {
            c.getPreparedStatement().setString(1, animal.getNome());
            c.getPreparedStatement().setString(2, animal.getNumero());
            c.getPreparedStatement().setString(3, animal.getRaca());
            c.getPreparedStatement().setDate(4, animal.getDataNasc());
            c.getPreparedStatement().setString(5, animal.getSexo());
            c.getPreparedStatement().setString(6, animal.getSituacao());
            c.getPreparedStatement().execute();
            c.Desconectar();
        }
        catch (SQLException ex)
        {
            c.Desconectar();
            System.err.println("Erro: " + ex.getMessage());
        }
    }
    
    public static ArrayList<Animal> getListaAnimais()
    {
        Conecta c = new Conecta();
        ArrayList<Animal> listaAnimal = new ArrayList<>();
        
        Animal animal;
        
        try
        {
            ResultSet rSet = c.getPreparedStatement().executeQuery("SELECT * FROM CadastroAnimal");
            for(;rSet.next();)
            {
                animal = new Animal();
                animal.setId(rSet.getInt("idCadastroAnimal"));
                animal.setNome(rSet.getString("nome"));
                animal.setNumero(rSet.getString("numero"));
                animal.setRaca(rSet.getString("raca"));
                animal.setDataNasc(rSet.getDate("dataNasc"));
                animal.setSexo(rSet.getString("sexo"));
                animal.setSituacao("situacao");
                listaAnimal.add(animal);
            }
            rSet.close();
            c.Desconectar();
            return listaAnimal;
        }
        catch (SQLException ex)
        {
            System.err.println("Erro: " + ex.getMessage());
            c.Desconectar();
            return listaAnimal;
        }
    }
}
