package exprTree;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

/**
 * 
 * Classe creant les noeuds necessaires au programme et simplifiant l'arbre en cour en suivant un parcours postfixe
 * 
 */
public class Node implements ExprIF{
    String expression;
    Node left;
    Node right;
    Node back;
	Node next;
    public static String chainTemp;
	
    /**
     * 
     * Constructeur de la classe Node
     * 
     */
    public Node(String expression){
        this.expression = expression;
        left = null;
        right = null;
        back = null;
		next = null;
    }
    
    /**
     * Simplification de l'arbre.
     *
     * @pre l'arbre represente une expression arithmetique 
     *      bien construite
     * @post Si l'arbre contient au moins un operateur, 
     *       l'arbre renvoye est obtenu après une simplification 
     *       dans l'ordre d'un parcours postfixe
     *       Sinon, renvoit l'arbre original.
     */
    public ExprIF getReducedTree(){
        Node node = this;
        chainTemp = ""; 
        String calculChain = "";
        boolean subtreefinished = true; // Variable servant a verifier si l'arbre a ete reduit
        
        while(node.left != null && node.right != null){ // Boucle servant a resoudre la totalite de l'arbre
            while(subtreefinished){
                while (node.left != null){ // Boucle servant a attaindre l'element positionne le plus bas dans l'arbre
                    node = node.left;
                }
                if (node.back.right.left == null){ // Condition verifiant si le calcul peut etre fait
                    calculChain = (node.expression + "" + node.back.expression + "" + node.back.right.expression+ "" );// creation du string servant a faire le calcul 
                    node.back.expression = calcul(calculChain);
                    node.back.left = null;
                    node.back.right = null;
                    subtreefinished = false;
                }
                else{
                    node = node.back.right;
                }
            }
            subtreefinished = true;
            node = this;
            chainTemp = chainTemp + " = " + (node.toString() );
        }
        //Main.chaine = (chain);// Modification du String de la classe main en vue d'etre sauvegardee dans un fichier
        return node;
    }

    /**
     * Conversion de l'arbre en un String.
     *
     * @pre l'arbre représente une expression arithmétique 
     *      bien construite
     * @post le String renvoyé est la représentation 
     *       complètement parenthésée de l'arbre  
     */
    public String toString(){
        if (this.left == null && this.right == null)
        {
            return this.expression;
        }
        else 
        {
            String actualString = "";
            actualString = "(" + this.left.toString() + this.expression + this.right.toString() + ")";
            return (actualString);
        }
    }
    
    /**
     * 
     * @pre operation est un String non null sous la forme (chiffre operateur chiffre) sans espace
     * @post renvois la sulution du calcul contenue dans operation
     * 
     */
      public static String calcul (String operation){
          String calcul = "";
          try{ // Implementation des elements necessaires a la resolution du calcul a partir d'une chaine de caracteres
              ScriptEngineManager mgr = new ScriptEngineManager(); 
              ScriptEngine engine = mgr.getEngineByName("JavaScript");
              calcul = "" + (engine.eval(operation)); // Effectue l'operation contenue dans operation
          }
           catch(Exception e){
              System.exit(0);
          }
          return calcul;
    } 
    public String getExpression(){
        return this.expression;
    }
    public String getChainTemp(){
        return this.chainTemp;
    }
    public Node getLeft(){
        return this.left;
    }
    public Node getRight(){
        return this.right;
    }
    public Node getBack(){
        return this.back;
    }
    public Node getNext(){
        return this.next;
    }
    public void setExpression(String exp){
        this.expression = exp;
    }
    public void setChainTemp(String chTp){
        this.chainTemp = chTp;
    }
    public void setLeft(exprTree.Node n){
        this.left = n;
    }
    public void setRight(Node n){
        this.right = n;
    }
    public void setBack(Node n){
        this.back = n;
    }
    public void setNext(Node n){
        this.next = n;
    }
}