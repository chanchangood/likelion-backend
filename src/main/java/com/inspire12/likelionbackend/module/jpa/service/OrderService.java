package com.inspire12.likelionbackend.module.jpa.service;

import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import com.inspire12.likelionbackend.module.jpa.model.mapper.OrderMapper;
import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;
import com.inspire12.likelionbackend.module.jpa.repository.OrderJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderJpaRepository orderJpaRepository;


    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long orderId) {
        OrderEntity order = orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
//        OrderEntity order = orderJpaRepository.findById(orderId)
//            .orElse(new OrderEntity());// 이렇게 값을 찾지 못하면 그냥 텅빈 엔티티를 생성해서 리턴해버려도 됨.
        return OrderMapper.fromEntity(order);
    }

    @Transactional
    public OrderResponse saveOrder(OrderRequest request) {
        OrderEntity order = OrderMapper.toEntity(request);
        OrderEntity savedOrder = orderJpaRepository.save(order);
        return OrderMapper.fromEntity(savedOrder);
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        OrderEntity order = orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));//체이닝 방식
        orderJpaRepository.delete(order);
    }

    @Transactional
    public OrderResponse updateTotalAmount(Long orderId, Integer newAmount) {
        OrderEntity order = orderJpaRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        order.changeTotalAmount(newAmount);
        // .save()를 하지 않았지만 @Transactional이 붙어있기 때문에 PersistenceContext에 엔티티가 저장되고 변경사항이 db에 적용된다.
        return OrderMapper.fromEntity(order);
    }
}
