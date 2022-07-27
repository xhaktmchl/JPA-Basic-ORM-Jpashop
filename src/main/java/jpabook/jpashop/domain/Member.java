package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// 기본키 전약 자동으로 선택
    @Column(name = "MEMBER_ID") // DB컬럼명 지정
    private Long id;

    private String name;

    @Embedded
    private Address homeAddress;

    @OneToMany(mappedBy = "member") // 연관관계의 주인은 Order.member
    private List<Order> orders = new ArrayList<>();


    /*
    getter setter 단축키: alt+ins 변수 선택
    * */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
