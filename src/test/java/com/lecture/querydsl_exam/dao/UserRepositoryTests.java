package com.lecture.querydsl_exam.dao;

import com.lecture.querydsl_exam.user.dao.UserRepository;
import com.lecture.querydsl_exam.user.domain.SiteUser;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

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
        SiteUser u3 = SiteUser.builder()
                .username("user3")
                .password("{noop}1234")
                .email("user3@test.com")
                .build();

        SiteUser u4 = SiteUser.builder()
                .username("user4")
                .password("{noop}1234")
                .email("user4@test.com")
                .build();

        userRepository.saveAll(Arrays.asList(u3, u4));
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


}
