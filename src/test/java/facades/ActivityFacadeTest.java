package facades;

import dtos.ActivityDTO;
import entities.Activity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityFacadeTest {

    private static EntityManagerFactory emf;
    private static ActivityFacade facade;

    public ActivityFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = ActivityFacade.getFacadeActivity(emf);
    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Activity("walking in park","you walk in a park",true,"copenhagen"));
            em.persist(new Activity("Watch a movie","go to the cinema and watch a movie",false,"copenhagen"));
            em.persist(new Activity("walking in park","you walk in a park",true,"lyngby"));


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllActivitiesByCityName() {
        System.out.println("getting all activities by city");
        List<ActivityDTO> activityDTOList = facade.getAllActivitiesByCityName("copenhagen");
        System.out.println(activityDTOList);
        /*assertEquals(2,activityDTOList.size());*/
        assertEquals("copenhagen",activityDTOList.get(0).getCityName());
    }
}