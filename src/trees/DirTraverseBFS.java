package trees;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class DirTraverseBFS {
    public static void main(String[] args) {
        traverseDir("C:\\");
    }

    private static void traverseDir(String startDir) {
        Queue<File> visitedDirsQueue = new LinkedList<>();
        visitedDirsQueue.add(new File(startDir));
        while (!visitedDirsQueue.isEmpty()) {
            File crrDir = visitedDirsQueue.remove();
            System.out.println(crrDir.getAbsolutePath());
            File[] children = crrDir.listFiles();

            if (children != null) {
                for (File child : children) {
                    if (child.isDirectory()) {
                        visitedDirsQueue.add(child);
                    }
                }
            }
        }
    }
}
