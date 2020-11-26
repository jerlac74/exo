package nio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import static j17.example.nio.AppNIO.*;

public class AppNIOTest {
    /*
    Exercice 1 : Créer un fichier texte et collez-y les paroles de votre chanson préférée (ou votre livre, ou votre article Wikipédia préféré, ça marche aussi)

    Exercice 2 : Développer une méthode qui permet de compter l’occurrence de chaque mot

    Exercice 3 : Ecrire ces informations dans un fichier «occurrence.txt»

    Exercice 4 : Ecrire en fin de fichier le total du nombre de mots

    Exercice 5 : Développer une méthode qui trouve le mot le plus présent dans votre texte. En cas d’égalité, renvoyez la liste des mots les plus présents
     */

    private String sourceToWrite;
    @BeforeEach
    void setUp() {
        sourceToWrite ="Mon texte contient 2 mots texte et 3 mots apétit, Apétit, l'apétit, et 2 libre-penseur, LibRe-penseur, 1 age_morte.";
    }

    @Test
    @DisplayName("tester la création et la lecture d'un fichier")
    void Exo1() {
        Path pathMyFile = Paths.get("myfileTestExo1.txt");

        createFile(pathMyFile, sourceToWrite);
        ArrayList<String> alresults =  readFileAllLines(pathMyFile);

        ArrayList<String> alTemp = new ArrayList<>();
        alTemp.add(sourceToWrite);

        try {
            Files.deleteIfExists(pathMyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(alresults).containsExactlyElementsOf(alTemp);
    }

    @Test
    @DisplayName("tester la méthode qui compte le nombre de mot")
    void Exo2() {
        Path pathMyFile = Paths.get("myfileTestExo2.txt");
        createFile(pathMyFile, sourceToWrite);
        HashMap<String, Integer> hashMapWordCount = countWordInFile(pathMyFile);

        try {
            Files.deleteIfExists(pathMyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(hashMapWordCount)
                .withFailMessage("le hashMap est null ou vide")
                .isInstanceOf(HashMap.class).isNotEmpty();
        Assertions.assertThat(hashMapWordCount.get("texte")).isEqualTo(2);
        Assertions.assertThat(hashMapWordCount.get("apétit")).isEqualTo(3);
        Assertions.assertThat(hashMapWordCount.get("mots")).isEqualTo(2);
        Assertions.assertThat(hashMapWordCount.get("libre-penseur")).isEqualTo(2);
        Assertions.assertThat(hashMapWordCount.get("2")).isEqualTo(2);
        Assertions.assertThat(hashMapWordCount.get("l'")).isEqualTo(1);
        Assertions.assertThat(hashMapWordCount.get("age_morte")).isEqualTo(1);
    }

    @Test
    @DisplayName("Vérifier que la dernière ligne du fichier correspond")
    void Exo4() {
        Path pathMyFile = Paths.get("myfileTestExo4.txt");

        int nombreDeMots =12;
        createFile(pathMyFile, sourceToWrite);
        HashMap<String, Integer> hashMapWordCount = countWordInFile(pathMyFile);

        Path pathOccurrence = Paths.get("occurrenceTestExo4.txt");
        createFile(pathOccurrence, hashMapWordCount);
        appendLinesTotalInFile(pathOccurrence);

        //Lire la derière ligne et vérifier qu'elle contient :"Nombre de mots =" + NombreDeMots;
        ArrayList<String> alresults =  readFileAllLines(pathOccurrence);
        String result ="";
        if(alresults!=null)
            result = alresults.get(alresults.size()-1);

        try {
            Files.deleteIfExists(pathMyFile);
            Files.deleteIfExists(pathOccurrence);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(result).isEqualTo("Nombre de mots =" + nombreDeMots);
    }

    @Test
    @DisplayName("Obtenir le ou les mots ayant la plus grande occurrence")
    void Exo5() {
        Path pathMyFile = Paths.get("myfileTestExo5.txt");

        createFile(pathMyFile, sourceToWrite);
        HashMap<String, Integer> hashMapWordCount = countWordInFile(pathMyFile);

        Path pathOccurrence = Paths.get("occurrenceTestExo5.txt");
        createFile(pathOccurrence, hashMapWordCount);
        appendLinesTotalInFile(pathOccurrence);

        String[] resultMaxWords = findWordMaxCount(pathOccurrence);

        try {
            Files.deleteIfExists(pathMyFile);
            Files.deleteIfExists(pathOccurrence);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertThat(resultMaxWords).isInstanceOf(String[].class);
        Assertions.assertThat(resultMaxWords[0]).isEqualTo("3");
        Assertions.assertThat(resultMaxWords[1]).isEqualTo("[apétit]");
    }

    @Test
    @DisplayName("Obtenir le ou les mots ayant la plus grande occurrence avec un autre texte")
    void Exo5_1() {
        //On veut un retour avec plusieurs mots ayant le nombre max d'occurrence
        String sourceToWrite ="Mon texte contient 2 mots texte et Apétit, l'apétit, et 2 mots libre-penseur, LibRe-penseur, 1 age_morte.";
        //On doit trouver en résultat avec 2 et ["texte","2","mots","apétit","libre-penseur","et"] mais sans ordre
        Path pathMyFile = Paths.get("myfileTestExo5_1.txt");

        createFile(pathMyFile, sourceToWrite);
        HashMap<String, Integer> hashMapWordCount = countWordInFile(pathMyFile);

        Path pathOccurrence = Paths.get("occurrenceTestExo5_1.txt");
        createFile(pathOccurrence, hashMapWordCount);
        appendLinesTotalInFile(pathOccurrence);

        String[] resultMaxWords = findWordMaxCount(pathOccurrence);

        try {
            Files.deleteIfExists(pathMyFile);
            Files.deleteIfExists(pathOccurrence);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertThat(resultMaxWords).isInstanceOf(String[].class);
        Assertions.assertThat(resultMaxWords[0]).isEqualTo("2");

        Assertions.assertThat(resultMaxWords[1]).startsWith("[");
        Assertions.assertThat(resultMaxWords[1]).contains("texte");
        Assertions.assertThat(resultMaxWords[1]).contains("2");
        Assertions.assertThat(resultMaxWords[1]).contains("mots");
        Assertions.assertThat(resultMaxWords[1]).contains("et");
        Assertions.assertThat(resultMaxWords[1]).contains("apétit");
        Assertions.assertThat(resultMaxWords[1]).contains("libre-penseur");
        Assertions.assertThat(resultMaxWords[1]).endsWith("]");
    }
}
