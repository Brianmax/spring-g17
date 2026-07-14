package com.codigo.spring_g17.dto.ouput;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReniecResponseApi {
    @JsonProperty(namespace = "first_name")
    private String firstName;
    @JsonProperty(namespace = "first_last_name")
    private String firstLastName;
    @JsonProperty(namespace = "second_last_name")
    private String secondLastName;
    @JsonProperty(namespace = "full_name")
    private String fullName;
    @JsonProperty(namespace = "document_number")
    private String documentNumber;
}
