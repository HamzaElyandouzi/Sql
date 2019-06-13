package BE.intecbrusselTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JBCTutorialTest {

    @BeforeAll
    public static void connect(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db", "root", "");
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void name() {
    }

    @AfterAll
    public static void disconnect(){
       // con.close();
    }
}
