package com.lecture.querydsl_exam.dao;

import com.lecture.querydsl_exam.user.dao.UserRepository;
import com.lecture.querydsl_exam.user.domain.SiteUser;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원 생성")
    void t1() {
        SiteUser u5 = SiteUser.builder()
                .username("user5")
                .password("{noop}1234")
                .email("user5@test.com")
                .build();

        SiteUser u6 = SiteUser.builder()
                .username("user6")
                .password("{noop}1234")
                .email("user6@test.com")
                .build();

        userRepository.saveAll(Arrays.asList(u5, u6));
        System.out.println(userRepository.count());
    }

    @Test
    @DisplayName("1번 회원 조회")
    void t2() {
        SiteUser su = userRepository.getQslUser(1L);

        assertThat(su.getId()).isEqualTo(1L);
        assertThat(su.getUsername()).isEqualTo("user1");
        assertThat(su.getPassword()).isEqualTo("{noop}1234");
        assertThat(su.getEmail()).isEqualTo("user1@test.com");
    }

    @Test
    @DisplayName("회원 수 조회")
    void t3() {
        long count = userRepository.getQslUserCount();
        assertThat(count)
                .isEqualTo(4);
    }

    @Test
    @DisplayName("회원 가장오래된순으로 정렬후 조회")
    void t4() {
        List<SiteUser> users = userRepository.getQslUsersOrderByAsc();
        assertThat(users.get(0).getId())
                .isEqualTo(1);
    }




}
