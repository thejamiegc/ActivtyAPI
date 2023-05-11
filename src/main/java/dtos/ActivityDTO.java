package dtos;

import entities.Activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActivityDTO implements Serializable {
    private Long id;
    private String activityName;
    private String activityDescription;
    private boolean isOutDoors;
    private String cityName;


    public ActivityDTO() {
    }

    public ActivityDTO(String activityName, String activityDescription, boolean isOutDoors, String cityName) {
        this.activityName = activityName;
        this.activityDescription = activityDescription;
        this.isOutDoors = isOutDoors;
        this.cityName = cityName;
    }

    public ActivityDTO(Activity activity) {
        this.id = activity.getId();
        this.activityName = activity.getActivityName();
        this.activityDescription = activity.getActivityDescription();
        this.isOutDoors = activity.isOutDoors();
        this.cityName = activity.getCityName();
    }

    public static List<ActivityDTO> getDtos(List<Activity> activitiesList) {
        List<ActivityDTO> activityDTOList = new ArrayList<>();
        activitiesList.forEach(activity -> activityDTOList.add(new ActivityDTO(activity)));
        return activityDTOList;
    }

    public Long getId() {
        return id;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public boolean getIsOutDoors() {
        return isOutDoors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public boolean isOutDoors() {
        return isOutDoors;
    }

    public void setOutDoors(boolean outDoors) {
        isOutDoors = outDoors;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                ", isOutDoors=" + isOutDoors +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
