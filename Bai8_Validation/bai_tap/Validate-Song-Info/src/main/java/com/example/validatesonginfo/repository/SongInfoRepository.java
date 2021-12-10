package com.example.validatesonginfo.repository;

import com.example.validatesonginfo.model.SongInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongInfoRepository extends JpaRepository<SongInfo, Integer> {
}
