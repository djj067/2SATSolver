import java.io.*;
import java.util.*;

public class TwoSAT {
    public static void main(String[] args) {
        String path = args[0];
        try {
            Graph g = Loader.load(path);          
            g.tarjan();
            if(g.satisfiable()) {
                System.out.println("FORMULA SATISFIABLE");            
                Map<Integer, Boolean> solution = g.solve();             
                for(int i = 1; i <= solution.size(); i++) {
                    Boolean value = solution.get(i);
                    if(value) {
                        System.out.print('1');
                    } else {
                        System.out.print('0');
                    }

                    if(i != solution.size()) {
                        System.out.print(' ');
                    }
                }
                System.out.println("");
            } else {
                System.out.println("FORMULA UNSATISFIABLE");
            }
        } catch(InvalidInputException e) {
        } catch(IOException e) {
            System.out.println("Unexpected IOException");
        }
    }
}
