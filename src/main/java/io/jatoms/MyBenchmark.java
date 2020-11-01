package io.jatoms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

import org.eclipse.collections.api.map.primitive.IntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;


@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(2)
public class MyBenchmark {

    @Param({"1000", "10000", "100000", "1000000"})
    public int size;

    private HashMap<Integer, String> jm;
    private ConcurrentHashMap<Integer, String> cjm1;
    private ConcurrentSkipListMap<Integer, String> cjm2;
    private IntObjectHashMap<String> ec;

    @Setup
    public void setUp(){
        jm = new HashMap<>();
        cjm1 = new ConcurrentHashMap<>();
        cjm2 = new ConcurrentSkipListMap<>();
        ec = new IntObjectHashMap<>();
        for (int i = 0; i < size; i++) {
            jm.put(i, "String" + i);
            cjm1.put(i, "String" + i);
            cjm2.put(i, "String" + i);
            ec.put(i, "String" + i);
        }
    }

    // @Benchmark
    // public IntObjectMap<String> ecPutWithPrimitives(){
    //     IntObjectHashMap<String> ec = new IntObjectHashMap<>();
    //     for (int i = 0; i < size; i++) {
    //         ec.put(i, "Test" + i);
    //     }
    //     return ec;
    // }

    // @Benchmark
    // public String ecGet(){
    //     String result = null;
    //     for (int i = 0; i < size; i++) {
    //         result = ec.get(i);
    //     }
    //     return result;
    // }

    @Benchmark
    public Map<Integer, String> jdkPut() {
        Map<Integer, String> jm = new HashMap<>();
        for (int i = 0; i < size; i++) {
            jm.put(i, "Test" + i);
        }
        return jm;
    }

    @Benchmark
    public String jdkGet(){
        String result = null;
        for (int i = 0; i < size; i++) {
            result = jm.get(i);
        }
        return result;
    }

    @Benchmark
    public Map<Integer, String> jdkCPut1() {
        ConcurrentHashMap<Integer, String> cjm1 = new ConcurrentHashMap<>();
        for (int i = 0; i < size; i++) {
            cjm1.put(i, "Test" + i);
        }
        return jm;
    }

    @Benchmark
    public String jdkCGet1(){
        String result = null;
        for (int i = 0; i < size; i++) {
            result = cjm1.get(i);
        }
        return result;
    }

    @Benchmark
    public Map<Integer, String> jdkCPut2() {
        ConcurrentSkipListMap<Integer, String> cjm2 = new ConcurrentSkipListMap<>();
        for (int i = 0; i < size; i++) {
            cjm2.put(i, "Test" + i);
        }
        return jm;
    }

    @Benchmark
    public String jdkCGet2(){
        String result = null;
        for (int i = 0; i < size; i++) {
            result = cjm2.get(i);
        }
        return result;
    }

}
