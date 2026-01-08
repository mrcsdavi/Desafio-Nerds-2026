package br.com.nerds.patrimonio.controller;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nerds.patrimonio.model.Equipamento;
import br.com.nerds.patrimonio.service.EquipamentoService;

@RestController
@RequestMapping(path = {"/equipamentos"})
@CrossOrigin(origins = "*")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Equipamento> lista = service.listarTodos();

        if (lista.isEmpty()) {
            return ResponseEntity.ok(
                Map.of(
                    "erro", "Não há equipamentos cadastrados"
                )
            );
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/numero-de-serie/{numeroSerie}")
    public Equipamento buscarPorNumeroSerie(@PathVariable String numeroSerie) {
        return service.buscarPorNumeroSerie(numeroSerie);
    }

    @PostMapping
    public Equipamento cadastrar(@RequestBody Equipamento equipamento) {
        return service.cadastrar(equipamento);
    }

    @PutMapping("/numero-de-serie/{numeroSerie}")
    public Equipamento atualizarPorNumeroSerie(
            @PathVariable String numeroSerie,
            @RequestBody Equipamento equipamento) {

        return service.atualizarPorNumeroSerie(numeroSerie, equipamento);
    }

    @DeleteMapping("/numero-de-serie/{numeroSerie}")
    public ResponseEntity<?> excluirPorNumeroSerie(
            @PathVariable String numeroSerie) {

        service.excluirPorNumeroSerie(numeroSerie);

        return ResponseEntity.ok(
            Map.of(
                "mensagem",
                "Equipamento com número de série " + numeroSerie + " removido com sucesso"
            )
        );
    }
}
