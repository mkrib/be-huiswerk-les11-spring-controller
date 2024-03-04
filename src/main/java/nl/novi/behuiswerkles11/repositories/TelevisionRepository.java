package nl.novi.behuiswerkles11.repositories;

import nl.novi.behuiswerkles11.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findByBrand(String brand);

}
