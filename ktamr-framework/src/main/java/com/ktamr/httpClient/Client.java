package com.ktamr.httpClient;

import com.ktamr.common.utils.StringUtils;
import com.ktamr.service.HaConfigService;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 发送参数到服务器端
 * @author ktamr
 */
public class Client {

    @Autowired
    private HaConfigService haConfigService;

    public boolean httpClient(String cmd, String params) {
        String port = haConfigService.selectPort("ht_client_server","listenport");
        String str = getClientStr(cmd)+params;
        String url = "http://localhost:"+port;
        return getClient(str,url);
    }

    public boolean httpClient(String cmdId) {
        String port = haConfigService.selectPort("系统参数","InterListenPort");
        String str = getClientStr("data_upload")+cmdId;
        String url = "http://localhost:"+port;
        return getClient(str,url);
    }

    private boolean getClient(String str,String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String result = "";
        String charset = "gbk";
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity stringEntity = new StringEntity(str,charset);
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                if(response != null){
                    HttpEntity resEntity = response.getEntity();
                    if(resEntity != null){
                        result = EntityUtils.toString(resEntity,charset);
                    }
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getResult(result);
    }

    private String getClientStr(String cmd){
        String str = "0000000009";
        return str+cmd+":";
    }

    private boolean getResult(String result){
        if(StringUtils.isEmpty(result)){
            return "0000000002ok".equals(result)?true:false;
        }else {
            return false;
        }
    }
}
