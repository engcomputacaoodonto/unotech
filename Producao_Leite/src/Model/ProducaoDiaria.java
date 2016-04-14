/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Date;
/**
 *
 * @author 285146
 */
public class ProducaoDiaria {
    private int id;
    private int idAnimal;
    private double qntLitros;
    private Date data;
    
    
    public ProducaoDiaria() {}

    public ProducaoDiaria(int id, int idAnimal, double qntLitros, Date data) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.qntLitros = qntLitros;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public double getQntLitros() {
        return qntLitros;
    }

    public void setQntLitros(double qntLitros) {
        this.qntLitros = qntLitros;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
