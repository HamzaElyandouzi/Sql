import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertIntoBeers {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db", "root", "");
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            String sql = "INSERT INTO beers(Name, BrewerId, CategoryId, Price, Stock)" +
                    " values ('Hapkin',6,22,250,10)";
            int insert = stm.executeUpdate(sql);
            System.out.println(insert);


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
