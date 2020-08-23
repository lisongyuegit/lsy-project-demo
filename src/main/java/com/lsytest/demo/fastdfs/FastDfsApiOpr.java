//package com.lsytest.demo.fastdfs;
//
//import org.csource.fastdfs.*;
//
///**
// * @author: lisongyue@edenep.net
// * @company: Eden Technology
// * @motto: 代码也可以是一种艺术
// * @version: 1.0
// * @date: 2019/10/9 21:05
// */
//public class FastDfsApiOpr {
//
//    public static String CONF_FILENAME  = FastDfsApiOpr.class.getClassLoader().getResource("fast_client.conf").getFile();
//
//    /**
//     * 上传文件
//     */
//    public static  String upload(String path,String extName) {
//        try {
//            ClientGlobal.init(CONF_FILENAME);
//            TrackerClient tracker = new TrackerClient();
//            TrackerServer trackerServer = tracker.getConnection();
//            StorageServer storageServer = null;
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//            String fileIds[] = storageClient.upload_file(path, extName,null);
//            System.out.println(fileIds.length);
//            System.out.println("组名：" + fileIds[0]);
//            System.out.println("路径: " + fileIds[1]);
//            return  "/"+fileIds[0]+"/"+fileIds[1];
//        } catch (Exception e) {
//            e.printStackTrace();
//            return  null;
//        }
//    }
//
//    /**
//     * 下载文件
//     */
//    public static byte[] download(String groupName,String fileName) {
//        try {
//            ClientGlobal.init(CONF_FILENAME);
//            TrackerClient tracker = new TrackerClient();
//            TrackerServer trackerServer = tracker.getConnection();
//            StorageServer storageServer = null;
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//            byte[] b = storageClient.download_file(groupName, fileName);
//            return  b;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return  null;
//        }
//    }
//
//    /**
//     * 删除文件
//     */
//    public static void delete(String groupName,String fileName){
//        try {
//            ClientGlobal.init(CONF_FILENAME);
//            TrackerClient tracker = new TrackerClient();
//            TrackerServer trackerServer = tracker.getConnection();
//            StorageServer storageServer = null;
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//            int i = storageClient.delete_file(groupName,fileName);
//            System.out.println( i==0 ? "删除成功" : "删除失败:"+i);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw  new RuntimeException("删除异常,"+e.getMessage());
//        }
//    }
//    public static void main(String[] args) throws Exception {
//        // 1、 加载配置文件， 配置文件中的内容就是 tracker 服务的地址。
//        ClientGlobal.init("F:\\coding\\helloFastDFS\\src\\main\\resources\\fdfs_client.conf");
//        // 2、 创建一个 TrackerClient 对象。 直接 new 一个。
//        TrackerClient trackerClient=new TrackerClient();
//        // 3、 使用 TrackerClient 对象创建连接， 获得一个 TrackerServer 对象。
//        TrackerServer trackerServer = trackerClient.getConnection();
//        // 4、 创建一个 StorageServer 的引用， 值为 null
//        StorageServer storageServer=null;
//        // 5、 创建一个 StorageClient 对象， 需要两个参数 TrackerServer 对象、 StorageServer的引用
//        StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
//        // 6、 使用 StorageClient 对象上传图片。
//        String[] strings = storageClient1.upload_appender_file("F:\\image\\01.jpg","jpg", null);
//        // 7、 返回数组。 包含组名和图片的路径。
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }
//}
