package exprTree;
/**
 * 
 * Classe creant une pile pour stocker les noeuds de la methode build de la classe TreeBuilder
 * 
 */
public class Pile{
    
    private Node head; // Declaration de la tete de liste
    private Node tempon;
    
    /**
     * 
     * Constructeur de la classe pile
     * 
     */
    public Pile(){
        head = null; // Initialise la tete de la pile a null
    }

    /**
     * 
     * @pre n est un noeud existant
     * @post place le noeud n en tete de pile
     */
    public void push(Node n){
        if (isEmpty()){
            head = n;
        }
        else{
            n.next = head;
            head = n;
        }
    }
    
    /**
     * 
     * @pre /
     * @post renvois et retire le premier noeud de la pile
     * 
     */
    public Node pop(){
        tempon = null;
        if (!isEmpty()){
            if (head.next != null){
                tempon = head;
                head = head.next;
                tempon.next = null;
            }
            else{
                tempon = head;
                head = null;
			}
        }
        else{
            System.exit(0);
        }
		return tempon;
	}
	
	/**
	 * 
	 * @pre /
	 * @post / renvoie true si la pile est vide et false si il y a au moins un element dans la pile
	 * 
	 */
	public boolean isEmpty(){
		return (head == null);
	}
}