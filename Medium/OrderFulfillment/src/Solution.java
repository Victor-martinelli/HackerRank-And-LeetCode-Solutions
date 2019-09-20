
import java.util.ArrayList;
import java.util.List;

/*
 *

    Orders can only be fulfilled when letters are next to eachother

    G-O-N-E
    | | | |
    T-A-R-T
 */
/**
 *
 * @author Portatil
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Position g = new Position("G");
        Position o = new Position("O");
        Position n = new Position("N");
        Position e = new Position("E");
        Position t = new Position("T");
        Position a = new Position("A");
        Position r = new Position("R");
        Position t2 = new Position("T");

        List<Position> all = new ArrayList();

        all.add(g);
        all.add(o);
        all.add(n);
        all.add(e);
        all.add(t);
        all.add(a);
        all.add(r);
        all.add(t2);
        
        g.nearPositions.put(o,o);
        g.nearPositions.put(t,t);
        
        o.nearPositions.put(g,g);
        o.nearPositions.put(a,a);
        o.nearPositions.put(n,n);
        
        t.nearPositions.put(g,g);
        t.nearPositions.put(a,a);
        
        a.nearPositions.put(t,t);
        a.nearPositions.put(o,o);
        a.nearPositions.put(r,r);
        
        r.nearPositions.put(a,a);
        r.nearPositions.put(n,n);
        r.nearPositions.put(t2,t2);
        
        t2.nearPositions.put(r,r);
        t2.nearPositions.put(e,e);
        
        e.nearPositions.put(t2,t2);
        e.nearPositions.put(n,n);
        
        n.nearPositions.put(o,o);
        n.nearPositions.put(r,r);
        n.nearPositions.put(e,e);
        
        
        
        String order = "ONE";

        int index = all.indexOf(new Position(new String(order.charAt(0)+"")));
        
        if(index!=-1)
            System.out.println("Can the order "+order+" be fulfilled?: "+canOrderFulFill(all.get(index),order.substring(1)));
        else
            System.out.println("Can the order "+order+" be fulfilled?: false");
        
        String order2 = "ONG";

        int index2 = all.indexOf(new Position(new String(order2.charAt(0)+"")));
        
        if(index2!=-1)
            System.out.println("Can the order "+order2+" be fulfilled?: "+canOrderFulFill(all.get(index2),order2.substring(1)));
        else
            System.out.println("Can the order "+order2+" be fulfilled?: false");
        
        String order3 = "RAR";

        int index3 = all.indexOf(new Position(new String(order3.charAt(0)+"")));
        
        if(index3!=-1)
            System.out.println("Can the order "+order3+" be fulfilled?: "+canOrderFulFill(all.get(index3),order3.substring(1)));
        else
            System.out.println("Can the order "+order3+" be fulfilled?: false");

        String order4 = "BOAT";

        int index4 = all.indexOf(new Position(new String(order4.charAt(0)+"")));
        
        if(index4!=-1)
            System.out.println("Can the order "+order4+" be fulfilled?: "+canOrderFulFill(all.get(index4),order4.substring(1)));
        else
            System.out.println("Can the order "+order4+" be fulfilled?: false");
        
        
    }
    
    

    public static boolean canOrderFulFill(Position current,String remainOrder) {
          
        boolean result=true;
        
        //The order still needs to be fulfilled
        if(remainOrder.length()>0)
        {
            Position next = new Position(new String(remainOrder.charAt(0)+""));
            
            //If the next item is within our reach
            if(current.nearPositions.containsKey(next))
                result = canOrderFulFill(current.nearPositions.get(next),remainOrder.substring(1));
            else
                result=false;
        }
        
        return result;
    }

}
