package br.com.nerds.patrimonio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nerds.patrimonio.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    Optional<Equipamento> findByNumeroSerie(String numeroSerie);
}
