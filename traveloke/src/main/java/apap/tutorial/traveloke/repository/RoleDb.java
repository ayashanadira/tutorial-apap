package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long> {
    RoleModel findByRole(String role);
}
