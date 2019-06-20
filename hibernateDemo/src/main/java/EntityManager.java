import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

//    public static EntityManager getEmf (){
//      return emf.createEntityManager();
//    }
}
