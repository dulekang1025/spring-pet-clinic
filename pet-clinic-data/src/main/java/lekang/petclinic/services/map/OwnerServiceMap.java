package lekang.petclinic.services.map;

import lekang.petclinic.model.Owner;
import lekang.petclinic.model.Pet;
import lekang.petclinic.services.OwnerService;
import lekang.petclinic.services.PetService;
import lekang.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach( pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet type is required.");
                    }

                    if(pet.getId() == null){
                        Pet saved = petService.save(pet);
                        pet.setId(saved.getId());
                    }
                });
            }
            return super.save(object);
        }else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findBySecondName(String lastName) {
        return null;
    }
}
