import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTutorial {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beers_db","root","");
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM BEERS where ID between 1500 and 1600");

            rs.afterLast();
            while (rs.previous()){
                System.out.println("id "+
                        rs.getInt("id")
                        + " name " + rs.getString("name")
                        + " stock "+ rs.getInt("stock")
                        + " price "+ rs.getDouble("price"));
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
