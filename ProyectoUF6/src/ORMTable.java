
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public abstract class ORMTable{
    
    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    /* Propietats de l'objecte */
    private String tableName;
    
    /* Connexió a la Base de dades */
    private BDConnection c;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public ORMTable(String nomTabla) {
        tableName = nomTabla;
    }
    //</editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    /** 
     * Getters i Setters 
     */
    public String getTableName() {
        return tableName;
    }

    public void setConnection(BDConnection c) {
        this.c = c;
    }
    
    public BDConnection getBDConnection() {
        return this.c;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Operacions amb la Base de Dades">
    
    public abstract int Insert(ORMEntity o) throws NullConnectionException, SQLException;
    public abstract ArrayList<?> GetAll() throws NullConnectionException, SQLException;
    public abstract ArrayList<?> GetAllFrom(int cod) throws NullConnectionException, SQLException;
    // </editor-fold>
    
}
