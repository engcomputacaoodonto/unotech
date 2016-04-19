package Telas.FramesAnimais;

import DAO.AnimalDAO;
import Model.Animal;
import Telas.JFrame_Principal;
import java.text.SimpleDateFormat;

/**
 *
 * @author Shelmo
 */
public class JFrame_RemoverAnimais extends JFrame_Animal
{
    private Animal animal = new Animal();
    private int select;
    
    public JFrame_RemoverAnimais(Animal animal, int select)
    {
        super();
        this.animal = animal;
        this.select = select;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String format = sdf.format(this.animal.getDataNasc());
        
        getjLabel_Titulo().setText("Remover Animal");
        getjButton_Confirmar().setText("Remover");
        getjLabel_Aviso().setText("Deseja realmente remover esse animal?");
        
        getjTextField_Nome().setText(animal.getNome());
        getjTextField_Nome().setEnabled(false);
        getjFormattedTextField_Numero().setText(animal.getNumero());
        getjFormattedTextField_Numero().setEnabled(false);
        getjTextField_Raca().setText(animal.getRaca());
        getjTextField_Raca().setEnabled(false);
        getjFormattedTextField_Data_Nasc().setText(format);
        getjFormattedTextField_Data_Nasc().setEnabled(false);
        
        
        if(this.animal.getSexo().equals("M"))
            getjCheckBox_Macho().setSelected(true);
        if(this.animal.getSexo().equals("F"))
            getjCheckBox_Femea().setSelected(true);
        getjCheckBox_Femea().setEnabled(false);
        getjCheckBox_Macho().setEnabled(false);
        
        if(this.animal.getSituacao().equals("A"))
            getjCheckBox_Ativo().setSelected(true);
        if(this.animal.getSituacao().equals("M"))
            getjCheckBox_Morte().setSelected(true);
        if(this.animal.getSituacao().equals("V"))
            getjCheckBox_Venda().setSelected(true);
        
        getjCheckBox_Ativo().setEnabled(false);
        getjCheckBox_Morte().setEnabled(false);
        getjCheckBox_Venda().setEnabled(false);
    }
    
    public void Confirmar()
    {
        AnimalDAO.removerAnimal(animal);
        JFrame_Principal.removerAnimalList(select);
        dispose();
    }
}
