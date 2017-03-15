package pasaxeirosvoosoracleneodatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
/**
 *
 * @author oracle
 */
public class PasaxeirosVoosOracleNeodatis {
    
    ODB odb = null;
    static final String ODB_NAME = "internacional";
    
    String user = "hr";
    String password = "hr";
    String driver = "jdbc:oracle:thin:";
    String host = "localhost.localdomain"; //String host = "1982.168.1.14";
    String porto = "1521";
    String sid = "orcl"; 
    String url = driver + user + "/" + password + "@" + host + ":" +porto + ":" + sid;
    public static Connection conn;

    /**
     * Conexion a BD
     * @return Retorna a conexion
     */
    public Connection conexionBD() {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {}
        if(conn!=null){
            System.out.println("Abierta la conexión a la BD");
        }else{
            System.out.println("Conexion fallida");
        }
        return conn;
    }
    
    public void closeConexion() throws SQLException {
        conn.close();
    }
    
    /**
     * Cambia atributo confirmado a valor 1
     */
    public void cambiarConfirmado(){
       
    }
    /**
     * Ler e amosar todos os obxetos de tipo Reserva
     */
    public void lerReservas(){
        odb = ODBFactory.open(ODB_NAME);
        org.neodatis.odb.Objects<Reserva> reserva = odb.getObjects(Reserva.class);
        
        int i = 1;
        while (reserva.hasNext()){
            Reserva res = reserva.next();
            res.setConfirmado(1);
            odb.store(res);
            String dni= res.getDni();
            String aumentar = "UPDATE pasaxeiros SET nreservas=nreservas+1 WHERE dni=" + "'" + dni + "'";
            
            System.out.println("Reserva " + i++ + ":" + "\n"
                               + "CODR: " + res.getCodr()  
                               + ", DNI: " + res.getDni() 
                               + ", IDVOOIDA: " + res.getIdvooida() 
                               + ", IDVOOVOLTA: " + res.getIdvoovolta()
                               + ", PREZORESERVA: " + res.getPrezoreserva()
                               + ", CONFIRMADO: " + res.getConfirmado() + "\n");
        }
        odb.close();
    }

    
    
    public static void main(String[] args) throws SQLException {
        PasaxeirosVoosOracleNeodatis ejecuta = new PasaxeirosVoosOracleNeodatis();
        ejecuta.conexionBD();
        ejecuta.lerReservas();
        ejecuta.closeConexion();
    }
    
}
