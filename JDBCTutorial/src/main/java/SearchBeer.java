import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchBeer {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db","root","");
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet result = stm.executeQuery("SELECT * FROM BEERS WHERE ALCOHOL > 7 ORDER BY ALCOHOL DESC");

            result.afterLast();
            while(result.previous()){
                int id =result.getInt("id");
                String name =result.getString("name");
                double alcohol =result.getDouble("alcohol");

                System.out.println(id+" "+ name+" "+alcohol);
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
