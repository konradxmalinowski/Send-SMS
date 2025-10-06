package org.example.sendsms.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SMSSendRequest {
    private String message;
    private String destinationSMSNumber;
}
