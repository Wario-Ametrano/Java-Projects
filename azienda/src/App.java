import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class App {
	public int = 5
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream(
            "/home/wario/Pubblici/CorsoJava/JavaProjects/azienda/src/config.Properties"));

        String url = p.getProperty("jdbcUrl");    
        String username = p.getProperty("jdbcUsername");
        String password =p.getProperty("jdbcPassword");

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            Statement cmd = con.createStatement();

            ResultSet res = cmd.executeQuery("SELECT * FROM animale");
            System.out.println("Connessione riuscita");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
