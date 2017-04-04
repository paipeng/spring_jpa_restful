package com.paipeng.spring_jpa_restful.dao.repository;

import com.paipeng.spring_jpa_restful.dao.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paipeng on 27/03/2017.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findOne(long id);

}