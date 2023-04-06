package com.jh.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.board.entity.PopularsearchEntity;

@Repository
public interface PopularsearchRepository extends JpaRepository<PopularsearchEntity, String>{

}
