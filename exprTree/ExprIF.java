package exprTree; 

public interface ExprIF {
	
    /**
     * Simplification de l'arbre.
     *
     * @pre l'arbre représente une expression arithmétique 
     *      bien construite
     * @post Si l'arbre contient au moins un opérateur, 
     *       l'arbre renvoyé est obtenu après une simplification 
     *       dans l'ordre d'un parcours postfixe
     *       Sinon, renvoit l'arbre original.
     */
    public ExprIF getReducedTree();

    /**
     * Conversion de l'arbre en un String.
     *
     * @pre l'arbre représente une expression arithmétique 
     *      bien construite
     * @post le String renvoyé est la représentation 
     *       complètement parenthésée de l'arbre  
     */
    public String toString();

}
