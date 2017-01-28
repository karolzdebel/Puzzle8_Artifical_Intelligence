package intelligent_systems_a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*PuzzleAgent.java: This class launches agent application, and should be a subclass of SearchAgent described
above. It loads initial state and goal state from a file. It must implement showSolution(),showTree(),
and insertFringe() as required by SearchAgent.*/


/**
 *
 * @author K
 */
public final class PuzzleAgent extends SearchAgent {

    @Override
    void showSolution() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void showTree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void insertFringe(Node nd, LinkedList<Node> ll) {
        
        Board insertBoard = (Board)nd.getState();
        
        for (int i=0;i<ll.size();i++){
            Board curBoard = (Board)ll.get(i).getState();

            //find lowest heuristic value position
            if (insertBoard.getHeurValue() < curBoard.getHeurValue()){
                ll.add(i,nd);
            }
        }
    }
}
