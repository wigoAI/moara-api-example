package org.moara.api.example.rest;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * <pre>
 *  파 일 명 : VocabTokenize.java
 *  설    명 : 보케블러리 예제관련 소스
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

public class VocabTokenize {


    public static void main(String[] args) {

        String receiveMessage = RestCall.call("http://moara.org:9020/ml/vocab/tokenize", "1950년에 korea 가입 했어");
        System.out.println(receiveMessage);
        JSONArray array = new JSONArray(receiveMessage);
        for (int i = 0; i <array.length() ; i++) {
            JSONObject obj = array.getJSONObject(i);
            System.out.println(obj.getString("text"));
        }



    }
}
