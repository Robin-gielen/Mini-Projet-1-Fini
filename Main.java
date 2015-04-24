import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import builder.*;
import exprTree.*;

public class Main {
    static String chaine = "";
    public static void main(String[] args){
        String[] tab = stringExtractor.stringExtracteur("exprs.txt");
        String[] treatedTab = new String[tab.length];
        for(int i = 0; i < tab.length; i++){
            chaine = tab [i];
            if (chaine.charAt(0) == '('){
                TreeBuilderIF tb = new TreeBuilder(tab[i]);
                ExprIF t = tb.build();
                t.getReducedTree();
            }
            treatedTab[i] = chaine + Node.chainTemp;
            System.out.println(treatedTab[i]);
        }
        stringWriter("exprsOut.txt", treatedTab);
    }
    
    public static void stringWriter(String outputTxtFile, String[] whatToWrite)
    {
        try 
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputTxtFile));
            for (int i=0; i < whatToWrite.length; i++)
            {
                bw.write(whatToWrite[i]);
                bw.newLine();
            }
            bw.close();
        }   
        catch (IOException e) {e.printStackTrace();}
    }
}
