package Telas.FramesAnimais;

import DAO.AnimalDAO;
import Model.Animal;
import Telas.FramePrincipal.JTable_Tabela;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Shelmo
 */
public class JFrame_CadastrarAnimais extends JFrame_Animal
{
    Animal animal;
    
    public JFrame_CadastrarAnimais()
    {
        super("src\\Telas\\FramesAnimais\\Add_BackGround.jpg");
        getjLabel_Titulo().setText("Cadastrar Animal");
        getjButton_Confirmar().setText("Salvar");
        getjLabel_Aviso().setOpaque(true);
        getjLabel_Aviso().setText("Os campos marcados com (*) devem ser preenchidos ou marcados!");
    }
    public void Confirmar()
    {
        clearJLabel();
        
        animal = new Animal();
        animal.setNome(getjTextField_Nome().getText());
        animal.setNumero(getjFormattedTextField_Numero().getText());
        animal.setRaca(getjTextField_Raca().getText());
        
        if(getjCheckBox_Macho().isSelected())
            animal.setSexo("M");
        if(getjCheckBox_Femea().isSelected())
            animal.setSexo("F");
        
        if(getjCheckBox_Ativo().isSelected())
            animal.setSituacao("A");
        if(getjCheckBox_Morte().isSelected())
            animal.setSituacao("M");
        if(getjCheckBox_Venda().isSelected())
            animal.setSituacao("V");
        
        if(!getjFormattedTextField_Data_Nasc().getText().equals("__/__/____"))
        {
            try
            { 
                java.util.Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(getjFormattedTextField_Data_Nasc().getText());
                Date data = new Date(dataUtil.getTime());
                animal.setDataNasc(data);
            }
            catch (ParseException ex)
            {
                getjLabel_Erro_Data_Nasc().setText("Data inválida!");
                return;
            }
        }
        
        if(verificacoes(animal))
        {
            AnimalDAO.registrarAnimal(animal);
            JTable_Tabela.addAnimal(animal);
        }
        else
            return;
        
        clearJTextField();
    }
}
