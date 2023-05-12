package dtos;

import java.util.List;

public class ApiDTO {
    private List<ActivityDTO> activityDTOList;

    public ApiDTO(List<ActivityDTO> activityDTOList) {
        this.activityDTOList = activityDTOList;
    }

    public List<ActivityDTO> getActivityDTOList() {
        return activityDTOList;
    }

    public void setActivityDTOList(List<ActivityDTO> activityDTOList) {
        this.activityDTOList = activityDTOList;
    }

    @Override
    public String toString() {
        return "ApiDTO{" +
                "activityDTOList=" + activityDTOList +
                '}';
    }
}
