package com.eventbriteconsulting.eventbriteconsulting.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;

@FeignClient("service-log")
public interface ILogService {

    @PostMapping("/logTransaction")
    public void notifyLogTransactions(@RequestParam("message") String message,
                                      @RequestParam("status") String status,
                                      @RequestParam("service") String service);

    @PostMapping("/logException")
    public void notifyLogErrors(@RequestParam("message") String message,
                                @RequestParam("service") String service);
}
