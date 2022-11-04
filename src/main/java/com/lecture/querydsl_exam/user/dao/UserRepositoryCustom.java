package com.lecture.querydsl_exam.user.dao;

import com.lecture.querydsl_exam.user.domain.SiteUser;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);

    long getQslUserCount();
}
