package mgrv.net.onboardingplayground;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class AddressEntity {

    @Id
    private Long id;

    private String name;

    public AddressEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
