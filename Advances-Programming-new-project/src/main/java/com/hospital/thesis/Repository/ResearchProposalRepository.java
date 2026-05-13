package com.hospital.thesis.Repository;

import com.hospital.thesis.entity.ResearchProposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearchProposalRepository extends JpaRepository<ResearchProposal, Integer> {
}