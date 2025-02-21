package org.example.homeservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteInfo {
    private  String compteName;
    private  String email;
    private  String token;

}
