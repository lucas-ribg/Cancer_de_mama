package ribeiro.lucas.cancerdemama.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ribeiro.lucas.cancerdemama.Entity.Incidencia;

public interface IncidenciaRepo extends JpaRepository<Incidencia, Long> {
}
