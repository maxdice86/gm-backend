package com.giantmachine.interviewbackend.repository;

import com.giantmachine.interviewbackend.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    @Transactional
    @Modifying
    @Query("delete from Revenue r where r.project IN ?1")
    void deleteByProjects(List<String> projects);

    List<Revenue> findByClientsIgnoreCase(String clients);

}