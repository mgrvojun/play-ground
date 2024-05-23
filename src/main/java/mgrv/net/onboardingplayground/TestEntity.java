package mgrv.net.onboardingplayground;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class TestEntity {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private NameEntity name;

    @ManyToOne(fetch = FetchType.EAGER)
    private AddressEntity address;

    public TestEntity(Long id, NameEntity name, AddressEntity address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
