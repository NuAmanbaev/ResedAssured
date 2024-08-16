package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)



public class CustomResponse {
    //creating tag
    private String id;
    private String name_tag;
    private String creation_date;




}
