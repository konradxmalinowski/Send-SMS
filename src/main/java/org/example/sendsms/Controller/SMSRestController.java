package org.example.sendsms.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.sendsms.Model.SMSSendRequest;
import org.example.sendsms.Service.SMSService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SMSRestController {
    private final SMSService smsService;

    public SMSRestController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/processSMS")
    public String processSMS(@RequestBody SMSSendRequest sendRequest) {
        log.info("processSMS Started sendRequest: {}", sendRequest.toString());
        return smsService.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getMessage());
    }
}
