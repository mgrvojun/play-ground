package mgrv.net.onboardingplayground;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends CrudRepository<NameEntity, Long> {


}
