package trees;

import java.io.File;

public class DirTraverserDFS {
    static int filesCount = 0;
    static int dirCount = 0;

    public static void main(String[] args) {
        String[] drives = new String[]{"D:\\", "E:\\"};

        for (String drive : drives) {
            traverseDir(drive);
        }

        System.out.println(filesCount);
        System.out.println(dirCount);
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
            dirCount++;
            System.out.println(spaces + dir.getAbsolutePath());
            String[] children = dir.list();

            if (children != null) {
                for (String child : children) {
                    traverseDir(new File(dir, child), spaces + "    ");
                }
            }
        } else if (dir.isFile()) {
            filesCount++;
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
