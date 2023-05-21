import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class PersonaTable extends ORMTable {
    static final String USER = "a22oscmungar_userProg";
    static final String PWD = "Oscar1234";
    static final String URL = "labs.inspedralbes.cat";
    static final String PORT = "3306";
    static final String BD_NAME = "a22oscmungar_prog";
    static ArrayList<PersonaEntity> lista;
    // <editor-fold defaultstate="collapsed" desc="Propietats de l'objecte">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public PersonaTable() {
        super("PERSONA");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters i Setters">
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Operacions amb la Base de Dades">
    /**
     * Inserta l'objecte a la taula de Persones
     *
     * @return int: nombre de files afectades
     * @throws NullConnectionException: La connexió és nul·la o es troba tancada
     * @throws SQLException: Qualsevol altra excepció SQL
     */
    @Override
    public int Insert(ORMEntity o) throws NullConnectionException, SQLException {
        if (getBDConnection() == null) {
            throw new NullConnectionException();
        }

        if (getBDConnection().getConnection() == null) {
            throw new NullConnectionException();
        }

        try {
            if (getBDConnection().getConnection().isClosed()) {
                throw new NullConnectionException();
            }
        } catch (SQLException e) {
            throw new NullConnectionException();
        }
        PersonaEntity p = (PersonaEntity) o;
        String sqlCommand = "INSERT INTO PERSONA"
                + " VALUES (" + p.getidPersona() + ",'" + p.getNom() + "','" + p.getDataNaix() + "')";

        Statement st = getBDConnection().getConnection().createStatement();
        int numFilesAfectades = st.executeUpdate(sqlCommand);
        st.close();

        //Confirma els canvis
        getBDConnection().getConnection().commit();

        return numFilesAfectades;
    }

    /**
     * Obté tots els registres de la taula
     * @return Retorna una llista amb tots els registres de la taula
     * @throws NullConnectionException
     * @throws SQLException 
     */
    @Override
    public ArrayList<PersonaEntity> GetAll() throws NullConnectionException, SQLException {

        ArrayList<PersonaEntity> resultList = new ArrayList<PersonaEntity>();

        Statement consulta = getBDConnection().getConnection().createStatement();
        ResultSet resultat = consulta.executeQuery("SELECT * FROM PERSONA");

        while (resultat.next()) {
            PersonaEntity p = new PersonaEntity(
                    resultat.getString("codPersona"), 
                    resultat.getString("Nom"),                     
                    resultat.getDate("dataNaix"));
            resultList.add(p);
        }

        //Tancar resultat i consulta
        resultat.close();
        consulta.close();

        return resultList;
    }
    // </editor-fold>

    @Override
    public ArrayList<?> GetAllFrom(int cod) throws NullConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update(int cod, String nom, String data) throws NullConnectionException, SQLException {
        try {
            if (getBDConnection() == null) {
                throw new NullConnectionException();
            }
            
            if (getBDConnection().getConnection() == null) {
                throw new NullConnectionException();
            }
            
            try {
                if (getBDConnection().getConnection().isClosed()) {
                    throw new NullConnectionException();
                }
            } catch (SQLException e) {
                throw new NullConnectionException();
            }
            BDConnection bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            PersonaTable pt = new PersonaTable();
            pt.setConnection(bdCon);
            lista = pt.GetAll();
            PersonaEntity p = lista.get(cod+1);
            int cod2 = cod +2;
            String sqlCommand = "UPDATE PERSONA SET nom = '"+nom+"', dataNaix = '"+data+"' where codPersona = "+cod2+";";
            
                   
            
            Statement st = getBDConnection().getConnection().createStatement();
            int numFilesAfectades = st.executeUpdate(sqlCommand);
            st.close();
            
            //Confirma els canvis
            getBDConnection().getConnection().commit();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonaTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

