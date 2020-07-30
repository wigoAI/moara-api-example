package org.moara.api.example.rest;

import org.moara.common.util.ExceptionUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <pre>
 *  파 일 명 : RestCall.java
 *  설    명 :
 *
 *  작 성 자 : macle(김용수)
 *  작 성 일 : 2020.05
 *  버    전 : 1.0
 *  수정이력 :
 *  기타사항 :
 * </pre>
 *
 * @author Copyrights 2020 by ㈜ WIGO. All right reserved.
 */

public class RestCall {
    public static String call(String address, String value){

        try {
            URL url = new URL(address );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setUseCaches(false);
            if(value != null && value.length() >0) {
                OutputStream stream = conn.getOutputStream();
                stream.write(value.getBytes());
                stream.flush();
                stream.close();
            }
            String charSet = "UTF-8";
            StringBuilder message = new StringBuilder();
            BufferedReader br;

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), charSet));

                for (;;) {
                    String line = br.readLine();
                    if (line == null) break;
                    message.append('\n').append(line);
                }
                br.close();

            }else{
                throw new RuntimeException("http response fail: " + conn.getResponseCode());
            }

            return message.substring(1);
        }catch(Exception e){
            throw new RuntimeException(ExceptionUtil.getStackTrace(e));
        }
    }

}
