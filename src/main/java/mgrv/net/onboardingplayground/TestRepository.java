package mgrv.net.onboardingplayground;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, Long>{

    Optional<TestEntity> findByName(NameEntity name);
}
