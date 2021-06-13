package in.soumyadeb.shortify.repository;

import in.soumyadeb.shortify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, User> {
}
