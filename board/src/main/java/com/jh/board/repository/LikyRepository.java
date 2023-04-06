package com.jh.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.board.entity.LikyEntity;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, Integer>{

}
