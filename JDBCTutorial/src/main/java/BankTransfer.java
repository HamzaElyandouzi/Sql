import java.sql.*;
import java.sql.PreparedStatement;

public class BankTransfer {
    private static final String QUERY = "SELECT * FROM beers where Stock = 50";
    private static final String UPDATE = "UPDATE beers SET Price = ? where Stock = ?";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db")) {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            try (PreparedStatement qstmt = con.prepareStatement(QUERY);PreparedStatement ustmt = con.prepareStatement(UPDATE)){
                setAmount(ustmt, 1,1000);
                setAmount(ustmt, 2,0);

                double amount1 = 0;
                double amount2 = 0;

                while((amount1 = getAmount(qstmt,1))>0){
                    amount2 = getAmount(qstmt,2);
                    setAmount(ustmt,1, amount1 -= 1);
                    setAmount(ustmt,1, amount2 += 1);
                    con.commit();
                }

            }catch (Exception ex){
                System.out.println(ex.getMessage());
                con.rollback();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void setAmount(PreparedStatement ustmt, int number, double amount) throws SQLException {
        ustmt.setInt(2,number);
        ustmt.setDouble(1,amount);
        ustmt.executeUpdate();
    }

    public static double getAmount(PreparedStatement qstmt, int number) throws SQLException {

        double amount = 0;
        qstmt.setInt(1,number);
        try(ResultSet res = qstmt.executeQuery()){
            if(res.next()){
                amount = res.getDouble("amount");
            }

        }
        return amount;
    }
}

