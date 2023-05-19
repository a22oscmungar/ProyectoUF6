/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public class MascotaEntity extends ORMEntity{
    
    private String codMasc;
    private String nomMasc;
    private int codAmo;

    public MascotaEntity(String codMasc, String nomMasc, int codAmo) {
        this.codMasc = codMasc;
        this.nomMasc = nomMasc;
        this.codAmo = codAmo;
    }

    public String getCodMasc() {
        return codMasc;
    }

    public void setCodMasc(String codMasc) {
        this.codMasc = codMasc;
    }

    public String getNomMasc() {
        return nomMasc;
    }

    public void setNomMasc(String nomMasc) {
        this.nomMasc = nomMasc;
    }

    public int getCodAmo() {
        return codAmo;
    }

    public void setCodAmo(int codAmo) {
        this.codAmo = codAmo;
    }
    
    
    
}
