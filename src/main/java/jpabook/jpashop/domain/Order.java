package jpabook.jpashop.domain;

import org.hibernate.annotations.common.util.impl.Log;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS") // DB 테이블 명 직접 설정
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ORDER_ID") //
    private Long id;

//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING) // enum타입 관계 어노테이션, Strig 으로 해야 순서 트러블 없음
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID") // Order가 연관관계의 주인
    private Delivery delivery;

    /*연관관계 편의 메소드*/
    public void addOrderItem(OrderItem orderItem){
        this.getOrderItems().add(orderItem); // Order.orders에 orderItem 넣어주고
        orderItem.setOrder(this); // OrderItem.order에 Order 저장.
    }
    /*
        getter setter 단축키: alt+ins 변수 선택
        * */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
