package br.com.carvalhoatelie.mvc.controle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carvalhoatelie.mvc.controle.model.Produto;
import br.com.carvalhoatelie.mvc.controle.model.StatusProduto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByStatus(StatusProduto status);


}
