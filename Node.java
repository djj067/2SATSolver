import java.util.ArrayList;

public class Node {
    public int id;
    public int index;
    public int lowlink;
    public boolean inStack;
    public ArrayList<Node> children;
	public ArrayList<Node> parent;
	public boolean value;

    public String toString() {
        return Integer.valueOf(this.id).toString();
    }

    public boolean allChildrentrue(){
    	for (Node child: children){
    		if (!child.value){
    			return false
    		}
    	}
    	return true;
    }

    public boolean allParentsTrue(){
    	for (Node parent: parent){
    		if(!parent.value){
    			return false;
    		}
    	}
    	return true;
    }
}
