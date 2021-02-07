package com.hack.hck.meili.Service;

import com.hack.hck.meili.Config.MeiliConfig;
import com.hack.hck.meili.Index.Genre;
import com.hack.hck.meili.Index.Party.Option;
import com.hack.hck.meili.Index.Party.Party;
import com.hack.hck.meili.Index.Word.Word;
import com.meilisearch.sdk.Index;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchService {
    private final MeiliConfig meiliConfig;

    public SearchService(MeiliConfig meiliConfig) {
        this.meiliConfig = meiliConfig;
    }

    private boolean isWordExist(String word, Index index) {
        try {
            String jsonStr = index.search(word);
            JSONObject jsonObject = new JSONObject(jsonStr);
            int nbhits = jsonObject.getInt("nbhits");
            if (nbhits == 0) return true;
            else return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getJsonWords(Party party) throws Exception {
        StringBuilder tar = new StringBuilder(party.getTitle() + ' ' + party.getCotent());
        List <Option> options = party.getOptions();
        for (Option option : options) {
            tar.append(' ').append(option.getView());
        }
        List <String> strings = Arrays.asList(tar.toString().split(String.valueOf(' ')));
        Index dumpIndex = meiliConfig.getIndex(Genre.GENRE4.get());
        List <Word> words = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++) {
            if (!isWordExist(strings.get(i), dumpIndex)) {
                Word word = new Word();
                word.setWord(strings.get(i));
                word.setGenre(party.getGenre());
                word.setMoving(0);
                words.add(word);
            }
            else {
                String jsonStr = dumpIndex.search(strings.get(i));
                JSONObject jsonObject = new JSONObject(jsonStr);
                JSONArray hits = jsonObject.getJSONArray("hits");

                Word word = (Word) hits.get(0);
                word.setWord(strings.get(i));
                if (!party.getGenre().get().equals(word.getGenre().get())) {
                    word.setGenre(party.getGenre());
                    word.setMoving(word.getMoving() + 1);
                }
                words.add(word);
            }
        }
        return  meiliConfig.objectToJson(words);
    }

    public boolean feeding(Party party) throws Exception {
        meiliConfig.getIndex(party.getGenre() + "Word");
        Index index = meiliConfig.getWordIndex(party.getGenre().get());
        index.addDocuments(getJsonWords(party));
        return true;
    }

    List<Genre> getGenre(List<String> strings) {
        return Arrays.asList(Genre.GENRE1, Genre.GENRE2);
    }

    public List<String> getParty(String string) throws Exception {
        List<String> strings = Arrays.asList(string.split(" "));
        List<String> strs = new ArrayList<>();
        //장르찾기
        List<Genre> genres = getGenre(strings);

        // 찾은 것을 넘겨주기
        for (Genre g : genres) {
            Index index = meiliConfig.getIndex(g.get());
            strs.add(index.getDocuments());
        }

        //스트라이드로 섞어서 보여주면 좋음
        return strs;
    }
}
