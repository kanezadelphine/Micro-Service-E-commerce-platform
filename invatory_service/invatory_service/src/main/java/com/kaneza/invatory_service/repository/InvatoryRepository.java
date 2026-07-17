package com.kaneza.invatory_service.repository;

import com.kaneza.invatory_service.entity.Invatory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvatoryRepository extends JpaRepository<Invatory, Long> {
}
