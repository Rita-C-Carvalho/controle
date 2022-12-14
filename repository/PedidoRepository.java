package br.com.carvalhoatelie.mvc.controle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carvalhoatelie.mvc.controle.model.Pedido;
import br.com.carvalhoatelie.mvc.controle.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido status);


}
