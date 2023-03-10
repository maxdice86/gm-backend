package com.giantmachine.interviewbackend.repository;

import com.giantmachine.interviewbackend.model.RevenueView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevenueViewRepo extends JpaRepository<RevenueView, String> {

    List<RevenueView> findByClientsIgnoreCase(String client);

}
