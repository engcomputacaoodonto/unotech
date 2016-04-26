package Model;

import java.sql.Date;

/**
 *
 * @author Shelmo
 */
public class ColetaLeite
{
    private int idColetaLeite;
    private int idEmpresa;
    private Date dataColeta;
    private int qtdLitros;
    private String qualidade;

    public int getIdColetaLeite()
    {
        return idColetaLeite;
    }

    public void setIdColetaLeite(int idColetaLeite)
    {
        this.idColetaLeite = idColetaLeite;
    }

    public int getIdEmpresa()
    {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa)
    {
        this.idEmpresa = idEmpresa;
    }

    public Date getDataColeta()
    {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta)
    {
        this.dataColeta = dataColeta;
    }

    public int getQtdLitros()
    {
        return qtdLitros;
    }

    public void setQtdLitros(int qtdLitros)
    {
        this.qtdLitros = qtdLitros;
    }

    public String getQualidade()
    {
        return qualidade;
    }

    public void setQualidade(String qualidade)
    {
        this.qualidade = qualidade;
    }
}
