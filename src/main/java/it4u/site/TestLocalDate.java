package it4u.site;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 无多线程安全问题
 */
public class TestLocalDate {

    public static void main(String[] args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = () -> LocalDate.parse("20161218", dtf);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(task));
        }
        for (Future<LocalDate> future : futures) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
