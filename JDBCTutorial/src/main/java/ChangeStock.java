import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChangeStock {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db", "root", "")) {

            try(Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
                con.setAutoCommit(false);
                stm.executeUpdate("UPDATE BEERS SET STOCK = 50 WHERE NAME LIKE 'hapkin'");
                stm.executeUpdate("UPDATE beers SET Alcohol = 20 WHERE Name = 'Zulte'");
                con.commit();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                con.rollback();
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
