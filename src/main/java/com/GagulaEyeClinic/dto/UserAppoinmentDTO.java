package com.GagulaEyeClinic.dto;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class UserAppoinmentDTO {
    private String appId;
    private String purpose;
    private String docId;
    private String patId;


}
