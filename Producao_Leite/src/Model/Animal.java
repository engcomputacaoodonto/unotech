package Model;

import java.sql.Date;
/**
 *
 * @author Shelmo
 */
public class Animal
{
    private int id;
    private String nome;
    private String numero;
    private String raca;
    private Date dataNasc;
    private char sexo;
    private char situacao;

    public Animal(){}
    
    public Animal(int id, String nome, String numero, String raca, Date dataNasc, char sexo, char situacao)
    {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.raca = raca;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.situacao = situacao;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getRaca()
    {
        return raca;
    }

    public void setRaca(String raca)
    {
        this.raca = raca;
    }

    public Date getDataNasc()
    {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc)
    {
        this.dataNasc = dataNasc;
    }

    public char getSexo()
    {
        return sexo;
    }

    public void setSexo(char sexo)
    {
        this.sexo = sexo;
    }

    public char getSituacao()
    {
        return situacao;
    }

    public void setSituacao(char situacao)
    {
        this.situacao = situacao;
    }   
}
