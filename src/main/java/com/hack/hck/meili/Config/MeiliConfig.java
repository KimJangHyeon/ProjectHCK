package com.hack.hck.meili.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import com.meilisearch.sdk.Index;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MeiliConfig {
    final static private Client client = new Client(new Config("http://52.78.202.184:7700", "master"));
    final static private Gson gson = new Gson();
    final static private ObjectMapper mapper = new ObjectMapper();

    public String objectToJson(Object o) {
        String documents = gson.toJson(o);
        if (documents.charAt(0) == '{') return "[" + documents + "]";
        else return documents;
    }

    public <T> T jsonToObject(String str, Class<T> tClass) throws IOException {
        return mapper.readValue(str, tClass);
    }

    public Index getIndex(String index_name) throws Exception {
        return client.getOrCreateIndex(index_name, "id");
    }
    public Index getWordIndex(String index_name) throws Exception {
        return client.getOrCreateIndex(index_name + "Word", "word");
    }
}
