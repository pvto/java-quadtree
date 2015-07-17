package struct.quadtree;

import java.util.List;
import struct.quadtree.QuadTree.CoordHolder;
import struct.quadtree.QuadTree.Quad;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuadTreeTest {

    public QuadTreeTest() {
    }

    @Test
    public void testQuadTree()
    {
        QuadTree<Integer> q = new QuadTree<>();
        double[] coords = new double[]
        {
            1.0, 1.0,
            2.0, 2.0,
            0.0, 0.0,
            3.0, 3.0,
            0.5, 0.5
        };
        for(int i = 0; i < coords.length;)
        {
            q.place(coords[i++], coords[i++], i / 2);
        }

        assertEquals(coords.length / 2, q.size());
        assertNotNull(q.root.LL);
        assertEquals(2, q.root.UL.UL.items.size());
        assertEquals(2, q.root.UL.LR.items.size());

        Quad quad = q.root.UL.UL;
        CoordHolder ch = q.root.UL.UL.items.get(0);
        ch.x -= 0.5;
        ch.replace();
        assertEquals(1, quad.items.size());
        assertNotNull(quad.parent.parent.parent);   // tree has grown
        assertNull(quad.parent.parent.parent.parent);
        assertNotNull(q.root.UL);
        assertNotNull(q.root.UL.parent);
        assertNull(q.root.UL.parent.parent);
        assertEquals(2, q.root.UL.items.get(0).depth());
        assertEquals(4, q.root.UR.UL.UL.items.get(0).depth());

        //q.print(System.out);
        assertEquals(2, q.findAll(0.0, 0.0, 1.0, 1.0).size());
    }

    int BIG = 1000; // 1000000
    @Test public void testBig10_0() { testBig(BIG, 10, 0); }
    @Test public void testBig10_1() { testBig(BIG, 10, 0); }
    @Test public void testBig10_2() { testBig(BIG, 10, 0); }
    @Test public void testBig10D_0() { testBig(BIG, 10, 1); }
    @Test public void testBig10D_1() { testBig(BIG, 10, 1); }
    @Test public void testBig10D_2() { testBig(BIG, 10, 1); }
    @Test public void testBig100_0() { testBig(BIG, 100, 0); }
    @Test public void testBig100_1() { testBig(BIG, 100, 0); }
    @Test public void testBig100_2() { testBig(BIG, 100, 0); }
    @Test public void testBig1000_0() { testBig(BIG, 1000, 0); }
    @Test public void testBig1000_1() { testBig(BIG, 1000, 0); }
    @Test public void testBig1000_2() { testBig(BIG, 1000, 0); }

    public QuadTree<Integer> testBig(int n, int MAX, int DYNAMIC)
    {
        return testBig(n, MAX, DYNAMIC, 0.333333);
    }
    public QuadTree<Integer> testBig(int n, int MAX, int DYNAMIC, double EXP)
    {
        long time = System.currentTimeMillis();
        QuadTree<Integer> q = new QuadTree<>();
        q.LEAF_MAX_OBJECTS = MAX;
        if (DYNAMIC > 0)
            q.DYNAMIC_MAX_OBJECTS = true;
        q.MAX_OBJ_TARGET_EXPONENT = EXP;
        for(int i = 0; i < n; i++)
        {
            q.place(Math.round(Math.random()*1000), Math.round(Math.random()*1000), i);
        }
        long passed = System.currentTimeMillis() - time;
        System.out.println(passed + " ms, MAX="+MAX+",DYN="+DYNAMIC);
        if (q.size() < 20)
            q.print(System.out);
        return q;
    }

//    @Test
    public void testDepth1000D()
    {
        printDepth(1000000, 10, 1, 0.333333);
        printDepth(100000, 10, 1, 0.333333);
        printDepth(10000, 10, 1, 0.333333);
        printDepth(1000, 10, 1, 0.333333);

        printDepth(1000000, 10, 1, 0.5);
        printDepth(100000, 10, 1, 0.5);
        printDepth(10000, 10, 1, 0.5);
        printDepth(1000, 10, 1, 0.5);

        printDepth(1000000, 1000, 0, 0.5);
        printDepth(100000, 1000, 0, 0.5);
        printDepth(10000, 1000, 0, 0.5);
        printDepth(1000, 1000, 0, 0.5);

        printDepth(1000000, 100, 0, 0.5);
        printDepth(100000, 100, 0, 0.5);
        printDepth(10000, 100, 0, 0.5);
        printDepth(1000, 100, 0, 0.5);

        printDepth(1000000, 10, 0, 0.5);
        printDepth(100000, 10, 0, 0.5);
        printDepth(10000, 10, 0, 0.5);
        printDepth(1000, 10, 0, 0.5);

    }
    private void printDepth(int n, int MAX, int DYNAMIC, double EXP)
    {
        QuadTree<Integer> q = testBig(n, MAX, DYNAMIC, EXP);
        List<QuadTree<Integer>.CoordHolder> all
                = q.findAll(q.root.x1, q.root.y1, q.root.x2, q.root.y2);
        CountingSet<Integer> counts = new CountingSet<>();
        for(CoordHolder h : all)
            counts.increment(h.depth(), 1.0);
        System.out.println((DYNAMIC==0?"STAT":"DYN")+","+n+","+MAX+","+EXP+"," + counts);

    }
}
