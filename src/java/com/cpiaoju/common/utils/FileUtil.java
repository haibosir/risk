package com.cpiaoju.common.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {
    public static String ZIP_FILE = "";
    public static void zipFileBuffer() {
        File zipFile = new File("out.zip");
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOut)) {
            //开始时间
             long beginTime = System.currentTimeMillis();
             for (int i = 0; i < 10; i++) {
                 try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("name"))) {
                     zipOut.putNextEntry(new ZipEntry("name" + i));
                     int temp = 0;
                     while ((temp = bufferedInputStream.read()) != -1) {
                         bufferedOutputStream.write(temp);
                     }
                 }
             }
            System.out.println(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void zipFileChannel() {
        //开始时间
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 10; i++) {
                try (FileChannel fileChannel = new FileInputStream("JPG_FILE").getChannel()) {
                    zipOut.putNextEntry(new ZipEntry(i + "SUFFIX_FILE"));
                    fileChannel.transferTo(0, 1024, writableByteChannel);
                }
            }
            System.out.println(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Version 4 使用Map映射文件
    public static void zipFileMap() {
        //开始时间
        long beginTime =System.currentTimeMillis();

        File zipFile = new File(ZIP_FILE);
        try(ZipOutputStream zipOut =new ZipOutputStream(new FileOutputStream(zipFile));
            WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for(int i = 0; i < 10; i++) {
                zipOut.putNextEntry(new ZipEntry (i + "SUFFIX_FILE"));
                //内存中的映射文件
                MappedByteBuffer  mappedByteBuffer =
                        new RandomAccessFile("JPG_FILE_PATH","r").getChannel().map(FileChannel.MapMode.READ_ONLY,0, 1024);
                writableByteChannel.write(mappedByteBuffer);
            }
            System.out.println(beginTime);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    //Version 5 使用Pip
    public static void zipFilePip() {
        long beginTime =System .currentTimeMillis();
        try ( WritableByteChannel out  = Channels .newChannel( new FileOutputStream (ZIP_FILE))) {
            Pipe  pipe = Pipe.open();
            //异步任务
            CompletableFuture.runAsync(()->runTask(pipe));
            //获取读通道
            ReadableByteChannel readableByteChannel = pipe.source();
            ByteBuffer buffer = ByteBuffer .allocate((1024)*10);
            while (readableByteChannel.read(buffer)>=0) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(beginTime);
    }

    //异步任务
    public static void runTask(Pipe pipe) {
         try(ZipOutputStream zos = new ZipOutputStream (Channels .newOutputStream(pipe.sink()));
             WritableByteChannel out = Channels .newChannel(zos)) {
            System.out.println();
            for(int i = 0 ; i <  10 ; i++) {
                zos.putNextEntry(new ZipEntry (i+"SUFFIX_FILE"));
                FileChannel jpgChannel = new FileInputStream ( new File ("JPG_FILE_PATH")).getChannel();
                jpgChannel.transferTo(0, 1024, out);
                jpgChannel.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
