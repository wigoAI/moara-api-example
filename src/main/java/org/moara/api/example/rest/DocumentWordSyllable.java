/*
 * Copyright (C) 2020 Wigo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.moara.api.example.rest;

import org.json.JSONObject;
import org.moara.ara.datamining.textmining.api.document.DocumentStandardKey;
import org.moara.common.util.ExceptionUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 음절추출
 * @author macle
 */
public class DocumentWordSyllable {

    public static String call(String address, String jsonValue){

        try {
            URL url = new URL(address + "/document/word/syllable");
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

            OutputStream stream = conn.getOutputStream();
            stream.write(jsonValue.getBytes());
            stream.flush();
            stream.close();

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

    public static void main(String[] args) {
        JSONObject messageObj = new JSONObject();
        //제목이 있을경우
//        messageObj.put(DocumentStandardKey.TITLE.key() , " 제목 ");
        //문서유형 설정 default SNS
//       messageObj.put(DocumentStandardKey.DOC_TYPE.key(), Document.SNS);
        //언어유형 설정 default KO
//       messageObj.put(DocumentStandardKey.LANG_CODE.key(), LangCode.KO);

        //본문
        messageObj.put(DocumentStandardKey.CONTENTS.key() , "지난 19대 총선 당시 한국당은 ‘이주노동자와 다문화 가정을 대변할 수 있는 인재를 영입하겠다’며 이 전 의원을 전격 영입했다. 이후 비례대표로 19대 국회에서 당 가정폭력대책분과 위원장 등을 맡으며 이주여성 보호 법안 등을 발의하는 등 활발히 활동했지만, 19대 국회 이후 당이 이 전 의원을 공천하지 않기로 하면서 당내에서 별다른 활동을 하지 못했다.");

        String receiveMessage = call("hostAddress", messageObj.toString());

        System.out.println(receiveMessage);


    }
}
