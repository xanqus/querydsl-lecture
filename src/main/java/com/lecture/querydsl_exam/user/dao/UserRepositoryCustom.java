package com.lecture.querydsl_exam.user.dao;

import com.lecture.querydsl_exam.user.domain.SiteUser;

import java.util.List;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);

    long getQslUserCount();

    List<SiteUser> getQslUsersOrderByAsc();
}
