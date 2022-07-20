package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity{

    @Column(name="DELIVERY_ID")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
