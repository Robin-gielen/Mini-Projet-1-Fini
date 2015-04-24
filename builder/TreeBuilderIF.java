package builder;
import exprTree.*;
public interface TreeBuilderIF {

    /**
     * @pre L'expression arithmétique passée au constructeur est
     *      complètement parenthésée et bien formée. Les éléments
     *      de l'expression sont séparés par un espace.
     * @post renvoie un arbre représentant l'expression arithmétique
     *       passée au constructeur
     */
    public ExprIF build();

}
