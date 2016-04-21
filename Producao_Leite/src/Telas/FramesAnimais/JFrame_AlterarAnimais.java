package Telas.FramesAnimais;

import DAO.AnimalDAO;
import Model.Animal;
import Telas.FramePrincipal.JFrame_Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Shelmo
 */
public class JFrame_AlterarAnimais extends JFrame_Animal
{
    private Animal animal = new Animal();
    private int select;
    
    public JFrame_AlterarAnimais(Animal animal, int select)
    {
        super();
        this.animal = animal;
        this.select = select;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String format = sdf.format(this.animal.getDataNasc());
        
        getjLabel_Titulo().setText("Alterar Animal");
        getjButton_Confirmar().setText("Salvar Alterações");
        getjLabel_Aviso().setText("Alterações não salvas serão perdidas!");
        
        getjTextField_Nome().setText(animal.getNome());
        getjFormattedTextField_Numero().setText(animal.getNumero());
        getjTextField_Raca().setText(animal.getRaca());
        getjFormattedTextField_Data_Nasc().setText(format);
        
        
        if(this.animal.getSexo().equals("M"))
            getjCheckBox_Macho().setSelected(true);
        if(this.animal.getSexo().equals("F"))
            getjCheckBox_Femea().setSelected(true);
        
        if(this.animal.getSituacao().equals("A"))
            getjCheckBox_Ativo().setSelected(true);
        if(this.animal.getSituacao().equals("M"))
            getjCheckBox_Morte().setSelected(true);
        if(this.animal.getSituacao().equals("V"))
            getjCheckBox_Venda().setSelected(true);
    }
    
    public void Confirmar()
    {
        clearJLabel();
        
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
            AnimalDAO.alterarAnimal(animal);
            //JPanel_Animal.AlterarAnimalList(animal, select);
        }
        else
            return;
        
        dispose();
    }
}
