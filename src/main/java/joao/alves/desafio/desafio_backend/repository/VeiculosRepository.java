package joao.alves.desafio.desafio_backend.repository;

import joao.alves.desafio.desafio_backend.domain.Veiculos;
import joao.alves.desafio.desafio_backend.dto.response.VeiculosResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
    Page<VeiculosResponse> findAllBy(Pageable pageable);

}
