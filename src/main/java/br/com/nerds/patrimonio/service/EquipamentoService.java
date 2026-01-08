package br.com.nerds.patrimonio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.nerds.patrimonio.exception.EquipamentoNaoEncontradoException;
import br.com.nerds.patrimonio.exception.NumeroSerieDuplicadoException;
import br.com.nerds.patrimonio.model.Equipamento;
import br.com.nerds.patrimonio.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public List<Equipamento> listarTodos() {
        return repository.findAll();
    }

    public Equipamento cadastrar(Equipamento equipamento) {
        repository.findByNumeroSerie(equipamento.getNumeroSerie())
                .ifPresent(e -> {
                    throw new NumeroSerieDuplicadoException(equipamento.getNumeroSerie());
                });

        return repository.save(equipamento);
    }

    public Equipamento atualizarPorNumeroSerie(String numeroSerie, Equipamento novo) {

    Equipamento existente = repository.findByNumeroSerie(numeroSerie)
            .orElseThrow(() ->
                new EquipamentoNaoEncontradoException(
                    "Número de série " + numeroSerie + " não encontrado"
                )
            );

    existente.setNome(novo.getNome());
    existente.setTipo(novo.getTipo());

    return repository.save(existente);
    }

    public void excluirPorNumeroSerie(String numeroSerie){

    Equipamento equipamento = repository.findByNumeroSerie(numeroSerie)
        .orElseThrow(() ->
            new EquipamentoNaoEncontradoException(
                "Número de série " + numeroSerie + " não encontrado"
            )
        );

    repository.delete(equipamento);
    }

    public Equipamento buscarPorNumeroSerie(String numeroSerie) {
    return repository.findByNumeroSerie(numeroSerie)
            .orElseThrow(() ->
                new EquipamentoNaoEncontradoException(
                    "Número de série " + numeroSerie + " não encontrado"
                )
            );
    }


}
