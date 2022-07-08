package jpabook.jpashop.domain;

import org.hibernate.annotations.common.util.impl.Log;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID") // DB 컬럼명 설정, 스네이크 기법
    private Long id;

    private String name;
    private int price;
    private int stockQuantity; // 남은 재고

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
