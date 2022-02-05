import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Connessione {

	public Prodotto ricercaProdotto(String nome){
		
		Prodotto p = new Prodotto();
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scatola_Prodotti?serverTimezone=UTC","root","area51");
            Statement cmd = con.createStatement();
            ResultSet res= cmd.executeQuery("SELECT * FROM proddotto WHERE prodotto.nome ='" + nome + "'")){
                while(res.next()){
                   p.setNome(res.getString("nome"));
                   p.setCodice(res.getString("codice"));
                }             
            }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        return p;
	}
	public void inserisciProdotto(int idProdotto,String nome,String codice) {
		String q="INSERT INTO 'Prodotto'('idProdotto','nome','codice')VALUES(?,?,?)";
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scatola_Prodotti?serverTimezone=UTC","root","area51");
        		
        	     Statement cmd = con.createStatement();		 
        		 PreparedStatement stmt = con.prepareStatement(q)){
        			
        			stmt.setInt(1,idProdotto);
        			stmt.setString(2,nome);
        			stmt.setString(3,codice);
        			stmt.executeQuery();  
   
        }catch(SQLException e){
                e.printStackTrace();
        }     
	}
        
	public void cancellaProdotto(String nome) {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scatola_Prodotti?serverTimezone=UTC","root","area51");
        		 PreparedStatement stmt = con.prepareStatement("DELETE Prodotto *FROM 'Prodotto' WHERE nome ='"  +  nome + "'" )){
       		 	 stmt.executeUpdate();

	     }catch(SQLException e){
			e.printStackTrace();
	     }
    }
}
