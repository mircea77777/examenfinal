/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author student
 */
public class Student {
    private int id;
    private String Nume;
    private String Prenume;
    private int cnp;


public Student(){}

public Student( int id,  String Nume, String Prenume, int cnp){

this.id=id;
this.Nume=Nume;
this.Prenume=Prenume;
this.cnp=cnp;

}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String Nume) {
        this.Nume = Nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    
    
    
    
    
}
