# ec-vs-jc
Simple benchmarks to compare Eclipse Collections and JDK Collections

## Setup
* mvn clean install
* java -jar target/benchmarks.jar

## Some benchmark results
### HashMap (jdk) vs. ConcurrentHashMap (jdkc1) vs. ConcurrentSkipListMap (jdkc2)
Benchmark              (size)   Mode  Cnt       Score       Error  Units
MyBenchmark.jdkCGet1     1000  thrpt   10  118586.503 ± 10301.327  ops/s
MyBenchmark.jdkCGet1    10000  thrpt   10    8329.862 ±   967.381  ops/s
MyBenchmark.jdkCGet1   100000  thrpt   10     937.530 ±    26.517  ops/s
MyBenchmark.jdkCGet1  1000000  thrpt   10      36.441 ±     0.678  ops/s
MyBenchmark.jdkCGet2     1000  thrpt   10   10082.473 ±  1411.593  ops/s
MyBenchmark.jdkCGet2    10000  thrpt   10     866.681 ±    57.870  ops/s
MyBenchmark.jdkCGet2   100000  thrpt   10      62.943 ±     9.598  ops/s
MyBenchmark.jdkCGet2  1000000  thrpt   10       5.768 ±     0.083  ops/s
MyBenchmark.jdkCPut1     1000  thrpt   10    9029.338 ±   520.126  ops/s
MyBenchmark.jdkCPut1    10000  thrpt   10     969.529 ±    77.941  ops/s
MyBenchmark.jdkCPut1   100000  thrpt   10      37.732 ±     1.554  ops/s
MyBenchmark.jdkCPut1  1000000  thrpt   10       2.772 ±     0.236  ops/s
MyBenchmark.jdkCPut2     1000  thrpt   10    6196.972 ±   265.754  ops/s
MyBenchmark.jdkCPut2    10000  thrpt   10     564.161 ±    34.118  ops/s
MyBenchmark.jdkCPut2   100000  thrpt   10      47.408 ±     3.552  ops/s
MyBenchmark.jdkCPut2  1000000  thrpt   10       4.155 ±     0.281  ops/s
MyBenchmark.jdkGet       1000  thrpt   10  117530.951 ± 10420.216  ops/s
MyBenchmark.jdkGet      10000  thrpt   10    7939.512 ±   926.446  ops/s
MyBenchmark.jdkGet     100000  thrpt   10     952.401 ±    17.250  ops/s
MyBenchmark.jdkGet    1000000  thrpt   10      36.947 ±     1.421  ops/s
MyBenchmark.jdkPut       1000  thrpt   10   15730.108 ±  2421.404  ops/s
MyBenchmark.jdkPut      10000  thrpt   10    1528.995 ±   146.028  ops/s
MyBenchmark.jdkPut     100000  thrpt   10      57.113 ±     3.179  ops/s
MyBenchmark.jdkPut    1000000  thrpt   10       3.401 ±     0.431  ops/s