package j17.example.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class AppNIO {
    /*
    Exercice 1 : Créer un fichier texte et collez-y les paroles de votre chanson préférée (ou votre livre, ou votre article Wikipédia préféré, ça marche aussi)

    Exercice 2 : Développer une méthode qui permet de compter l’occurrence de chaque mot

    Exercice 3 : Ecrire ces informations dans un fichier «occurrence.txt»

    Exercice 4 : Ecrire en fin de fichier le total du nombre de mots

    Exercice 5 : Développer une méthode qui trouve le mot le plus présent dans votre texte. En cas d’égalité, renvoyez la liste des mots les plus présents
     */

    public static final String CAR_FOR_SPLITTING = " ";
    public static final String REGEX_TO_DELETE_NOT_ALPHANUM_CHARACTER ="[^a-zA-Z0-9áàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒ_'\\-]";

    public static void main(String[] args) {
        String monTexte = "L’affaire des fiches, parfois appelée l'affaire des casseroles, est un scandale politique qui éclate en 1904 en France, sous la Troisième République. Il concerne une opération de fichage politique et religieux mise en place dans l'Armée française à l'initiative du général Louis André, ministre de la Guerre, dans un contexte de liquidation de l'affaire Dreyfus et d'accusations d'anti-républicanisme portées par la gauche à l'encontre du corps des officiers.\n" +
                "\n" +
                "De 1900 à 1904, l'administration préfectorale, les loges maçonniques du Grand Orient de France et d'autres réseaux de renseignement établissent des fiches sur les officiers qui sont transmises au cabinet du général André afin de décider de l'avancement hiérarchique et des décorations à attribuer. Ces documents secrets sont préférés par André aux notations officielles du commandement militaire ; ils lui permettent de mettre en place un système où l'avancement des officiers républicains, francs-maçons ou libre-penseurs est favorisé tandis que la carrière des militaires nationalistes et catholiques — conviction religieuse qui vaut, pour le Grand Orient et le cabinet d'André, hostilité à la République — est entravée, dans le but de s'assurer de la loyauté de l'armée au régime en place.\n" +
                "\n" +
                "Le 28 octobre 1904, le député Jean Guyot de Villeneuve interpelle le gouvernement à la Chambre des députés et révèle le système de fichage instauré par le général André et le Grand Orient, produisant à l'appui de ses accusations des fiches qui lui ont été remises par Jean-Baptiste Bidegain, adjoint du secrétaire-général du Grand Orient. Le ministre nie avoir connaissance de ces agissements, mais durant la séance du 4 novembre, Guyot de Villeneuve produit un document qui incrimine André directement ; la séance est houleuse et le député nationaliste Gabriel Syveton gifle le ministre de la Guerre, déclenchant une empoignade dans l'hémicycle.";

        Path pathMyFile = Paths.get("myfileTest.txt");

        //Exo1
        createFile(pathMyFile, monTexte);

        //Exo2
        HashMap<String, Integer> hashMapWordCount = countWordInFile(pathMyFile);

        //Exo3
        Path pathOccurrence = Paths.get("occurrence.txt");
        createFile(pathOccurrence, hashMapWordCount);

        //Exo4
        appendLinesTotalInFile(pathOccurrence);

        //Exo5
        String[] resultMaxWords = findWordMaxCount(pathOccurrence);
        System.out.println(MessageFormat.format("Liste du ou des mots avec la plus grande occurrence [{0}] : {1} ", resultMaxWords[0], resultMaxWords[1]));

        try {
            Files.deleteIfExists(pathMyFile);
            Files.deleteIfExists(pathOccurrence);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendLinesTotalInFile(Path path) {
        boolean fileExists = Files.exists(path);
        try {
            if (fileExists) {
                List<String> results = Files.readAllLines(path);
                String toAppend = "Nombre de mots =" + results.size();
                Files.write(path, toAppend.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(Path path, String sourceToWrite) {
        boolean fileExists = Files.exists(path);
        try {
            Files.deleteIfExists(path);
            //if (!fileExists)
              //  Files.createFile(path);

            Files.write(path, sourceToWrite.getBytes(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(Path path, HashMap<String, Integer> sourceToWrite) {
        boolean fileExists = Files.exists(path);
        try {
            Files.deleteIfExists(path);
            //if (!fileExists)
            //  Files.createFile(path);

            Files.write(path, readHashMap(sourceToWrite), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] findWordMaxCount(Path path) {
        /*Pour chaque ligne dans le fichier (une ligne = un mot : son nombre d'occurrence)
        Prendre le mot et son nombre
        et mettre le couple avec une structure triée TreeMap avec key nombre, value=list<String>
        comparer ce nombre avec le max
        => si supérieur, conserver ce nombre
         */
        TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();
        //Lire le fichier
        ArrayList<String> allLines = readFileAllLines(path);

        int max = 0;
        ArrayList<String> al;
        //On ne lit pas la dernière ligne car elle contient autre chose d'où le
        int nombreLigneALire = allLines.size()-1;
        for (int i = 0; i < nombreLigneALire; i++) {
            String line = allLines.get(i);

            String[] splittedLine = line.split(" : ");
            //Mettre dans le TreeMap
            int key = Integer.parseInt(splittedLine[1]);
            if (treeMap.containsKey(key)) {
                ArrayList<String> currValue = treeMap.get(key);
                currValue.add(splittedLine[0]);
            } else {
                al = new ArrayList<>();
                al.add(splittedLine[0]);
                treeMap.put(key, al);
            }
            //conserver la clé max
            if (key > max) {
                max = key;
            }
        }

        //Fournir le ou les mots avec la plus grand occurrence
        al = treeMap.get(max);
        String resultWords = "";
        if (al != null)
            resultWords = al.toString();

        return new String[]{String.valueOf(max), resultWords};
    }

    public static ArrayList<String> readHashMap(HashMap<String, Integer> sourceToRead) {
        ArrayList<String> alResult = new ArrayList<>();
        for (String key : sourceToRead.keySet()) {
            alResult.add(key + " : " + sourceToRead.get(key));
        }

        return alResult;
    }

    public static ArrayList<String> readFileAllLines(Path path) {
        List<String> results = null;
        if (Files.exists(path)) {
            try {
                results = Files.readAllLines(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return (ArrayList) results;
    }

    public static ArrayList<String> readFileBuffered(Path path) {
        ArrayList<String> results = new ArrayList<String>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                results.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return results;
    }

    public static HashMap<String, Integer> countWordInFile(Path path) {
        HashMap<String, Integer> resultHashMap = new HashMap<>();
        //Lire le fichier
        ArrayList<String> alSource = readFileAllLines(path);

        //Pour chaque ligne
        //pour chaque mot
        //on le met dans un dico et à chaque occurrence, on incrémente son compteur
        int count;
        String lowerSCurr;
        String[] splitted;
        for (String s : alSource) {
            //On ajoute un espace à tout composé d'une apostrophe '
            //l'événement => l' événement
            //afin que l' soit aussi un mot
            s=s.replaceAll("'","' ");
            splitted = s.split(CAR_FOR_SPLITTING);
            for (String sCurr : splitted) {
                //Mettre en minuscule et retirer la ponctuation autour du mot, on garde les mots accentués.
                lowerSCurr = sCurr.toLowerCase().replaceAll(REGEX_TO_DELETE_NOT_ALPHANUM_CHARACTER,"");;

                if (resultHashMap.containsKey(lowerSCurr)) {
                    count = resultHashMap.get(lowerSCurr) + 1;
                    resultHashMap.replace(lowerSCurr, count);
                } else {
                    resultHashMap.put(lowerSCurr, 1);
                }
            }
        }

        return resultHashMap;
    }
}
