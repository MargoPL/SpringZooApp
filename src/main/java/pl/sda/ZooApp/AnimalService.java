package pl.sda.ZooApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AnimalService {

    private AnimalRepository repository;

    @Autowired
    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public void createAnimal(CreateAnimalRequest request) {
        Animal animal = Animal.builder()
                .vertebrate(request.getVertebrate())
                .age(request.getAge())
                .name(request.getName())
                .country(request.getCountry())
                .weight(request.getWeight())
                .height(request.getHeight())
                .numberOfLegs(request.getNumberOfLegs())
                .birth(request.getBirth())
                .build();

        repository.save(animal);
    }

    public Page<Animal> getAllAnimals(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    public Page<Animal> findAllByAgeAndName(Integer age, String name, Pageable pageable) {
        return repository.findAllByAgeAndName(age, name, pageable);
    }

    public Page<Animal> findAllByAgeBetweenAndWeightBetween(Integer minAge, Integer maxAge, Integer minWeight, Integer maxWeight, Pageable pageable) {
        return repository.findAllByAgeBetweenAndWeightBetween(minAge, maxAge, minWeight, maxWeight, pageable);
    }

    public Page<Animal> findAllByWeightAndHeightAndNumberOfLegsBetween(Integer weight, Integer height, Integer minNumberOfLegs, Integer maxNumberOfLegs, Pageable pageable) {
        return repository.findAllByWeightAndHeightAndNumberOfLegsBetween(weight, height, minNumberOfLegs, maxNumberOfLegs, pageable);
    }

    public Page<Animal> findAllByNameLikeAndCountry(String name, String country, Pageable pageable) {
        return repository.findAllByNameLikeAndCountry(name, country, pageable);
    }

    public Page<Animal> findAllByBirthBetween(LocalDate minDate, LocalDate maxDate, Pageable pageable) {
        return repository.findAllByBirthBetween(minDate, maxDate, pageable);
    }

    public Page<Animal> findAllByNameInAndCountryIn(String name, String country, Pageable pageable) {
        return repository.findAllByNameInAndCountryIn(name, country, pageable);
    }

    public Page<Animal> findAllByWeightInOrHeightIn(Integer weight, Integer height, Pageable pageable) {
        return repository.findAllByWeightInOrHeightIn(weight, height, pageable);
    }

    public Page<Animal> findAllByNameOrCountryOrHeight(String name, String country, Integer height, Pageable pageable){
        return repository.findAllByNameOrCountryOrHeight(name, country, height, pageable);
    }

    public Page<Animal> findAllByWeightLessThanOrHeightGreaterThan(Integer weight, Integer height, Pageable pageable){
        return repository.findAllByWeightLessThanOrHeightGreaterThan(weight, height, pageable);
    }

    public Page<Animal> findAllByNameOrNumberOfLegs(String name, Integer numberOfLegs, Pageable pageable){
        return repository.findAllByNameOrNumberOfLegs(name, numberOfLegs, pageable);
    }

    public Page<Animal> findAllByBirthAfter(LocalDate birth, Pageable pageable){
        return repository.findAllByBirthAfter(birth, pageable);
    }

    public Page<Animal> findAllByVertebrate(Vertebrate vertebrate, Pageable pageable){
        return repository.findAllByVertebrate(vertebrate, pageable);
    }
}
