package dta.churchsystem.repository;

import dta.churchsystem.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ElectionRepository extends JpaRepository<Election, Integer> {
@Query("SELECT e FROM Election e WHERE e.name= (:name)")
public Election findByName(@Param("name") String name);
        }
