package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ActivityDTO;
import facades.ActivityFacade;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("activity")
public class ActivityResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final ActivityFacade FACADE =  ActivityFacade.getFacadeActivity(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{cityname}")
    public Response getAcivityByCity(@PathParam("cityname")String cityname) throws Exception {

        List<ActivityDTO> activityDTOList = FACADE.getAllActivitiesByCityName(cityname);
        System.out.println(activityDTOList);
        if(activityDTOList.size()!=0) {
            return Response.ok().entity(activityDTOList).build();
        }else {
            return Response.status(204).build();
        }
    }

}
