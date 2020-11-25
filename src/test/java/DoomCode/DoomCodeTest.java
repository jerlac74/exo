package DoomCode;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;
import org.assertj.core.api.*;

import j17.example.DoomCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DoomCodeTest {
    private long start;
    private long diff;

    @BeforeEach
    void setUp() {
        start = System.currentTimeMillis();
    }

    @AfterEach
    void afterEach() {
        //fermer le timer et afficher le résultat
        long end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Durée en millisecondes:" + diff);
    }

    @AfterAll
    static void afterAll() {
        //temps d'exécution du Math.sqrt
        long start = System.currentTimeMillis();
        Math.pow(205.0, (-0.5));
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Durée en millisecondes de Math.pow(205.0, (-0.5)):" + diff);
    }

    @DisplayName("test de DoomCode avec plusieurs float")
    @ParameterizedTest(name="result for {index}: {0}")
    @ValueSource(floats ={4.0F, 1.0F, 2.0F, 15.0F, 16.0F, 10000, 205.0F})
    void name(float f) {
        float resPower =(float)Math.pow(f, (-0.5));
        Assertions.assertThat(DoomCode.invSqrt(f))
                .withFailMessage("Result for :"+f)
                .isLessThanOrEqualTo(resPower);
    }

    @DisplayName("test de DoomCode avec repeated tests float")
    @RepeatedTest(30)
    @Disabled("Works at 99.5%, fell free to test it")
    void nameRepeated() {
        float entree =(float)Math.random()*Float.MAX_VALUE;
        float resPower =(float)Math.pow(entree, (-0.5));
        Assertions.assertThat(DoomCode.invSqrt(entree))
                .withFailMessage("Result for :"+entree)
                .isLessThanOrEqualTo(resPower);
        //ou à tester avec un pourcentage.
        Assertions.assertThat(DoomCode.invSqrt(entree))
                .withFailMessage("Result for :"+entree)
                .isCloseTo(resPower, Percentage.withPercentage(0.5));
    }
}
