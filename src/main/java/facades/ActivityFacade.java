package facades;

import dtos.ActivityDTO;
import entities.Activity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ActivityFacade {
    private static ActivityFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private ActivityFacade() {}

    // Method returns an instance of the FacadeExample class
    public static ActivityFacade getFacadeActivity(EntityManagerFactory entityManagerFactory) {
        if (instance == null) {
            emf = entityManagerFactory;
            instance = new ActivityFacade();
        }
        return instance;
    }

    // Method returns EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<ActivityDTO> getAllActivitiesByCityName(String searchedCity){
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Activity> query = entityManager.createQuery("SELECT r FROM Activity r where r.cityName = :cityName", Activity.class);
        query.setParameter("cityName",searchedCity.toLowerCase());
        List<Activity> entityExampleList = query.getResultList();
        return ActivityDTO.getDtos(entityExampleList);
    }

}
