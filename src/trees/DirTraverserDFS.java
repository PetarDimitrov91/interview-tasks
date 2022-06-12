package trees;

import java.io.File;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DirTraverserDFS {
    static AtomicInteger filesCount = new AtomicInteger(0);
    static AtomicInteger dirCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        String[] drives = new String[]{"C:\\", "D:\\", "E:\\"};
        ExecutorService executor = Executors.newFixedThreadPool(8);

        Arrays.stream(drives).parallel().forEach(drive -> executor.execute(() -> traverseDir(drive)));

        executor.shutdown();
        executor.awaitTermination(100000000, TimeUnit.MINUTES);
        long endTime = System.currentTimeMillis();

        System.out.println("Time needed: " + (endTime - startTime));
        System.out.println(filesCount.get());
        System.out.println(dirCount.get());
    }

    /**
     * Traverses and prints given directory recursively.
     *
     * @param dir    - the directory to be traversed.
     * @param spaces - the spaces used for representation
     *               of the parent-child relation.
     */
    private static void traverseDir(File dir, String spaces) {
        if (dir.isDirectory()) {
            dirCount.incrementAndGet();
            System.out.println(spaces + dir.getAbsolutePath());
            String[] children = dir.list();

            if (children != null) {
                for (String child : children) {
                    traverseDir(new File(dir, child), spaces + "    ");
                }
            }
        } else if (dir.isFile()) {
            filesCount.incrementAndGet();
            System.out.println(spaces + "       " + dir.getAbsolutePath());
        }
    }

    /**
     * Traverses and prints given directory recursively.
     *
     * @param directoryPath - the path to the directory which
     *                      should be traversed.
     */
    public static void traverseDir(String directoryPath) {
        traverseDir(new File(directoryPath), "");
    }
}
