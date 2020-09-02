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

package org.moara.api.example.engine;

import org.json.JSONArray;
import org.json.JSONObject;
import org.moara.api.example.rest.RestCall;
import org.moara.open.api.ApiMessageCode;
import org.moara.open.api.client.ApiRequests;

/**
 * Tokenize
 * @author macle
 */
public class VocabTokenize {


    public static void main(String[] args) {
        String result = ApiRequests.sendToReceiveMessage("hostAddress",10001,"org.moara.ara.datamining.textmining.api.word.engine","KoreaVocabWordsApi", "1950년에 korea 가입 했어");

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
