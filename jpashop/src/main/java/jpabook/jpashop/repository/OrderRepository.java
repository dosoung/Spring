package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);;
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    /**
     * JPA Criteria
     */
//    public List<Order> findAll(OrderSearch orderSearch) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
//        Root<Order> o = cq.from(Order.class);
//
//    };
}
