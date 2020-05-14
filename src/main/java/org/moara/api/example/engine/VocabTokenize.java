package org.moara.api.example.engine;

import org.json.JSONArray;
import org.json.JSONObject;
import org.moara.api.example.rest.RestCall;
import org.moara.open.api.ApiMessageCode;
import org.moara.open.api.client.ApiRequests;

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
        String result = ApiRequests.sendToReceiveMessage("192.168.0.61",10303,"org.moara.ara.datamining.textmining.api.word.engine","KoreaVocabWordsApi", "1950년에 korea 가입 했어");

        if(result.startsWith(ApiMessageCode.FAIL)){
            throw new RuntimeException(result);
        }
        System.out.println(result);
        JSONArray array = new JSONArray(result);
        for (int i = 0; i <array.length() ; i++) {
            JSONObject obj = array.getJSONObject(i);
            System.out.println(obj.getString("text"));
        }


    }
}
