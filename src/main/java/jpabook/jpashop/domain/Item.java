package jpabook.jpashop.domain;

import org.hibernate.annotations.common.util.impl.Log;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 싱글 테이블 상속전력
@DiscriminatorColumn(name = "DTYPE") // 각 상속받는 클래스를 구분하는 타입 자동생성
public abstract class Item { // 상속 하는 클래스로 abstract 적용

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID") // DB 컬럼명 설정, 스네이크 기법
    private Long id;

    private String name;
    private int price;
    private int stockQuantity; // 남은 재고

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
