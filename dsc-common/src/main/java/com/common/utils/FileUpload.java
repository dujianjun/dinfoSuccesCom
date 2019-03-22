package com.common.utils;


import com.common.exception.CommonException;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;


public class FileUpload {

    private static Logger logger = Logger.getLogger(FileUpload.class);

    private String url;

    public FileUpload(String url) {
        this.url = url;
    }

    public String uploadFile(String filePath) throws CommonException {
        return uploadFile(new File(filePath));
    }


    @Deprecated
    public String uploadFile(File file) throws CommonException {
        try {
            Request request = Request.Post(url);
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("file", new FileBody(file));
            request.body(reqEntity);
            String response = request.execute().returnContent().asString();
            JSONObject object = JSONObject.fromObject(response);
            if (object.getBoolean("success")) {
                return "/"+object.getString("url");
            } else {
                throw new CommonException("system error!");
            }
        } catch (Exception ex) {
            logger.error("File Upload Failed", ex);
            throw new CommonException(ex.getMessage());
        }
    }


    // http://blog.csdn.net/fengyuzhengfan/article/details/39941851 [使用HttpClient批量上传文件]
    // http://www.mamicode.com/info-detail-513859.html [DefaultHttpClient is deprecated]
    public String uploadFile(MultipartFile file) throws CommonException {
        if(file==null || file.isEmpty()) {
            throw new CommonException("The input MultipartFile cannot be empty!");
        }

        try {
            String path = uploadFile(file.getInputStream(), file.getOriginalFilename());
            return path;
        } catch (IOException ex) {
            logger.error("File Upload Failed", ex);
            throw new CommonException(ex.getMessage());
        }
    }

    // https://www.cnblogs.com/lyxy/p/5629151.html [HttpClient中转上传文件]
    public String uploadFile(InputStream is, String baseName) throws CommonException {
        if(is==null) {
            throw new CommonException("The InputStream cannot be null!");
        }
        if(baseName==null || baseName.equals("")) {
            throw new CommonException("The input baseName cannot be empty!");
        }

        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            // 创建 HTTP POST 请求
            HttpPost httpPost = new HttpPost(url);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            // 设置请求的编码格式
            builder.setCharset(Charset.forName("UTF-8"));
            // 设置浏览器兼容模式
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

            builder.addBinaryBody("file", is, ContentType.MULTIPART_FORM_DATA, baseName);
            // 生成 HTTP POST 实体
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();

            String result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            JSONObject object = JSONObject.fromObject(result);
            EntityUtils.consume(responseEntity);
            httpResponse.close();

            if (object.getBoolean("success")) {
                return "/"+object.getString("url");
            } else {
                throw new CommonException("system error!");
            }
        } catch (Exception ex) {
            logger.error("File Upload Failed", ex);
            throw new CommonException(ex.getMessage());
        }
    }

    public static void downloadFile(String remoteFilePath, String localFilePath) {
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);
        try {
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection) urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        } catch (Exception e) {
            httpUrl.disconnect();
            logger.error(e.getMessage(), e);
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

}
