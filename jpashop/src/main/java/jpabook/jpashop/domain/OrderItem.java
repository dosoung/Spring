package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="item_id")
    private Item item;

    //오더에도 오더아이템즈가 있고 오더아이템에도 오더가 존재한다.
    @ManyToOne(fetch = LAZY) //하나의 오더는 여러개의 오더아이템을 가질 수 있다. 오더아이템은 한개의 오더를 가질 수 있다. 일대다 관계
    @JoinColumn(name="order_id")
    private Order order;

    private int orderPrice; //주문가격
    private int count; //주문수량

}
