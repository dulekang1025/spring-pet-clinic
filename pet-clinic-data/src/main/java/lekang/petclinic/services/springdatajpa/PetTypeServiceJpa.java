package lekang.petclinic.services.springdatajpa;

import lekang.petclinic.model.PetType;
import lekang.petclinic.repositories.PetTypeRepository;
import lekang.petclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PetTypeServiceJpa implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> set = new HashSet<>();
        petTypeRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public PetType findById(Long aLong) {
        Optional<PetType> optionalPetType = petTypeRepository.findById(aLong);
        if(optionalPetType.isPresent()){
            return optionalPetType.get();
        }else{
            return null;
        }
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
