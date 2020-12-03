package apap.tutorial.traveloke.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tutorial.traveloke.model.UserModel;

@Repository
public interface UserDb extends JpaRepository<UserModel, Long>{
    UserModel findByUsername(String username);
}
