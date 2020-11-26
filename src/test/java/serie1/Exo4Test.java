package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Exo4Test {
    /*
    Ecrire le code pour calculer le n-ième élément de la suite de Fibonacci.
    Pour rappel, la suite de Fibonacci est définie comme telle :
    f(0) = 0
    f(1) = 1
    f(n) = f(n-1) + f(n-2)

    f(2) = f(0)+f(1) = 1
    f(3) = f(1)+f(2) = 2
    f(10) = f(9)+f(8) = 55
    f(16) = 987
    Essayez de calculer f(80), que constatez-vous ?
    A votre avis, pourquoi ?
    Essayez de trouver une optimisation afin de faire tourner f(80) dans un délai correct.
     */

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

    @Test
    @DisplayName("suite fibonacci")
    void calculFibonacci() {
        int[] numeros={0,1,5,10,16};
        long[] resultat={0,1,5,55,987};
        int turn=0;
        Assertions.assertThat(serie1.Exo4.calculFibonacci(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacci(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacci(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacci(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacci(numeros[turn])).isEqualTo(resultat[turn++]);
    }
    @Test
    @DisplayName("suite fibonacci pour 49")
    void calculFibonacci49() {
        int[] numeros={49};
        long[] resultat={7778742049L};
        Assertions.assertThat(serie1.Exo4.calculFibonacci(numeros[0])).isEqualTo(resultat[0]);
    }
    @Test
    @DisplayName("suite fibonacci pour 80")
    void calculFibonacci80() {
        int[] numeros={80};
        long[] resultat={23416728348467685L};
        Assertions.assertThat(serie1.Exo4.calculFibonacci(numeros[0])).isEqualTo(resultat[0]);
    }

    @Test
    @DisplayName("suite fibonacci avec Map")
    void calculFibonacciMap() {
        int[] numeros={0,1,5,10,16};
        long[] resultat={0,1,5,55,987};
        int turn=0;
        Assertions.assertThat(serie1.Exo4.calculFibonacciMap(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacciMap(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacciMap(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacciMap(numeros[turn])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(serie1.Exo4.calculFibonacciMap(numeros[turn])).isEqualTo(resultat[turn++]);
    }

    @Test
    @DisplayName("suite fibonacci avec Map avec 49")
    void calculFibonacciMap49() {
        int numeros=49;
        long resultat=7778742049L;
        Assertions.assertThat(serie1.Exo4.calculFibonacciMap(numeros)).isEqualTo(resultat);
    }
    @Test
    @DisplayName("suite fibonacci avec Map avec 80")
    void calculFibonacciMap80() {
        int numeros=80;
        long resultat=23416728348467685L;
        Assertions.assertThat(serie1.Exo4.calculFibonacciMap(numeros)).isEqualTo(resultat);
    }

}
