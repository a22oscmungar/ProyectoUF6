
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public class PersonaEntity extends ORMEntity {
    
    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    /* Propietats de l'objecte */
    /* Camps de la taula */
    private int codPersona;
    private String nom;
    private Date dataNaix;

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public PersonaEntity(int idPersona, String nom, Date dataNaix) {
        this.codPersona = idPersona;
        this.nom = nom;
        this.dataNaix = dataNaix;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    /** 
     * Getters i Setters 
     */
    public int getidPersona() {
        return codPersona;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDataNaix() {
        return dataNaix;
    }  
    
    public void setDataNaix(Date dataNaix) {
        this.dataNaix = dataNaix;
    }

    //</editor-fold>


}
