import java.sql.*;


public class PreparedStatement {
    public static void main(String[] args) {

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db","root","");
            java.sql.PreparedStatement stmt = con.prepareStatement("update beers set price = ? where Name=?")){
            stmt.setDouble(1,2.5);
            stmt.setString(2, "Zulte");
            stmt.executeUpdate();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
