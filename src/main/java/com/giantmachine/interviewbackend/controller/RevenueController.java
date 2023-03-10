package com.giantmachine.interviewbackend.controller;

import com.giantmachine.interviewbackend.model.Revenue;
import com.giantmachine.interviewbackend.model.RevenueView;
import com.giantmachine.interviewbackend.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v2/")
@RequiredArgsConstructor
public class RevenueController {

    private final RevenueService revenueService;

    @GetMapping("/records")
    public List<Revenue> getAllRecords() {
        return revenueService.getAllRecords();
    }

    @GetMapping("/records/views")
    public List<RevenueView> getViews() {
        return revenueService.getViews();
    }

    @GetMapping("/records/{client}")
    public List<RevenueView> getAllRecordsByClient(@PathVariable String client) {
        return revenueService.getViewsByClient(client);
    }

    @PostMapping("/records/create")
    public Revenue createRecord(@RequestBody Revenue record) {
        return revenueService.createRecord(record);
    }

    @DeleteMapping("records/delete")
    public void deleteRecord(@RequestBody List<String> id) {

        revenueService.deleteRecord(id);
    }

}
