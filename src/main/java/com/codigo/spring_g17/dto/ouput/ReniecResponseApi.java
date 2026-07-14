package com.codigo.spring_g17.dto.ouput;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReniecResponseApi {
    private String firstName;
    private String firstLastName;
    private String secondLastName;
    private String fullName;
    private String documentNumber;
}
