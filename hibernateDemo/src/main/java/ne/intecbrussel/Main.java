package ne.intecbrussel;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {

        //creates the factory for Entity's using the persistence unit name found in the xml file you made
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("datasource");

        //create's the manager that will handle the Entity's that the factory will handel/create.
        EntityManager em = emf.createEntityManager();

        try {
            //the transaction manager
            EntityTransaction et = em.getTransaction();

            //will start the transaction
            et.begin();

            //create's a instance of the Entity
            Message message = new Message().setId(1).setMessage("hello doc");


            /*the following methode finds the data your looking for on the basis of the class and the id
             *which you can then print out on the console wit a System.out.println(instance reference);
             * Message message = em.find(Message.class, 1);
             *System.out.println(message);
             */

            //will push the Entity to persistence context(a collection of objects that will wait until
            //commit is called to send to the database)
            //em.persist(message);

            //this will create a copy of the Entity object placed in the methode merge and will constantly
            //merge the changed object to the copy of the Entity object until commit and close()
            //em.merge(message);

            /*this methode will remove the object from persistence context and will not do anything with it.
            Message message = em.find(Message.class,1);
            em.detach(message);
            */

            /*this methode will remove the object from persistence context and  also from the database
            Message message = em.find(Message.class,1);
            em.remove(message);
            */

            //the methode will turn back all changes int the persistent context since the last commit
            //et.rollback();

            /*this methode will return a reference to a Entity object that is often very large and will delay
            *its retrieval and will only show a reference to the object will still slowly bring it towards
            *the user.
            *Message message = em.getReference()
            */

            //refreshed de object to a earlier state like a small rollback
            //em.refresh(message);

            /*this methode will flush the persistence context with either auto
            *which hibernate will chose it self or commit where you chose your self when you want to commit //flush.
            *em.flush();//dont use this
            *em.setFlushMode();
            */

            /* will clear the persistence context en empty it.
            *em.clear();
            */

            /*this methode checks if the object is present in the persistence context and returns a boolean;
            *em.contains();
            */

            //will commit the Entity to the database
            em.persist(message);
            et.commit();

            System.out.println("Message saved");
        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }finally {
            //will close the factory connection and EntityManager
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }
    }
}
