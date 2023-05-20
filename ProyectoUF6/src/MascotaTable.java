
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oscar
 */
public class MascotaTable extends ORMTable{
    
    private int cod;
    

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    
    public MascotaTable() {
        super("MASCOTA");
    }

    @Override
    public int Insert(ORMEntity o) throws NullConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public ArrayList<MascotaEntity> GetAll() throws NullConnectionException, SQLException {

        ArrayList<MascotaEntity> resultList = new ArrayList<MascotaEntity>();

        Statement consulta = getBDConnection().getConnection().createStatement();
        
        ResultSet resultat = consulta.executeQuery("SELECT * FROM MASCOTA");

        while (resultat.next()) {
            MascotaEntity m = new MascotaEntity(
                    resultat.getString("codMasc"), 
                    resultat.getString("Animal"),                     
                    resultat.getInt("codPersona"));
            resultList.add(m);
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return resultList;
    }
    
    @Override
    public ArrayList<MascotaEntity> GetAllFrom(int codPers) throws NullConnectionException, SQLException {

        ArrayList<MascotaEntity> resultList = new ArrayList<MascotaEntity>();

        Statement consulta = getBDConnection().getConnection().createStatement();
        
        ResultSet resultat = consulta.executeQuery("SELECT * FROM MASCOTA where codPersona = "+(codPers+1));

        while (resultat.next()) {
            MascotaEntity m = new MascotaEntity(
                    resultat.getString("codMasc"), 
                    resultat.getString("Animal"),                     
                    resultat.getInt("codPersona"));
            resultList.add(m);
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return resultList;
    }

    @Override
    public void Update(int cod, String nom, Date data) throws NullConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
