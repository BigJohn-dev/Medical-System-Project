import com.pddPharmacy.data.models.Drug;
import com.pddPharmacy.data.repositories.Drugs;
import com.pddPharmacy.exceptions.IdDoesNotExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrugsTest {
    private Drugs drugs;

    @BeforeEach
    void setup() {
        drugs = new Drugs();
    }

    @Test
    public void addDrug_countIsOne() {
        assertEquals(0,drugs.count());
        Drug panadol = new Drug();
        drugs.save(panadol);
        assertEquals(1,drugs.count());
    }

    @Test
    public void addDrug_findDrugsById() {
        Drug panadol = new Drug();
        Drug savedDrug = drugs.save(panadol);
        Drug foundDrug = drugs.findById(savedDrug.getId());
        assertEquals(savedDrug, foundDrug);
    }

    @Test
    public void addDrugs_findDrugsById(){
        Drug panadol = new Drug();
        Drug alabuku = new Drug();
        Drug savedPanadol = drugs.save(panadol);
        Drug savedAlabuku = drugs.save(alabuku);
        Drug foundPanadol = drugs.findById(savedPanadol.getId());
        Drug foundAlabuku = drugs.findById(savedAlabuku.getId());
        assertEquals(savedPanadol, foundPanadol);
        assertEquals(savedAlabuku, foundAlabuku);
    }

    @Test
    public void getSavedDrugByName() {
        Drug panadol = new Drug();
        panadol.setName("Panadol");
        Drug savedPanadol = drugs.save(panadol);
        assertEquals(1, drugs.count());
        Drug foundDrug = drugs.findByName("Panadol");
        assertNotNull(foundDrug);
        assertEquals("Panadol", foundDrug.getName());
    }

    @Test
    public  void saveDrugsAssignsIdAutomatically() {
        Drug panadol = new Drug();
        Drug saved = drugs.save(panadol);
        assertEquals(1, saved.getId());
    }

    @Test
    public void findByIdWhenNotFoundThrowsException() {
        assertThrows(IdDoesNotExist.class, () -> drugs.findById(5));
    }

    @Test
    public void multipleSavedDrugsHaveDifferentIds() {
        Drug drugOne = drugs.save(new Drug());
        Drug drugTwo = drugs.save(new Drug());
        Drug drugThree = drugs.save(new Drug());
        assertNotEquals(drugOne.getId(), drugTwo.getId());
        assertNotEquals(drugTwo.getId(), drugThree.getId());
    }

    @Test
    public void saveSameDrugTwice_doesNotDuplicate() {
        Drug panadol = new Drug();
        panadol.setName("Panadol");
        drugs.save(panadol);
        assertEquals(1L,drugs.count());

        drugs.save(panadol);
        assertEquals(1L, drugs.count());

        Drug found = drugs.findByName("Panadol");

        assertEquals(1, drugs.count());
        assertEquals("Updated description", drugs.findByName("Panadol"));
    }

//
//    @Test
//    public void testThatAddedDrugCanBeDeletedById(){
//        Drug panadol = new Drug();
//        Drug savedPanadol = drugs.save(panadol);
//        savedPanadol.setName("Panadol");
//        drugs.save(savedPanadol);
//
//        drugs.deleteById(1);
//        assertThrows(IdDoesNotExist.class, () -> drugs.findById(1));
//    }
//
//    @Test
//    public void testThatNonExistingIdCannotBeDeletedWhenQueried(){
//        Drug panadol = new Drug();
//        Drug savedPanadol = drugs.save(panadol);
//        savedPanadol.setName("Panadol");
//        drugs.save(savedPanadol);
//        assertEquals(1, savedPanadol.getId());
//
//        assertThrows(IdDoesNotExist.class, () -> drugs.deleteById(2));
//    }
//
//    @Test
//    public void testThatADrugCannotBeDeletedTwice(){
//        Drug panadol = new Drug();
//        Drug savedPanadol = drugs.save(panadol);
//        savedPanadol.setName("Panadol");
//        drugs.save(savedPanadol);
//
//        drugs.deleteById(1);
//        assertEquals(0,drugs.count());
//
//        assertThrows(IdDoesNotExist.class, () -> drugs.deleteById(1));
//    }

}