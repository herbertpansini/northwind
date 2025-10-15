package br.com.northwind.repository;

import br.com.northwind.model.OrderDetail;

import br.com.northwind.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

    // Buscar todos os detalhes de um pedido específico
    List<OrderDetail> findByPkOrderId(long orderId);

    // Buscar todos os detalhes relacionados a um produto específico
    List<OrderDetail> findByPkProductId(long productId);

    // Buscar um detalhe específico por pedido e produto
    Optional<OrderDetail> findByPkOrderIdAndPkProductId(long orderId, long productId);
}