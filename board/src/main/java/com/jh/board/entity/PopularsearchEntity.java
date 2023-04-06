package com.jh.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Popularsearch")
@Table(name = "Popularsearch")
public class PopularsearchEntity {
    @Id
    private String popularTerm;
    private int popularSearchCount;

}
