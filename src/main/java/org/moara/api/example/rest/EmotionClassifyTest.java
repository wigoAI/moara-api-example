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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * @author macle
 */
public class EmotionClassifyTest {
    public static void main(String[] args) {



        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject param = new JsonObject();
        param.addProperty("title", "코로나 신규확진 438명… 소규모 모임·직장 등 일상감염 확산 지속");
        param.addProperty("contents",
                "전국 곳곳에서 코로나 확산세가 이어지면서 30일 신규 확진자가 438명 발생했다. 지난 26~28일 사흘 연속 500명대를 기록하다가 이틀째 400명대 중반으로 내려왔지만, 이는 평일 대비 휴일 검사 건수가 수천건 줄어든 영향으로 보인다. 통상 주말과 휴일에는 검사 기관이 일시적으로 줄어들면서 평일보다 검사 수가 적고, 이에 따라 확진자 수도 감소하는 경향을 보인다.\n" +
                        "\n" +
                        "중앙방역대책본부에 따르면 신규 확진자 438명 가운데 지역 감염자는 414명, 해외 입국자는 24명이다. 에어로빅 학원, 학교, 교회, 유흥주점, 군부대, 사우나 등 기존 집단발병 사례에서 확진자가 계속 나오는 데다 각종 소모임과 직장 등 다양한 일상 공간을 매개로 한 신규 집단감염이 속출하면서 확산세가 쉽게 잡힐 기미를 보이지 않고 있다. 특히 최근 감염 전파가 젊은 층을 중심으로 급증하면서 지역사회 전파가 가속화하고 있다.\n" +
                        "\n" +
                        "정부는 3차 대유행의 기세를 잡기 위해 12월 1일부터 비수도권의 사회적 거리두기를 1.5단계로 격상하고, 수도권에서는 현행 2단계를 유지하되 사우나와 단체운동 공간 등 감염 위험 시설 운영을 중단하는 이른바 ‘2+α’ 조치를 시작하기로 했다.\n" +
                        "\n" +
                        "강도태 중앙재난안전대책본부 1총괄조정관(보건복지부 2차관)은 이날 정부세종청사에서 열린 중대본 회의에서 \"주말에도 불구하고 확진자 규모가 여전히 크고, 에어로빅 교습소와 탁구장, 학원, PC방, 사우나 등 다양한 다중이용시설에서 발생한 소규모 감염이 가족과 지인, 동료를 거쳐 대규모 감염으로 이어지고 있다\"며 \"3차 유행의 장기화를 막기 위해서는 강화된 사회적 거리두기에 전국민적 동참이 필요하다\"고 말했다.\n" +
                        "\n" +
                        "\n" +
                        "28일 밤 충북 제천에서 '김장모임 발' 코로나가 확산하자 선별진료소에 야간까지 진단검사를 받으려는 시민들이 몰리고 있다. /연합뉴스\n" +
                        "최근 1주일간 통계를 보면 신규 확진자는 하루 평균 465.4명 늘었다. 거리두기 단계 조정의 핵심 지표인 지역발생 확진자는 일평균 438.7명으로, 전국적 유행이 본격화하는 2.5단계 기준인 ‘전국 400명~500명 이상 또는 더블링 등 급격한 증가’ 수준에 들어온 상황이다.\n" +
                        "\n" +
                        "국내 감염자가 나온 지역을 보면 서울 158명, 경기 69명, 인천 34명 등 수도권이 261명이다. 수도권 지역발생 확진자는 전날 263명과 비슷한 수준을 유지하며 전체 지역발생의 63%를 차지했다.\n" +
                        "\n" +
                        "비수도권의 경우 부산이 52명으로 가장 많고 이어 충북 22명, 경남 19명, 전북 16명, 광주 12명, 강원 8명, 대전 5명, 대구·경북·충남 각 4명, 울산·전남 각 3명, 세종 1명 등이다. 비수도권 지역발생 확진자는 총 153명으로, 지난 24일부터 일주일 연속 100명대를 이어갔다.\n" +
                        "\n" +
                        "주요 감염 사례를 보면 서울 동대문구의 한 탁구장을 중심으로 집단발병이 확인돼 전날 낮까지 총 11명이 감염됐고, 노원구의 한 체육시설에서도 총 10명이 확진 판정을 받았다.\n" +
                        "\n" +
                        "이외에 ▲강서구 댄스·에어로빅 학원(누적 176명) ▲마포구 소재 교회(146명) ▲서초구 사우나(78명) ▲서초구 사우나Ⅱ(66명) ▲서울 휴대전화 어플 소모임(26명) 등의 사례에서도 감염 불씨가 이어졌다.\n" +
                        "\n" +
                        "비수도권에서는 충북 제천시의 김장모임 관련 확진자가 40명까지 늘어난 가운데 ▲충북 청주시 당구장 선후배 모임(25명) ▲전남 장성군 상무대(18명) ▲부산·울산 장구강습(106명) 등에서도 확진자가 잇따르는 양상이다.\n" +
                        "\n" +
                        "해외유입 확진자는 24명으로, 전날 37명보다 13명 줄었다. 최근 1주일간 해외유입 신규 확진자는 20~30명대를 오르내리고 있다. 확진자 가운데 10명은 공항이나 항만 입국 검역 과정에서 확인됐다. 나머지 14명은 지역 거주지나 임시생활시설에서 자가격리하던 중 양성 판정을 받았다.\n" +
                        "\n" +
                        "사망자는 전날보다 3명 늘어 누적 526명이 됐다. 국내 평균 치명률은 1.54%다. 코로나 확진 이후 상태가 위중하거나 악화한 '위중증' 환자는 76명이다.\n" +
                        "\n" +
                        "방역당국은 매일 오전 9시 30분쯤 코로나19 신규 확진자를 발표하지만, 이날은 1시간 가량 지연됐다. 방대본은 확진자 집계 발표가 늦어진 이유에 대해 \"러시아 선원과 관련된 확진자 변동 사항이 있어 전체 분류별 통계 재정리에 시간이 걸렸다\"고 설명했다.\n"

                );


        String request = gson.toJson(param);

        System.out.println( request);

        String jsonValue = RestCall.call("address/classify/emotion", request);


        System.out.println(gson.toJson(gson.fromJson(jsonValue, JsonObject.class)));
    }
}
