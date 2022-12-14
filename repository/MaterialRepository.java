package br.com.carvalhoatelie.mvc.controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carvalhoatelie.mvc.controle.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{


}
