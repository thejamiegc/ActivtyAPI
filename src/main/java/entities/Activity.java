package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "activity")
@NamedQuery(name = "Activity.deleteAllRows", query = "DELETE from Activity")
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String activityName;
    private String activityDescription;
    private boolean isOutDoors;
    private String cityName;

    public Activity() {
    }

    public Activity(String activityName, String activityDescription, boolean isOutDoors, String cityName) {
        this.activityName = activityName;
        this.activityDescription = activityDescription;
        this.isOutDoors = isOutDoors;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
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

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                ", isOutDoors=" + isOutDoors +
                '}';
    }
}