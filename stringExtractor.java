import java.util.Scanner; 
import java.lang.String; 
import java.io.*;
import java.util.Random;

/**
 * 
 * 
 */
public class stringExtractor{
    /**
     * Exctractor of the string from the .txt file
     * 
     * @pre un fichier .txt dans lequel l arbre est represente par une expression arithmetique bien construite avec un espace entre chaque element 
     * @post renvois un String representant l arbre par une expression arithmetique bien construite, sans aucun espace
     */
    public static String[] stringExtracteur(String exprsIN){
        String[] untreatedLines; // Tableau contenant toutes les lignes non traitees
        String currentLine; // Conteneur temporaire de ligne
        
        int lines = 0; //compteur du nombre de lignes
        
        BufferedReader br = null; // On initialise le bufferedReader
        
        try {
            br = new BufferedReader(new FileReader(exprsIN));
            while (br.readLine() != null){
                lines++;
            } 
            br.close();
        }
        catch (IOException e){ 
            System.exit(0);
        }
        
        untreatedLines = new String[lines-1];
        
        try {
            br = new BufferedReader(new FileReader(exprsIN));
            for (int i = 0; i < lines-1; i++){ // Boucles pour repasser dans le fichier et extraire les differentes lignes
            
                currentLine = br.readLine();
                untreatedLines[i] = "";
                
                for (int j = 0; j < currentLine.length(); j++){ // Boucles pour parcourir la ligne en cours et extraire les chiffres et operateurs en supprimant les espaces
                
                    if (currentLine.charAt(j) != ' '){ // On verifie si on a affaire a un espace ou pas, si ca n est pas un espace, on l ajoute a la ligne correspondante dans le tableau
                    
                        untreatedLines[i] += currentLine.charAt(j);
                    }
                }
            }
            br.close();
        }
        catch (IOException e){
            System.exit(0);
        }
        return (untreatedLines);
    }
}
