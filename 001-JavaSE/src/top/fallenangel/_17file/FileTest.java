package top.fallenangel._17file;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class FileTest {
    private static final ArrayList<File> files = new ArrayList<>();

    public static void main(String[] args) {
        @SuppressWarnings("SpellCheckingInspection") File file = new File("F:/ppsspp");
        for (File f : listDir(file)) {
            System.out.println(f);
        }
    }

    private static File[] listDir(File file) {
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                if (f.isDirectory()) {
                    files.add(f);
                }
                listDir(f);
            }
        } else {
            files.add(file);
        }

        files.sort(Comparator.comparing(File::isFile).thenComparing(File::getPath));

        /*files.sort(Comparator.comparing(new Function<File, Boolean>() {
            @Override
            public Boolean apply(File file) {
                return file.isFile();
            }
        }).thenComparing(new Function<File, String>() {
            @Override
            public String apply(File file) {
                return file.getPath();
            }
        }));*/

        /*Collections.sort(files, Comparator.comparing(new Function<File, Boolean>() {
            @Override
            public Boolean apply(File file) {
                return file.isFile();
            }
        }).thenComparing(new Function<File, String>() {
            @Override
            public String apply(File file) {
                return file.getPath();
            }
        }));*/

        /*files.sort((f1, f2) -> f1.isDirectory() == f2.isDirectory() ? f1.compareTo(f2) : f1.isDirectory() ? -1 : 1);*/

        /*files.sort(new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if (f1.isDirectory() == f2.isDirectory()) {
                    return f1.compareTo(f2);
                } else {
                    return f1.isDirectory() ? -1 : 1;
                }
            }
        });*/

        /*Collections.sort(files, (f1, f2) -> f1.isDirectory() == f2.isDirectory() ? f1.compareTo(f2) : f1.isDirectory() ? -1 : 1);*/

        return files.toArray(new File[0]);
    }
}