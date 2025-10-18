package com.steverado9.Teamwork.repository;

import com.steverado9.Teamwork.entity.Gif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GifRepository extends JpaRepository<Gif, Long> {
    List<Gif> findAllByOrderByCreatedAtDesc();
}
