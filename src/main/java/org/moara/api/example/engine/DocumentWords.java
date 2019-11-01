package org.moara.api.example.engine;

import org.json.JSONArray;
import org.json.JSONObject;
import org.moara.ara.datamining.textmining.api.document.DocumentStandardKey;
import org.moara.ara.datamining.textmining.document.Document;
import org.moara.common.code.LangCode;
import org.moara.common.network.socket.HostAddrPort;
import org.moara.engine.console.EngineConsole;
import org.moara.open.api.ApiMessageCode;
import org.moara.open.api.client.ApiRequests;

/**
 * <pre>
 *  파 일 명 : DocumentWords.java
 *  설    명 : 원문 단어정보
 *
 *  작 성 자 : macle(김용수)
 *  작 성 일 : 2019.11
 *  버    전 : 1.0
 *  수정이력 :
 *  기타사항 :
 * </pre>
 * @author Copyrights 2019 by ㈜모아라. All right reserved.
 */
public class DocumentWords {

    public static String call(String hostAddress, int port, String jsonValue){

        String result = ApiRequests.sendToReceiveMessage(hostAddress,port,"org.moara.ara.datamining.textmining.api.engine","DocumentWordsApi", jsonValue);

        if(result.startsWith(ApiMessageCode.FAIL)){
            throw new RuntimeException(result);
        }

        return result;
    }

    public static void main(String[] args) {
        //엔진코드를 이용하여 접속정보 가져오기
        HostAddrPort hostAddrPort =  EngineConsole.getHostAddrPort("macle");

        JSONObject messageObj = new JSONObject();
        //제목이 있을경우
//        messageObj.put(DocumentStandardKey.TITLE.key() , " 제목 ");


        //문서유형 설정 default SNS
//       messageObj.put(DocumentStandardKey.DOC_TYPE.key(), Document.SNS);
        //언어유형 설정 default KO
//       messageObj.put(DocumentStandardKey.LANG_CODE.key(), LangCode.KO);

        //본문
        messageObj.put(DocumentStandardKey.CONTENTS.key() , "지난 19대 총선 당시 한국당은 ‘이주노동자와 다문화 가정을 대변할 수 있는 인재를 영입하겠다’며 이 전 의원을 전격 영입했다. 이후 비례대표로 19대 국회에서 당 가정폭력대책분과 위원장 등을 맡으며 이주여성 보호 법안 등을 발의하는 등 활발히 활동했지만, 19대 국회 이후 당이 이 전 의원을 공천하지 않기로 하면서 당내에서 별다른 활동을 하지 못했다.");

        String receiveMessage = call(hostAddrPort.getHostAddress(), hostAddrPort.getPort(), messageObj.toString());

        JSONObject receiveObj = new JSONObject(receiveMessage);

        //분석 원문 (위치 참조용)
        System.out.println(receiveObj.getString(DocumentStandardKey.ANALYSIS_CONTENTS.key()));

        JSONArray wordArray = receiveObj.getJSONArray(DocumentStandardKey.WORD_ARRAY.key());

        for (int i = 0; i <wordArray.length() ; i++) {
            System.out.println(wordArray.get(i).toString());
        }



    }
}
