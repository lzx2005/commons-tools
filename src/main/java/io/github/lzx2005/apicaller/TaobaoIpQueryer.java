package io.github.lzx2005.apicaller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * 根据IP查询相关信息（淘宝接口）
 * Created by hzlizx on 2018/4/27 0027
 */
public class TaobaoIpQueryer {
    private static final Logger logger = LoggerFactory.getLogger(TaobaoIpQueryer.class);
    private static final String TAOBAO_HOST ="http://ip.taobao.com/service/getIpInfo.php?ip=";

    public JSONObject getIpInfo(String ip) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(TAOBAO_HOST + ip);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity);
            logger.debug(body);
            return JSONObject.parseObject(body);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("request api error", e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                logger.error("closing client error", e);
            }
        }
        return null;
    }
}
