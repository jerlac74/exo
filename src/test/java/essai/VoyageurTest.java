package essai;

import j16.essai.ClasseVoyageur;
import j16.essai.Voyageur;
//import org.junit.Before;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.*;

public class VoyageurTest {
    Voyageur v1;
    @BeforeEach
    void setUp() {
        v1 =new Voyageur(1,1,"Durand", ClasseVoyageur.BUSINESS);
    }

    @Test
    public void should_beNamedDurand_when_voyageurNameDurand(){
        //Voyageur v1 =new Voyageur(1,1,"Durand", ClasseVoyageur.BUSINESS);
        //Version avec AssertJ
        Assertions.assertThat(v1.getNom()).isEqualTo("Durand");

        //version avec JUnit
        org.junit.jupiter.api.Assertions.assertEquals(v1.getNom(), "Durand");
    }
}
