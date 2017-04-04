package com.paipeng.spring_jpa_restful.dao.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by paipeng on 27/03/2017.
 */
@Entity
@Component
@Table(name = "student")
public class Student extends BaseEntity {
    @Column(name = "name")
    private String name;
}
