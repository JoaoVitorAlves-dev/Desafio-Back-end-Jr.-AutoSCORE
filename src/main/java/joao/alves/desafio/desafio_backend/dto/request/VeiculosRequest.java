package joao.alves.desafio.desafio_backend.dto.request;

import joao.alves.desafio.desafio_backend.domain.Veiculos;
import joao.alves.desafio.desafio_backend.dto.response.VeiculosResponse;

public record VeiculosRequest(
        String cpf,
        String placa
) {

    public Veiculos toEntity(VeiculosRequest veiculosRequest) {
        Veiculos veiculos = new Veiculos();
        veiculos.setCpf(veiculosRequest.cpf);
        veiculos.setPlaca(veiculosRequest.placa);
        veiculos.setMarca("MINI");
        veiculos.setModelo("Countryman");
        veiculos.setChassi("1N6AA0ED3FN098866");
        veiculos.setLicenciado(true);
        return veiculos;
    }

    public VeiculosResponse toDTO(Veiculos veiculos) {
        return new VeiculosResponse(
                veiculos.getId(), veiculos.getProprietario(), veiculos.getCpf(), veiculos.getPlaca(), veiculos.getMarca(),
                veiculos.getModelo(), veiculos.getChassi(), veiculos.getLicenciado()
        );
    }

}
