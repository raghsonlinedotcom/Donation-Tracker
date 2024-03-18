package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Donation;

public interface IDonationRepo extends JpaRepository<Donation,Long>{

}
