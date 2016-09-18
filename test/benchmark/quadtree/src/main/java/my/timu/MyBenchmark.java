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

import java.util.concurrent.TimeUnit;
import struct.quadtree.QuadTree.CoordHolder;
import struct.quadtree.QuadTree;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;


public class MyBenchmark {


/*
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

    
    
    private static QuadTree<Integer> wind_quadStat1000_100 = testBigWind(1000000, 100, 0, 0.5, 1.0);
    private static CoordHolder wind_coordStat1000_100 = wind_quadStat1000_100.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> wind_quadStat100_100 = testBigWind(100000, 100, 0, 0.5, 1.0);
    private static CoordHolder wind_coordStat100_100 = wind_quadStat100_100.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> wind_quadStat10_100 = testBigWind(10000, 100, 0, 0.5, 1.0);
    private static CoordHolder wind_coordStat10_100 = wind_quadStat10_100.findAll(0.0,0.0, 500.0,500.0).get(0);


    @Benchmark public void testWindStatic1000_100_()            { testBigWind(1000000, 100, 0, 0.333333, 1.0); }
    @Benchmark public void testWindStatic1000_100_Gets100th()   { findAll(wind_quadStat1000_100, 1000.0, 100.0); }
    @Benchmark public void testWindStatic1000_100_Gets16th()    { findAll(wind_quadStat1000_100, 1000.0, 250.0); }
    @Benchmark public void testWindStatic1000_100_Gets4th()     { findAll(wind_quadStat1000_100, 1000.0, 500.0); }
    @Benchmark public void testWindStatic1000_100_Replace()     { replace(wind_coordStat1000_100, 1000000, 10.0); }

    @Benchmark public void testWindStatic100_100_()             { testBigWind(100000, 100, 0, 0.333333, 1.0); }
    @Benchmark public void testWindStatic100_100_Gets100th()    { findAll(wind_quadStat100_100, 1000.0, 100.0); }
    @Benchmark public void testWindStatic100_100_Gets16th()     { findAll(wind_quadStat100_100, 1000.0, 250.0); }
    @Benchmark public void testWindStatic100_100_Gets4th()      { findAll(wind_quadStat100_100, 1000.0, 500.0); }
    @Benchmark public void testWindStatic100_100_Replace()      { replace(wind_coordStat100_100, 1000000, 10.0); }
    
    @Benchmark public void testWindStatic10_100_()              { testBigWind(10000, 100, 0, 0.333333, 1.0); }
    @Benchmark public void testWindStatic10_100_Gets100th()     { findAll(wind_quadStat10_100, 1000.0, 100.0); }
    @Benchmark public void testWindStatic10_100_Gets16th()      { findAll(wind_quadStat10_100, 1000.0, 250.0); }
    @Benchmark public void testWindStatic10_100_Gets4th()       { findAll(wind_quadStat10_100, 1000.0, 500.0); }
    @Benchmark public void testWindStatic10_100_Replace()       { replace(wind_coordStat10_100, 1000000, 10.0); }

    
    private static QuadTree<Integer> wind_quadDyn1000_05 = testBigWind(1000000, 10, 1, 0.5, 1.0);
    private static CoordHolder wind_coordDyn1000_05 = wind_quadDyn1000_05.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> wind_quadDyn100_05 = testBigWind(100000, 10, 1, 0.5, 1.0);
    private static CoordHolder wind_coordDyn100_05 = wind_quadDyn100_05.findAll(0.0,0.0, 500.0,500.0).get(0);
    private static QuadTree<Integer> wind_quadDyn10_05 = testBigWind(10000, 10, 1, 0.5, 1.0);
    private static CoordHolder wind_coordDyn10_05 = wind_quadDyn10_05.findAll(0.0,0.0, 500.0,500.0).get(0);


    @Benchmark public void testWindDyn1000_05_()            { testBigWind(1000000, 10, 1, 0.5, 1.0); }
    @Benchmark public void testWindDyn1000_05_Gets100th()   { findAll(wind_quadDyn1000_05, 1000.0, 100.0); }
    @Benchmark public void testWindDyn1000_05_Gets16th()    { findAll(wind_quadDyn1000_05, 1000.0, 250.0); }
    @Benchmark public void testWindDyn1000_05_Gets4th()     { findAll(wind_quadDyn1000_05, 1000.0, 500.0); }
    @Benchmark public void testWindDyn1000_05_Replace()     { replace(wind_coordDyn1000_05, 1000000, 10.0); }


    @Benchmark public void testWindDyn100_05_()             { testBigWind(100000, 10, 1, 0.5, 1.0); }
    @Benchmark public void testWindDyn100_05_Gets100th()    { findAll(wind_quadDyn100_05, 1000.0, 100.0); }
    @Benchmark public void testWindDyn100_05_Gets16th()     { findAll(wind_quadDyn100_05, 1000.0, 250.0); }
    @Benchmark public void testWindDyn100_05_Gets4th()      { findAll(wind_quadDyn100_05, 1000.0, 500.0); }
    @Benchmark public void testWindDyn100_05_Replace()      { replace(wind_coordDyn100_05, 1000000, 10.0); }
    
    @Benchmark public void testWindDyn10_05_()              { testBigWind(10000, 10, 1, 0.5, 1.0); }
    @Benchmark public void testWindDyn10_05_Gets100th()     { findAll(wind_quadDyn10_05, 1000.0, 100.0); }
    @Benchmark public void testWindDyn10_05_Gets16th()      { findAll(wind_quadDyn10_05, 1000.0, 250.0); }
    @Benchmark public void testWindDyn10_05_Gets4th()       { findAll(wind_quadDyn10_05, 1000.0, 500.0); }
    @Benchmark public void testWindDyn10_05_Replace()       { replace(wind_coordDyn10_05, 1000000, 10.0); }
*/
    
/*
    static QuadTree<Integer> g035LL = testBig(1000000, 10, 1, 0.35, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g035AL = testBig(1000000, 10, 1, 0.35, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g037LL = testBig(1000000, 10, 1, 0.375, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g037AL = testBig(1000000, 10, 1, 0.375, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g040LL = testBig(1000000, 10, 1, 0.4, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g040AL = testBig(1000000, 10, 1, 0.4, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g042LL = testBig(1000000, 10, 1, 0.425, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g042AL = testBig(1000000, 10, 1, 0.425, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g045LL = testBig(1000000, 10, 1, 0.45, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g045AL = testBig(1000000, 10, 1, 0.45, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g047LL = testBig(1000000, 10, 1, 0.475, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g047AL = testBig(1000000, 10, 1, 0.475, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g050LL = testBig(1000000, 10, 1, 0.50, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g050AL = testBig(1000000, 10, 1, 0.50, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g052LL = testBig(1000000, 10, 1, 0.525, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g052AL = testBig(1000000, 10, 1, 0.525, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g055LL = testBig(1000000, 10, 1, 0.55, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g055AL = testBig(1000000, 10, 1, 0.55, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g057LL = testBig(1000000, 10, 1, 0.575, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g057AL = testBig(1000000, 10, 1, 0.575, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g060LL = testBig(1000000, 10, 1, 0.60, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g060AL = testBig(1000000, 10, 1, 0.60, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g062LL = testBig(1000000, 10, 1, 0.625, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g062AL = testBig(1000000, 10, 1, 0.625, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g065LL = testBig(1000000, 10, 1, 0.65, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g065AL = testBig(1000000, 10, 1, 0.65, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g067LL = testBig(1000000, 10, 1, 0.675, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g067AL = testBig(1000000, 10, 1, 0.675, QuadTree.LP_ARRAYLIST);
    static QuadTree<Integer> g070LL = testBig(1000000, 10, 1, 0.70, QuadTree.LP_LINKEDLIST);
    static QuadTree<Integer> g070AL = testBig(1000000, 10, 1, 0.70, QuadTree.LP_ARRAYLIST);
*/

/*
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_035_LL_100th() { findAll(g035LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_035_AL_100th() { findAll(g035AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_037_LL_100th() { findAll(g037LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_037_AL_100th() { findAll(g037AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_040_LL_100th() { findAll(g040LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_040_AL_100th() { findAll(g040AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_042_LL_100th() { findAll(g042LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_042_AL_100th() { findAll(g042AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_045_LL_100th() { findAll(g045LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_045_AL_100th() { findAll(g045AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_047_LL_100th() { findAll(g047LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_047_AL_100th() { findAll(g047AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_050_LL_100th() { findAll(g050LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_050_AL_100th() { findAll(g050AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_052_LL_100th() { findAll(g052LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_052_AL_100th() { findAll(g052AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_055_LL_100th() { findAll(g055LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_055_AL_100th() { findAll(g055AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_057_LL_100th() { findAll(g057LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_057_AL_100th() { findAll(g057AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_060_LL_100th() { findAll(g060LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_060_AL_100th() { findAll(g060AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_062_LL_100th() { findAll(g062LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_062_AL_100th() { findAll(g062AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_065_LL_100th() { findAll(g065LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_065_AL_100th() { findAll(g065AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_067_LL_100th() { findAll(g067LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_067_AL_100th() { findAll(g067AL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_070_LL_100th() { findAll(g070LL, 1000.0, 100.0); }
    @Benchmark @Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 500) @Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 500) public void grad1000_070_AL_100th() { findAll(g070AL, 1000.0, 100.0); }
*/
    
    public static QuadTree<Integer> testBig(int nItems, int MAX, int DYNAMIC, double BUCKET_EXP)
    {
        return testBig(nItems, MAX, DYNAMIC, BUCKET_EXP, QuadTree.LP_LINKEDLIST);
    }
    public static QuadTree<Integer> testBig(int nItems, int MAX, int DYNAMIC, double BUCKET_EXP, QuadTree.ListProvider LP)
    {
        return testBigWind(nItems, MAX, DYNAMIC, BUCKET_EXP, 0.0);
    }    
    public static QuadTree<Integer> testBigWind(int nItems, int MAX, int DYNAMIC, double BUCKET_EXP, double windowShift)
    {
        return testBigWind(nItems, MAX, DYNAMIC, BUCKET_EXP, windowShift, QuadTree.LP_LINKEDLIST);
    }
    public static QuadTree<Integer> testBigWind(int nItems, int MAX, int DYNAMIC, double BUCKET_EXP, double windowShift, QuadTree.ListProvider LP)
    {
        QuadTree<Integer> q = new QuadTree<>();
        if (LP != null) q.LIST_PROVIDER = LP;
        q.LEAF_MAX_OBJECTS = MAX;
        if (DYNAMIC > 0)
            q.DYNAMIC_MAX_OBJECTS = true;
        q.MAX_OBJ_TARGET_EXPONENT = BUCKET_EXP;

        for(int i = 0; i < nItems; i++)
        {
            q.place(Math.round(Math.random()*1000) + (windowShift * i / (double)nItems),
                    Math.round(Math.random()*1000), i);
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
