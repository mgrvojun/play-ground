package mgrv.net.onboardingplayground;

import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository
        extends org.springframework.data.repository.CrudRepository<AddressEntity, Long>{
}
