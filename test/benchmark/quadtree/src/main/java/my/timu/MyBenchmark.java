/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package my.timu;

import my.struct.QuadTree.CoordHolder;
import my.struct.QuadTree.Quad;
import my.struct.QuadTree;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


public class MyBenchmark {


    private static QuadTree<Integer> quadDyn1000_33 = testBig(1000000, 10, 1, 0.333333);
    private static CoordHolder coordDyn1000_33 = quadDyn1000_33.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadDyn100_33 = testBig(100000, 10, 1, 0.333333);
    private static CoordHolder coordDyn100_33 = quadDyn100_33.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadDyn10_33 = testBig(10000, 10, 1, 0.333333);
    private static CoordHolder coordDyn10_33 = quadDyn10_33.findAll(0.0,0.0, 500.0,500.0).get(0);

    @Benchmark public void testDynamic1000_33_()            { testBig(1000000, 10, 1, 0.333333); }
    @Benchmark public void testDynamic1000_33_Gets100th()   { findAll(quadDyn1000_33, 1000.0, 100.0); }
    @Benchmark public void testDynamic1000_33_Gets16th()    { findAll(quadDyn1000_33, 1000.0, 250.0); }
    @Benchmark public void testDynamic1000_33_Gets4th()     { findAll(quadDyn1000_33, 1000.0, 500.0); }
    @Benchmark public void testDynamic1000_33_Replace()     { replace(coordDyn1000_33, 1000000, 10.0); }

    @Benchmark public void testDynamic100_33_()             { testBig(100000, 10, 1, 0.333333); }
    @Benchmark public void testDynamic100_33_Gets100th()    { findAll(quadDyn100_33, 1000.0, 100.0); }
    @Benchmark public void testDynamic100_33_Gets16th()     { findAll(quadDyn100_33, 1000.0, 250.0); }
    @Benchmark public void testDynamic100_33_Gets4th()      { findAll(quadDyn100_33, 1000.0, 500.0); }
    @Benchmark public void testDynamic100_33_Replace()      { replace(coordDyn100_33, 1000000, 10.0); }

    @Benchmark public void testDynamic10_33_()              { testBig(10000, 10, 1, 0.333333); }
    @Benchmark public void testDynamic10_33_Gets100th()     { findAll(quadDyn10_33, 1000.0, 100.0); }
    @Benchmark public void testDynamic10_33_Gets16th()      { findAll(quadDyn10_33, 1000.0, 250.0); }
    @Benchmark public void testDynamic10_33_Gets4th()       { findAll(quadDyn10_33, 1000.0, 500.0); }
    @Benchmark public void testDynamic10_33_Replace()       { replace(coordDyn10_33, 1000000, 10.0); }


    private static QuadTree<Integer> quadDyn1000_5 = testBig(1000000, 10, 1, 0.5);
    private static CoordHolder coordDyn1000_5 = quadDyn1000_5.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadDyn100_5 = testBig(100000, 10, 1, 0.5);
    private static CoordHolder coordDyn100_5 = quadDyn100_5.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadDyn10_5 = testBig(10000, 10, 1, 0.5);
    private static CoordHolder coordDyn10_5 = quadDyn10_5.findAll(0.0,0.0, 500.0,500.0).get(0);


    @Benchmark public void testDynamic1000_5_()            { testBig(1000000, 10, 1, 0.5); }
    @Benchmark public void testDynamic1000_5_Gets100th()   { findAll(quadDyn1000_5, 1000.0, 100.0); }
    @Benchmark public void testDynamic1000_5_Gets16th()    { findAll(quadDyn1000_5, 1000.0, 250.0); }
    @Benchmark public void testDynamic1000_5_Gets4th()     { findAll(quadDyn1000_5, 1000.0, 500.0); }
    @Benchmark public void testDynamic1000_5_Replace()     { replace(coordDyn1000_5, 1000000, 10.0); }

    @Benchmark public void testDynamic100_5_()             { testBig(100000, 10, 1, 0.5); }
    @Benchmark public void testDynamic100_5_Gets100th()    { findAll(quadDyn100_5, 1000.0, 100.0); }
    @Benchmark public void testDynamic100_5_Gets16th()     { findAll(quadDyn100_5, 1000.0, 250.0); }
    @Benchmark public void testDynamic100_5_Gets4th()      { findAll(quadDyn100_5, 1000.0, 500.0); }
    @Benchmark public void testDynamic100_5_Replace()      { replace(coordDyn100_5, 1000000, 10.0); }

    @Benchmark public void testDynamic10_5_()              { testBig(10000, 10, 1, 0.5); }
    @Benchmark public void testDynamic10_5_Gets100th()     { findAll(quadDyn10_5, 1000.0, 100.0); }
    @Benchmark public void testDynamic10_5_Gets16th()      { findAll(quadDyn10_5, 1000.0, 250.0); }
    @Benchmark public void testDynamic10_5_Gets4th()       { findAll(quadDyn10_5, 1000.0, 500.0); }
    @Benchmark public void testDynamic10_5_Replace()       { replace(coordDyn10_5, 1000000, 10.0); }


    private static QuadTree<Integer> quadDyn1000_75 = testBig(1000000, 10, 1, 0.75);
    private static CoordHolder coordDyn1000_75 = quadDyn1000_75.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadDyn100_75 = testBig(100000, 10, 1, 0.75);
    private static CoordHolder coordDyn100_75 = quadDyn100_75.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadDyn10_75 = testBig(10000, 10, 1, 0.75);
    private static CoordHolder coordDyn10_75 = quadDyn10_75.findAll(0.0,0.0, 500.0,500.0).get(0);


    @Benchmark public void testDynamic1000_75_()            { testBig(1000000, 10, 1, 0.75); }
    @Benchmark public void testDynamic1000_75_Gets100th()   { findAll(quadDyn1000_75, 1000.0, 100.0); }
    @Benchmark public void testDynamic1000_75_Gets16th()    { findAll(quadDyn1000_75, 1000.0, 250.0); }
    @Benchmark public void testDynamic1000_75_Gets4th()     { findAll(quadDyn1000_75, 1000.0, 500.0); }
    @Benchmark public void testDynamic1000_75_Replace()     { replace(coordDyn1000_75, 1000000, 10.0); }

    @Benchmark public void testDynamic100_75_()             { testBig(100000, 10, 1, 0.75); }
    @Benchmark public void testDynamic100_75_Gets100th()    { findAll(quadDyn100_75, 1000.0, 100.0); }
    @Benchmark public void testDynamic100_75_Gets16th()     { findAll(quadDyn100_75, 1000.0, 250.0); }
    @Benchmark public void testDynamic100_75_Gets4th()      { findAll(quadDyn100_75, 1000.0, 500.0); }
    @Benchmark public void testDynamic100_75_Replace()      { replace(coordDyn100_75, 1000000, 10.0); }

    @Benchmark public void testDynamic10_75_()              { testBig(10000, 10, 1, 0.75); }
    @Benchmark public void testDynamic10_75_Gets100th()     { findAll(quadDyn10_75, 1000.0, 100.0); }
    @Benchmark public void testDynamic10_75_Gets16th()      { findAll(quadDyn10_75, 1000.0, 250.0); }
    @Benchmark public void testDynamic10_75_Gets4th()       { findAll(quadDyn10_75, 1000.0, 500.0); }
    @Benchmark public void testDynamic10_75_Replace()       { replace(coordDyn10_75, 1000000, 10.0); }


    private static QuadTree<Integer> quadStat1000_10 = testBig(1000000, 10, 0, 0.5);
    private static CoordHolder coordStat1000_10 = quadStat1000_10.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadStat100_10 = testBig(100000, 10, 0, 0.5);
    private static CoordHolder coordStat100_10 = quadStat100_10.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadStat10_10 = testBig(10000, 10, 0, 0.5);
    private static CoordHolder coordStat10_10 = quadStat10_10.findAll(0.0,0.0, 500.0,500.0).get(0);


    @Benchmark public void testStatic1000_10_()            { testBig(1000000, 10, 0, 0.333333); }
    @Benchmark public void testStatic1000_10_Gets100th()   { findAll(quadStat1000_10, 1000.0, 100.0); }
    @Benchmark public void testStatic1000_10_Gets16th()    { findAll(quadStat1000_10, 1000.0, 250.0); }
    @Benchmark public void testStatic1000_10_Gets4th()     { findAll(quadStat1000_10, 1000.0, 500.0); }
    @Benchmark public void testStatic1000_10_Replace()     { replace(coordStat1000_10, 1000000, 10.0); }

    @Benchmark public void testStatic100_10_()             { testBig(100000, 10, 0, 0.333333); }
    @Benchmark public void testStatic100_10_Gets100th()    { findAll(quadStat100_10, 1000.0, 100.0); }
    @Benchmark public void testStatic100_10_Gets4th()      { findAll(quadStat100_10, 1000.0, 500.0); }
    @Benchmark public void testStatic100_10_Gets16th()     { findAll(quadStat100_10, 1000.0, 250.0); }
    @Benchmark public void testStatic100_10_Replace()      { replace(coordStat100_10, 1000000, 10.0); }

    @Benchmark public void testStatic10_10_()              { testBig(10000, 10, 0, 0.333333); }
    @Benchmark public void testStatic10_10_Gets100th()     { findAll(quadStat10_10, 1000.0, 100.0); }
    @Benchmark public void testStatic10_10_Gets4th()       { findAll(quadStat10_10, 1000.0, 500.0); }
    @Benchmark public void testStatic10_10_Gets16th()      { findAll(quadStat10_10, 1000.0, 250.0); }
    @Benchmark public void testStatic10_10_Replace()       { replace(coordStat10_10, 1000000, 10.0); }


    private static QuadTree<Integer> quadStat1000_100 = testBig(1000000, 100, 0, 0.5);
    private static CoordHolder coordStat1000_100 = quadStat1000_100.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadStat100_100 = testBig(100000, 100, 0, 0.5);
    private static CoordHolder coordStat100_100 = quadStat100_100.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> quadStat10_100 = testBig(10000, 100, 0, 0.5);
    private static CoordHolder coordStat10_100 = quadStat10_100.findAll(0.0,0.0, 500.0,500.0).get(0);

    @Benchmark public void testStatic1000_100_()            { testBig(1000000, 100, 0, 0.333333); }
    @Benchmark public void testStatic1000_100_Gets100th()   { findAll(quadStat1000_100, 1000.0, 100.0); }
    @Benchmark public void testStatic1000_100_Gets16th()    { findAll(quadStat1000_100, 1000.0, 250.0); }
    @Benchmark public void testStatic1000_100_Gets4th()     { findAll(quadStat1000_100, 1000.0, 500.0); }
    @Benchmark public void testStatic1000_100_Replace()     { replace(coordStat1000_100, 1000000, 10.0); }

    @Benchmark public void testStatic100_100_()             { testBig(100000, 100, 0, 0.333333); }
    @Benchmark public void testStatic100_100_Gets100th()    { findAll(quadStat100_100, 1000.0, 100.0); }
    @Benchmark public void testStatic100_100_Gets16th()     { findAll(quadStat100_100, 1000.0, 250.0); }
    @Benchmark public void testStatic100_100_Gets4th()      { findAll(quadStat100_100, 1000.0, 500.0); }
    @Benchmark public void testStatic100_100_Replace()      { replace(coordStat100_100, 1000000, 10.0); }

    @Benchmark public void testStatic10_100_()              { testBig(10000, 100, 0, 0.333333); }
    @Benchmark public void testStatic10_100_Gets100th()     { findAll(quadStat10_100, 1000.0, 100.0); }
    @Benchmark public void testStatic10_100_Gets16th()      { findAll(quadStat10_100, 1000.0, 250.0); }
    @Benchmark public void testStatic10_100_Gets4th()       { findAll(quadStat10_100, 1000.0, 500.0); }
    @Benchmark public void testStatic10_100_Replace()       { replace(coordStat10_100, 1000000, 10.0); }



    public static QuadTree<Integer> testBig(int nItems, int MAX, int DYNAMIC, double BUCKET_EXP)
    {
        QuadTree<Integer> q = new QuadTree<>();
        q.LEAF_MAX_OBJECTS = MAX;
        if (DYNAMIC > 0)
            q.DYNAMIC_MAX_OBJECTS = true;
        q.MAX_OBJ_TARGET_EXPONENT = BUCKET_EXP;

        for(int i = 0; i < nItems; i++)
        {
            q.place(Math.round(Math.random()*1000), Math.round(Math.random()*1000), i);
        }
        return q;
    }

    private void findAll(QuadTree<Integer> quad, double w, double part) {
        double
                x0 = Math.random() * w - part / 2,
                y0 = Math.random() * w - part / 2
                ;
        quad.findAll(x0, y0, x0 + part, y0 + part);
    }

    public void replace(CoordHolder coord, int n, double replace) {
        for(int i = 0; i < n; i++)
        {
            double
                    x0 = Math.random() * replace - replace / 2,
                    y0 = Math.random() * replace - replace / 2
                    ;
            coord.x += x0;
            coord.y += y0;
            coord.replace();
        }
    }
}
