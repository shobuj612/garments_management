package com.sunshine.sunspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.sunspring.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
