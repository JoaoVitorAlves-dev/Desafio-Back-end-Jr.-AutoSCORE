package joao.alves.desafio.desafio_backend.controller;

import joao.alves.desafio.desafio_backend.dto.request.VeiculosRequest;
import joao.alves.desafio.desafio_backend.dto.response.VeiculosResponse;
import joao.alves.desafio.desafio_backend.service.VeiculosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    private final VeiculosService veiculosService;

    public VeiculosController(VeiculosService veiculosService) {
        this.veiculosService = veiculosService;
    }

    @PostMapping
    public ResponseEntity<VeiculosResponse> cadastrar(@RequestBody VeiculosRequest veiculosRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculosService.cadastrar(veiculosRequest));
    }

    @GetMapping
    public ResponseEntity<Page<VeiculosResponse>> listar(Pageable pageable) {
        return ResponseEntity.ok(veiculosService.listar(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculosResponse> atualizar(@PathVariable Long id, @RequestBody VeiculosRequest veiculosRequest) {
        return ResponseEntity.ok(veiculosService.atualizar(id, veiculosRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculosService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
