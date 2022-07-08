package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// 기본키 전약 자동으로 선택
    @Column(name = "MEMBER_ID") // DB컬럼명 지정
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
