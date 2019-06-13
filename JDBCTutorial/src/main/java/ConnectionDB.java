import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db","root","");
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){


            ResultSet set = stm.executeQuery("select * from beers");

            /*
            set.moveToInsertRow();
            set.updateString("name", "great beer");
            set.updateDouble("price", 3.5);
            set.updateInt("alcohol", 7);
            set.insertRow();
            set.moveToCurrentRow();

            while(set.next()){
               String name = set.getString("name");
               if(name.equals("great beer")){
                   set.deleteRow();
               }
           }
           */

            set.last();
            set.previous();
            set.deleteRow();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
