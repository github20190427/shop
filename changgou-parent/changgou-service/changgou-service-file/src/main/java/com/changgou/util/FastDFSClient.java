package com.changgou.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class FastDFSClient {

    static{
        String filePath = new ClassPathResource("fdfs_client.conf").getPath();
        //加载tracker配置信息
        try {
            ClientGlobal.init(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static String[] upLoad(FastDFSFile file) throws IOException, MyException {

        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[1] = new NameValuePair(file.getName());
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(trackerServer,null);
        storageClient.upload_file(file.getContent(),file.getExt(),meta_list);
        return new String[1];
    }
}
