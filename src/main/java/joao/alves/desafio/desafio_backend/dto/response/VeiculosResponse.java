package joao.alves.desafio.desafio_backend.dto.response;

public record VeiculosResponse(
        Long id,
        String proprietario,
        String cpf,
        String placa
) {
}
