package lekang.petclinic.bootstrap;

import lekang.petclinic.model.Owner;
import lekang.petclinic.model.Pet;
import lekang.petclinic.model.PetType;
import lekang.petclinic.model.Vet;
import lekang.petclinic.services.OwnerService;
import lekang.petclinic.services.PetTypeService;
import lekang.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Alice");
        owner1.setSecondName("Swan");

        owner1.setAddress("Jean-Talon O");
        owner1.setCity("Montreal");
        owner1.setTelephone("1111111");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDay(LocalDate.now());
        pet1.setName("Alice's dog.");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setSecondName("Swift");

        owner2.setAddress("Jean-Talon O");
        owner2.setCity("Montreal");
        owner2.setTelephone("2222222");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDay(LocalDate.now());
        pet2.setName("Bob's cat");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners.");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bone");
        vet1.setSecondName("Well");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Fury");
        vet2.setSecondName("Smoothy");
        vetService.save(vet2);

        System.out.println("Loaded Vets.");

    }
}
