package struct.quadtree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import struct.quadtree.Octree.Oct;

/**
 *
 * @author Paavo Toivanen https://github.com/pvto
 */
public class OctreeTest {

    @Test
    public void testOctree()
    {
        Octree<Integer> q = new Octree<>();
        double[] coords = new double[]
        {
            1.0, 1.0, 1.0,
            2.0, 2.0, 2.0,
            0.0, 0.0, 0.0,
            3.0, 3.0, 3.0,
            0.5, 0.5, 0.5,
        };
        for(int i = 0; i < coords.length;)
        {
            q.place(coords[i++], coords[i++], coords[i++], i / 3);
        }

        assertEquals(coords.length / 3, q.size());
        assertNotNull(q.root.LLN);
        assertEquals(2, q.root.ULN.ULN.items.size());
        
        Oct oct = q.root.ULN.ULN;
        Octree.CoordHolder ch = q.root.ULN.ULN.items.get(0);
        ch.x -= 0.5;
        ch.replace();
        assertEquals(1, oct.items.size());
        assertNotNull(oct.parent.parent.parent);   // tree has grown

    }
}
