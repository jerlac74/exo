package serie1;

import java.util.HashMap;

public class Exo4 {
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

    private static HashMap<Integer, Long> hashmap =new HashMap<Integer, Long>();

    public static long calculFibonacci(int numero) {
        long result = 0;

        if(numero==0)
            return 0;
        else if(numero==1)
                return 1;

        return calculFibonacci(numero-1) + calculFibonacci(numero-2);
    }

    public static long calculFibonacciMap(int numero) {
        long result = 0;

        if(numero==0)
            return 0;
        else if(numero==1)
            return 1;

        if(hashmap.containsKey(numero))
            result =hashmap.get(numero);
        else {
            result =calculFibonacciMap(numero-1) + calculFibonacciMap(numero-2);
            hashmap.put(numero, result);
        }

        return result;
    }

}
