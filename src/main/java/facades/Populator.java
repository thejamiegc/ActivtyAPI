
package facades;

import dtos.ExampleDTO;
import entities.Activity;
import entities.EntityExample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

public class Populator {

    // Methods creates entities with a First and a Last name and pushes them to the DB
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        ActivityFacade activityFacade = ActivityFacade.getFacadeActivity(emf);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Activity("walking in park","you walk in a park",true,"copenhagen"));
        em.getTransaction().commit();

    }
    
    public static void main(String[] args) {
        populate();
    }
}
