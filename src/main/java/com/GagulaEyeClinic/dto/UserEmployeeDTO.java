package com.GagulaEyeClinic.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UserEmployeeDTO {
    private String empId;
    private String name;
    private String address;
    private String jobRole;
    private String contactNum;

}
