package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;


    //이늄은 상수의 집합체다 클래스로 구현할 이유가 없으면 이늄으로 하면된다.
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY, COMP


}
