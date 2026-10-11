package joao.alves.desafio.desafio_backend.service;

import joao.alves.desafio.desafio_backend.domain.Veiculos;
import joao.alves.desafio.desafio_backend.dto.request.VeiculosRequest;
import joao.alves.desafio.desafio_backend.dto.response.VeiculosResponse;
import joao.alves.desafio.desafio_backend.repository.VeiculosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VeiculosService {

    private final VeiculosRepository veiculosRepository;

    public VeiculosService(VeiculosRepository veiculosRepository) {
        this.veiculosRepository = veiculosRepository;
    }

    public VeiculosResponse cadastrar(VeiculosRequest veiculosRequest) {
        Veiculos save = veiculosRepository.save(veiculosRequest.toEntity(veiculosRequest));
        return veiculosRequest.toDTO(save);
    }

    public Page<VeiculosResponse> listar(Pageable pageable) {
        return veiculosRepository.findAllBy(pageable);
    }

    public VeiculosResponse atualizar(Long id, VeiculosRequest veiculosRequest) {
        Veiculos veiculos = veiculosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado."));
        veiculos.setId(id);
        veiculos.setCpf(veiculosRequest.cpf());
        veiculos.setPlaca(veiculosRequest.placa());
        return veiculosRequest.toDTO(veiculosRepository.save(veiculos));
    }

    public void deletar(Long id) {
        veiculosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado."));
        veiculosRepository.deleteById(id);
    }
}
