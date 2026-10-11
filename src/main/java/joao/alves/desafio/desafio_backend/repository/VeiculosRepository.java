package joao.alves.desafio.desafio_backend.repository;

import joao.alves.desafio.desafio_backend.domain.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
