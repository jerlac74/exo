package avengers;

import j17.example.avengers.Characters;
import j17.example.avengers.Humanoid;
import j17.example.avengers.SuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.*;

import java.util.List;

public class AvengersTest {
    @BeforeEach
    void setUp() {

    }

    //1-Test qui vérifie que SpiderMan est mineur
    @Test
    public void givenSpiderman_should_beUnder17YearsOld(){
        Assertions.assertThat(Characters.spiderman.getAge()).isLessThanOrEqualTo(17);
    }

    //2-Ecrire un test qui vérifie que Black Widow fait partie des Avengers
    @Test
    void givenBlackWidow_should_beInAvengers() {
        Assertions.assertThat(Characters.blackWidow).isInstanceOf(SuperHero.class);
        Assertions.assertThat(Characters.blackWidow).isIn(Characters.avengers);
        //ou
        Assertions.assertThat(Characters.avengers).contains(Characters.blackWidow);
    }

    //3-Ecrire un test qui vérifie qu’il n’y a pas deux fois le même super-héro dans les Avengers
    @Test
    void givenTwoSuperHero_should_NotbeTheSameInAvengers() {
        //Assertions.assertThat(Characters.avengers).containsOnlyOnce(Characters.avengers);
        //ironman, hulk, thor, blackWidow, captainAmerica, hawkEye
        Assertions.assertThat(Characters.avengers).containsOnlyOnce(Characters.ironman);
        Assertions.assertThat(Characters.avengers).containsOnlyOnce(Characters.hulk);
        Assertions.assertThat(Characters.avengers).containsOnlyOnce(Characters.thor);
        Assertions.assertThat(Characters.avengers).containsOnlyOnce(Characters.blackWidow);
        Assertions.assertThat(Characters.avengers).containsOnlyOnce(Characters.captainAmerica);
        Assertions.assertThat(Characters.avengers).containsOnlyOnce(Characters.hawkEye);

        //ou
        Assertions.assertThat(Characters.avengers).doesNotHaveDuplicates();
    }

    //4-Ecrire un test qui vérifie que les Avengers ne contiennent pas Thanos
    @Test
    void givenAvengers_should_NotContainsThanos() {
        Assertions.assertThat(Characters.avengers).doesNotContain(Characters.thanos);
    }

    //5-Tester que Thor et Thanos n’ont pas de noms de super-héro
    @Test
    void givenSuperHeroThorOrThanos_should_NotHaveSuperHeroName() {
        Assertions.assertThat(Characters.thor).hasFieldOrPropertyWithValue("heroName", null);
        Assertions.assertThat(Characters.thanos).hasFieldOrPropertyWithValue("heroName", null);
    }

    //6-Tester que Thanos possède au moins les mêmes super-pouvoirs que Hulk
    @Test
    void givenThanos_should_HaveSameSuperPowers_Than_Hulk() {
        List<String> powersThanos =Characters.thanos.getPowers();
        for (String power : Characters.hulk.getPowers()) {
            Assertions.assertThat(power).isIn(powersThanos);
        }
        Assertions.assertThat(Characters.thanos.getPowers()).containsAll(Characters.hulk.getPowers());
    }

    //7-Tester que Hawk Eye est de type SuperHero et Humanoid, mais que Clinton Barton n’est pas du type SuperHero ou String
    @Test
    void test7() {
        Assertions.assertThat(Characters.hawkEye)
                .isInstanceOf(SuperHero.class)
                .isInstanceOf(Humanoid.class);
        Assertions.assertThat(Characters.clintonBarton).isNotInstanceOfAny(SuperHero.class, String.class);
    }

    //8-Tester le fait que si l’on ne regarde que l’âge, Tony Stark et Bruce Banner sont égaux
    @Test
    void givenTonyAndBruce_should_HaveSameAge() {
        Assertions.assertThat(Characters.tonyStark.getAge()).isEqualTo(Characters.bruceBanner.getAge());
        Condition<Humanoid> sameAgeBruce = new Condition<>(
                m -> m.getAge()==Characters.bruceBanner.getAge() , "sameAgeBruce");
        Assertions.assertThat(Characters.tonyStark).is(sameAgeBruce);
    }

    //9-S’assurer que le nom de héros «Iron Man» contient bien un espace mais que «Spider-man» n’en contient pas
    @Test
    void test9() {
        Assertions.assertThat(Characters.ironman.heroNameOrHumanoidNameIfNull()).contains(" ");
        Assertions.assertThat(Characters.spiderman.heroNameOrHumanoidNameIfNull()).doesNotContain(" ");
    }
}
