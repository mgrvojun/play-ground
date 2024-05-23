package mgrv.net.onboardingplayground;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final TestRepository testRepository;
    private final NameRepository nameRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;
    private NameEntity nameEntity;
    private Long ids = 1L;
    private AtomicInteger count = new AtomicInteger(0);
    private AtomicInteger count2 = new AtomicInteger(0);

    @Scheduled(cron = "* * * * * *") // "0 0 0 * * *
    @Transactional
    public void save() {
        if (count.get() > 0) {
            return;
        }
        NameEntity nameEntity = new NameEntity(ids++, "Test");
        NameEntity save = nameRepository.save(nameEntity);
        this.nameEntity = save;

        AddressEntity addressEntity = new AddressEntity(ids++, "Test");
        AddressEntity save1 = addressRepository.save(addressEntity);

        TestEntity testEntity = new TestEntity(ids++, save, save1);
        testRepository.save(testEntity);
        count.incrementAndGet();
    }

    @Scheduled(cron = "* * * * * *") // "0 0 0 * * *
    @Transactional
    public void get() {
        synchronized (this) {
            if (nameEntity == null || count2.get() > 0) {
                return;
            }
            Optional<TestEntity> byId = testRepository.findById(1L);
            byId.ifPresent(e -> {
                String name = e.getAddress().getName();
                if (!name.equals("Test")) {
                    throw new RuntimeException("Test");
                }
                System.out.println(name);
            });
            testRepository.findByName(nameEntity).ifPresent(e -> {
                String name = e.getAddress().getName();
                if (!name.equals("Test")) {
                    throw new RuntimeException("Test");
                }
                System.out.println(name);
            });
            count2.incrementAndGet();
        }
    }
}
