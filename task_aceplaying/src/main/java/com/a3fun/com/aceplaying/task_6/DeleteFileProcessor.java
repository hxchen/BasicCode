package com.a3fun.com.aceplaying.task_6;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author haixiangchen
 */
public class DeleteFileProcessor {
    /**
     *
     * @param localDate 指定日期
     * @param path 文件目录
     * @return 返回已经删除的文件列表
     */
    public List<Path> deleteFile(LocalDate localDate, Path path){
        // TODO
        List<Path> files = new ArrayList<>();
        File file = path.toFile();
        File[] fs = file.listFiles();
        assert fs != null;
        for(File f:fs){
            if(f.isDirectory()){
                deleteFile(localDate, f.toPath());
                if (Objects.requireNonNull(f.listFiles()).length == 0){
                    f.delete();
                }
            }

            if(f.isFile()){
                String name = f.getName();
                if (name.contains("_")){
                    name = name.substring(name.length() - 14).replace(".log","");
                    System.out.println(name);
                    LocalDate fileDate = LocalDate.parse(name, DateTimeFormatter.ofPattern("yyyy_MM_dd"));
                    long duration = ChronoUnit.DAYS.between(fileDate, localDate);
                    if (duration > 30){
                        f.delete();
                        files.add(f.toPath());
                    }
                    System.out.println(duration);
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        DeleteFileProcessor deleteFileProcessor = new DeleteFileProcessor();
        LocalDate localDate = LocalDate.of(2021, 1, 11);
        Path path = Paths.get("/Users/haixiangchen/Desktop/IdeaProjects/hxchen/BasicCode/task_aceplaying/src/main/resources/logs");
        deleteFileProcessor.deleteFile(localDate, path);
    }
}
