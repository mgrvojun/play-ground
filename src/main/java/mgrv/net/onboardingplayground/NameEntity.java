package mgrv.net.onboardingplayground;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class NameEntity {

    @Id
    private Long id;

    private String name;

    public NameEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
