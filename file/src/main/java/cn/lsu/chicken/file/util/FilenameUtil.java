package cn.lsu.chicken.file.util;

public class FilenameUtil {
    public static String getSuffix(String filename) {
        return filename.substring(filename.lastIndexOf('.'));
    }
}
