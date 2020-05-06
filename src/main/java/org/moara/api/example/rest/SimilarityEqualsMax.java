package org.moara.api.example.rest;

import org.json.JSONObject;
import org.moara.common.util.ExceptionUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <pre>
 *  파 일 명 : SimilarityEqualsMax.java
 *  설    명 : 유사도 학습유형 DATA_EQUALS 의 최대확율값 얻기
 *
 *  작 성 자 : macle(김용수)
 *  작 성 일 : 2019.11
 *  버    전 : 1.0
 *  수정이력 :
 *  기타사항 :
 * </pre>
 * @author Copyrights 2019 by ㈜모아라. All right reserved.
 */
public class SimilarityEqualsMax {

    public static String call(String address, String jsonValue){

        try {
            URL url = new URL(address + "/similarity/equals/max");
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

        String source = "한국교통안전공단이 7일 경북 김천시 소재 평화시장을 방문해 시장 상인들과 소통의 시간을 가지고 안전용품(소화기) 100개를 전달했다.\n" +
                "이번 활동은 지역 사회공헌의 일환으로 건조한 날씨로 인해 화재발생 위험이 높아지는 동절기를 대비해 구조상 전통시장의 안전 확보를 위해 실시되었다.\n" +
                "이날 교통안전공단 임직원과 노동조합이 함께 참여해 시장 상인들에게 소화기와 효자손, 지압봉 등을 나눠주며 직접 소화기 사용법 시범을 보였다.\n" +
                "또한 시설 전기업무 담당 직원은 시장 내 화재 요인이 될 수 있는 전기설비 등을 점검하고 현장 맞춤형 활동을 했다.\n" +
                "권병윤 한국교통안전공단 이사장은 공단이 지역사회와 협력하고 안전사고를 예방하는 것은 공공기관의 당연한 의무이자 도리라며 지속적으로 지역사회와 소통을 확대해 실질적으로 지역사회에 도움이 되는 안전경영 활동을 추진할 계획이라고 밝혔다.\n" +
                "한편 한국교통안전공단은 지난 2014년 김천 혁신도시로 본사를 이전한 이후 지역 상생과 협력을 위해 사랑의 컴퓨터 기증행사, 1사1촌 자매결연을 통한 농촌 일손돕기, 명절 어르신과 소외계층 대상 위문활동 및 후원금 전달 등 나눔 활동을 하고 있다."
                ;

        String target ="노사합동 전통시장 방문 소화기 100개 전달\n" +
                "□ 한국교통안전공단(이사장 권병윤)은 11월 7일(목) 경북 김천시 소재 평화시장을 방문하여 시장 상인들과 소통의 시간을 가지고 안전용품(소화기) 100개를 전달하였다고 밝혔다.\n" +
                "ㅇ 이번 활동은 지역 사회공헌의 일환으로 건조한 날씨로 인해 화재발생 위험이 높아지는 동절기를 대비하여,\n" +
                "ㅇ 구조상 자칫 대형화재로 이어질 수 있는 전통시장의 안전 확보를 위해 실시되었다.\n" +
                "□ 소화기 전달과 더불어 공단 임직원 및 노동조합이 함께 참여하여 시장 상인들에게 효자손, 지압봉 등을 나눠주며 소통하고, 소화기 사용법에 대하여 직접 시범을 보였다.\n" +
                "ㅇ 또한 시설 전기업무 담당 직원이 시장 내 화재 요인이 될 수 있는 전기설비 등을 점검하는 등,\n" +
                "ㅇ 공단의 안전경영과 연계하여 직원의 전문성을 활용한 현장 맞춤형 활동을 실시하였다.\n" +
                "□ 한편, 공단은 14년 김천 혁신도시로 본사를 이전한 이후 지역 상생과 협력을 위해\n" +
                "ㅇ 사랑의 PC 기증행사, 1사1촌 자매결연을 통한 농촌 일손돕기, 명절 어르신과 소외계층 대상 위문활동 및 후원금 전달과 같은 나눔 활동을 꾸준히 이어오고 있다.\n" +
                "□ 공단 권병윤 이사장은 공단이 지역사회와 협력하고 안전사고를 예방하는 것은 공공기관의 당연한 의무이자 도리라고 강조하며,\n" +
                "ㅇ 지속적으로 지역사회와 소통을 확대하고 실질적으로 지역사회에 도움이 되는 안전경영 활동을 추진할 계획이라고 밝혔다.";



//        System.out.println("=============");
//        System.out.println(source);



        messageObj.put("source" , source);
        messageObj.put("target" , target);

//        String receiveMessage = call("http://wigo.moara.org:3993", messageObj.toString());
        String receiveMessage = call("http://127.0.0.1:33377", messageObj.toString());
        //분석 원문 (위치 참조용)
        System.out.println(receiveMessage);
//        System.out.println(messageObj.toString());

    }
}
