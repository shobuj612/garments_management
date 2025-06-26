package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunshine.sunspring.model.Sewing;

public interface SewingRepository extends JpaRepository<Sewing, Long> {
@Query(value="SELECT * FROM sewing ORDER BY sewing_id DESC LIMIT 1",nativeQuery=true)
Sewing findLastSewing();
}
