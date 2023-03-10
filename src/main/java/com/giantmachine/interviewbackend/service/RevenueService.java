package com.giantmachine.interviewbackend.service;

import com.giantmachine.interviewbackend.model.Revenue;
import com.giantmachine.interviewbackend.model.RevenueView;
import com.giantmachine.interviewbackend.repository.RevenueRepository;
import com.giantmachine.interviewbackend.repository.RevenueViewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevenueService {
    private final RevenueRepository revenueRepository;
    private final RevenueViewRepo revenueViewRepo;

    public List<Revenue> getAllRecords() {
        return revenueRepository.findAll();
    }

    public List<RevenueView> getViews() {
        return revenueViewRepo.findAll();
    }

    public List<Revenue> getAllRecordsByClient(String client) {
        return revenueRepository.findByClientsIgnoreCase(client);
    }

    public List<RevenueView> getViewsByClient(String client) {
        return revenueViewRepo.findByClientsIgnoreCase(client);
    }

    public Revenue createRecord(Revenue record) {
        return revenueRepository.save(record);
    }

    public void deleteRecord(List<String> p) {
        revenueRepository.deleteByProjects(p);
    }

}
