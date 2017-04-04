package com.paipeng.spring_jpa_restful.dao.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by paipeng on 27/03/2017.
 */
@Component
@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {
    @Column(name = "name", length = 64, unique = true, nullable = false)
    private String name;

    @Column(name = "description", length = 64)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
