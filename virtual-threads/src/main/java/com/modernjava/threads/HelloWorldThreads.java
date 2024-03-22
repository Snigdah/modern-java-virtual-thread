package com.modernjava.threads;


import static com.modernjava.util.CommonUtil.sleep;
import static com.modernjava.util.LoggerUtil.log;

public class HelloWorldThreads {
    private static String result="";

    private static void hello(){
        sleep(500);
        result = result.concat("Hello");

    }
    private static void world(){
        sleep(600);
        result = result.concat("World");
    }

    public static void main(String[] args) throws InterruptedException {

        // We would like to get the output as "HelloWorld"

        var thread1 = Thread.ofPlatform().name("t1")
                .unstarted(()-> HelloWorldThreads.hello());


        var thread2 = Thread.ofPlatform().name("t2")
                .unstarted(() -> HelloWorldThreads.world());

        // join
        // This is going to wait and block the main thread until both of these thread complete their tasks in this case
        thread1.join();
        thread2.join();

        log("Complete task");
        sleep(3000);

    }
}
