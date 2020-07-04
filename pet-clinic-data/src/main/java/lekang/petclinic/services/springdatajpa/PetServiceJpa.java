package lekang.petclinic.services.springdatajpa;

import lekang.petclinic.model.Pet;
import lekang.petclinic.repositories.PetRepository;
import lekang.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("SpringDataJpa")
public class PetServiceJpa implements PetService {

    private final PetRepository petRepository;

    public PetServiceJpa(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> set = new HashSet<>();
        petRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Pet findById(Long aLong) {
        Optional<Pet> optionalPet = petRepository.findById(aLong);
        if(optionalPet.isPresent()){
            return optionalPet.get();
        }else{
            return null;
        }
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
