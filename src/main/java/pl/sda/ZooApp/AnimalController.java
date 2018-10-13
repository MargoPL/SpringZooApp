package pl.sda.ZooApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAnimal(@RequestBody CreateAnimalRequest request) {
        animalService.createAnimal(request);
    }

    @GetMapping("/all")
    public Page<Animal> findAll(@PageableDefault(size = 7) Pageable pageable) {
        return animalService.getAllAnimals(pageable);
    }

    @GetMapping("/1")
    public Page<Animal> findAllByAgeAndName(@RequestParam Integer age, @RequestParam String name, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByAgeAndName(age, name, pageable);
    }

    @GetMapping("/2")
    public Page<Animal> findAllByAgeBetweenAndWeightBetween(@RequestParam Integer minAge, @RequestParam Integer maxAge, @RequestParam Integer minWeight, @RequestParam Integer maxWeight, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByAgeBetweenAndWeightBetween(minAge, maxAge, minWeight, maxWeight, pageable);
    }

    @GetMapping("/3")
    public Page<Animal> findAllByWeightAndHeightAndNumberOfLegsBetween(@RequestParam Integer weight, @RequestParam Integer height, @RequestParam Integer minNumberOfLegs, @RequestParam Integer maxNumberOfLegs, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByWeightAndHeightAndNumberOfLegsBetween(weight, height, minNumberOfLegs, maxNumberOfLegs, pageable);
    }

    @GetMapping("/4")
    public Page<Animal> findAllByNameLikeAndCountry(@RequestParam String name, @RequestParam String country, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByNameLikeAndCountry(name, country, pageable);
    }

    @GetMapping("/5")
    public Page<Animal> findAllByBirthBetween(@RequestParam LocalDate minDate, @RequestParam LocalDate maxDate, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByBirthBetween(minDate, maxDate, pageable);
    }

    @GetMapping("/6")
    public Page<Animal> findAllByNameInAndCountryIn(@RequestParam String name, @RequestParam String country, @PageableDefault(size = 3) Pageable pageable) {
        return animalService.findAllByNameInAndCountryIn(name, country, pageable);
    }

    @GetMapping("/7")
    public Page<Animal> findAllByWeightInOrHeightIn(@RequestParam Integer weight, @RequestParam Integer height, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByWeightInOrHeightIn(weight, height, pageable);
    }

    @GetMapping("/8")
    public Page<Animal> findAllByNameOrCountryOrHeight(@RequestParam String name, @RequestParam String country, @RequestParam Integer height, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByNameOrCountryOrHeight(name, country, height, pageable);
    }

    @GetMapping("/9")
    public Page<Animal> findAllByWeightLessThanOrHeightGreaterThan(@RequestParam Integer weight, @RequestParam Integer height, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByWeightLessThanOrHeightGreaterThan(weight, height, pageable);
    }

    @GetMapping("/10")
    public Page<Animal> findAllByNameOrNumberOfLegs(@RequestParam String name, @RequestParam Integer numberOfLegs, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByNameOrNumberOfLegs(name, numberOfLegs, pageable);
    }

    @GetMapping("/11")
    public Page<Animal> findAllByBirthAfter(@RequestParam LocalDate birth, @PageableDefault(size = 6) Pageable pageable) {
        return animalService.findAllByBirthAfter(birth, pageable);
    }

    @GetMapping("/12")
    public Page<Animal> findAllByVertebrate(Vertebrate vertebrate, Pageable pageable) {
        return animalService.findAllByVertebrate(vertebrate, pageable);
    }
}
