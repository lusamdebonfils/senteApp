package edu.mum.cs.cs425.finalproject.senteapp.repository;

import edu.mum.cs.cs425.finalproject.senteapp.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingRepository extends JpaRepository<Saving, Long> {
}
