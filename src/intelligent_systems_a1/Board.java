package intelligent_systems_a1;

/*Board.java: It describes the STATE of 8-puzzle problem. It maintains the 8-puzzle board configuration, the
move that leads to this state, and the heuristic function value of the state relative to a goal. As Board as an
object whose configuration needs to be shown, it should be implemented as a subclass of ObjectPlus.
Board should include methods that test whether a state is the goal, test whether a move is legal, determine
the new state from a legal move, and determine the heuristic function value of a state./*
*/
/**
 *
 * @author K
 */
public class Board extends ObjectPlus{
    
    private final static char HOLE_CHAR = ' ';
    private char config[][];
    private Hole hole;
    
    public Board(char config[][]){
        this.config = config;
        hole = findHole();
    }
    
    public char[][] getCurrentConfiguration(){
        return config;
    }

    private boolean canMoveLeft(){
        return (hole.x > 0);
        
    }
    
    private boolean canMoveRight(){
        return (hole.x < config[0].length-1);
    }
    
    private boolean canMoveUp(){
        return (hole.y > 0);
    }
    
    private boolean canMoveDown(){
        return (hole.y < config.length-1);
    }
    
    //Move the hole left
    public char[][] moveLeft(){
        
        if (canMoveLeft()){
            char onHole,leftOf;
            
            onHole = config[hole.y][hole.x];
            leftOf = config[hole.y][hole.x-1];
            
            config[hole.y][hole.x] = leftOf;
            config[hole.y][hole.x-1] = onHole;
            
            hole.moveLeft();
            return config;
        }
        
        //return null if can't move left
        return null;
    }
    
    public char[][] moveRight(){
        
        if (canMoveRight()){
            char onHole,rightOf;
            
            onHole = config[hole.y][hole.x];
            rightOf = config[hole.y][hole.x+1];
            
            config[hole.y][hole.x] = rightOf;
            config[hole.y][hole.x+1] = onHole;
            
            hole.moveRight();
            return config;
        }
        
        //return null if can't move right
        return null;
    }
    
    public char[][] moveUp(){
        
        if (canMoveUp()){
            char onHole,above;
            
            onHole = config[hole.y][hole.x];
            above = config[hole.y-1][hole.x];
            
            config[hole.y][hole.x] = above;
            config[hole.y-1][hole.x] = onHole;
            
            hole.moveUp();
            return config;
        }
        
        //return null if can't move up
        return null;
    }
    
    public char[][] moveDown(){
        
        if (canMoveDown()){
            char onHole,below;
            
            onHole = config[hole.y][hole.x];
            below = config[hole.y+1][hole.x];
            
            config[hole.y][hole.x] = below;
            config[hole.y+1][hole.x] = onHole;
            
            hole.moveDown();
            return config;
        }
        
        //return null if can't move down
        return null;
    }
    
    
    private Hole findHole(){
        
        for (int i=0;i<config.length;i++){
        
            for (int j=0;j<config.length;j++){

                if (isHole(config[i][j])){
                   return new Hole(i,j);
               }
            }
        
        }
        return null;
    }
    
    //Hole subclass
    class Hole{
        private int x;
        private int y;
        
        public Hole(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public void moveLeft(){
            x--;
        }
        
        public void moveRight(){
            x++;
        }
        
        public void moveUp(){
            y--;
        }
        
        public void moveDown(){
            y++;
        }
    }
    
    private boolean isHole(char c){
        return (c == HOLE_CHAR);
    }
    
    @Override
    void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void showPart(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
