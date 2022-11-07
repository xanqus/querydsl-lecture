package com.lecture.querydsl_exam.interestKeyword.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterestKeyword {

    @Id
    private String content;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof InterestKeyword)) return false;
        InterestKeyword interestKeyword = (InterestKeyword) o;
        return content.equals(interestKeyword.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

}
