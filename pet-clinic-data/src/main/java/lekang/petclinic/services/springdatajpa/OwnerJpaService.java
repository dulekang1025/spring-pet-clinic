package lekang.petclinic.services.springdatajpa;

import lekang.petclinic.model.Owner;
import lekang.petclinic.repositories.OwnerRepository;
import lekang.petclinic.repositories.PetRepository;
import lekang.petclinic.repositories.PetTypeRepository;
import lekang.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }else {
            return null;
        }
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
