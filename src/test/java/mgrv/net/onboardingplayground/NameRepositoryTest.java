package mgrv.net.onboardingplayground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class NameRepositoryTest {


    @Autowired
    private TestRepository testRepository;
    @Autowired
    private NameRepository nameRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("INSERT INTO name_entity (id, name) VALUES (1, 'Test')");
        jdbcTemplate.execute("INSERT INTO address_entity (id, name) VALUES (1, 'Test')");
        jdbcTemplate.execute("INSERT INTO test_entity (id, name_id, address_id) VALUES (1, 1, 1)");
    }

    @Test
    void testFindByName() {
//        testRepository.findById(1L)
//                     .orElseThrow();
        NameEntity nameEntity = nameRepository.findById(1L)
                                              .orElseThrow();
        TestEntity testEntity = testRepository.findByName(nameEntity)
                                              .orElseThrow();
        assertEquals("Test", testEntity.getAddress().getName());
    }
}