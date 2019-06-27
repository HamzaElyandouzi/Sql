package be.intecbrussel;

import be.intecbrussel.Entitys.Adress;
import be.intecbrussel.Entitys.Gender;
import be.intecbrussel.Entitys.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SavePerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();
        Person Amy =  new Person();
        Amy.setBirthday(LocalDate.of(2000,1,1));
        Amy.setFirstNAme("Not Jezus");
        Amy.setLastNAme("from Nazarick");
        Amy.setGender(Gender.FEMALE);
        Amy.setMarried(true);
        Amy.setComment("SuperStar from the Sky");
        Amy.setHomepage("https://nl.wikipedia.org/wiki/Jezus");
        Amy.setPicture(getPictureUrl("C:\\Hamzae\\download\\JezusPic\\Jezus.png"));
        Amy.setAdress(new Adress("HeartStreet",3,1000,"Brussel", "Belgiam"));


        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(Amy);
            tx.commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static byte[] getPictureUrl(String Location){
        Path p = Paths.get(Location);
        byte[] bytes = new byte[0];
        try{
            bytes = Files.readAllBytes(p);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return bytes;

//        ArrayList<Byte> byteArrayList = new ArrayList<>();
//        byte[] picture = null;
//        try(FileInputStream fileInputStream = new FileInputStream(Location)){
//            int nextByte = 0;
//            while((nextByte = fileInputStream.read())!=-1){
//                byteArrayList.add((byte) nextByte);
//            }
//            picture = new byte[byteArrayList.size()];
//            for (int i = 0; i<byteArrayList.stream().toArray().length;i++){
//                picture[i]=byteArrayList.get(i);
//            }
//
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return picture;

    }

}
