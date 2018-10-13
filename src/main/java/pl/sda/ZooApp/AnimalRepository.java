package pl.sda.ZooApp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;


public interface AnimalRepository extends MongoRepository<Animal, String> {

    Page<Animal> findAllBy(Pageable pageable);

    Page<Animal> findAllByAgeAndName(Integer age, String name, Pageable pageable);

    Page<Animal> findAllByAgeBetweenAndWeightBetween(Integer minAge, Integer maxAge, Integer minWeight, Integer maxWeight, Pageable pageable);

    Page<Animal> findAllByWeightAndHeightAndNumberOfLegsBetween(Integer weight, Integer height, Integer minNumberOfLegs, Integer maxNumberOfLegs, Pageable pageable);

    Page<Animal> findAllByNameLikeAndCountry(String name, String country, Pageable pageable);

    Page<Animal> findAllByBirthBetween(LocalDate minDate, LocalDate maxDate, Pageable pageable);

    Page<Animal> findAllByNameInAndCountryIn(String name, String country, Pageable pageable);

    Page<Animal> findAllByWeightInOrHeightIn(Integer weight, Integer height, Pageable pageable);

    Page<Animal> findAllByNameOrCountryOrHeight(String name, String country, Integer height, Pageable pageable);

    Page<Animal> findAllByWeightLessThanOrHeightGreaterThan(Integer weight, Integer height, Pageable pageable);

    Page<Animal> findAllByNameOrNumberOfLegs(String name, Integer numberOfLegs, Pageable pageable);

    Page<Animal> findAllByBirthAfter(LocalDate birth, Pageable pageable);

    Page<Animal> findAllByVertebrate(Vertebrate vertebrate, Pageable pageable);
}
