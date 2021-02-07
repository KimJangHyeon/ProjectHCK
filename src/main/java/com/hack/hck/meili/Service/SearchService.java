package com.hack.hck.meili.Service;

import com.hack.hck.meili.Config.MeiliConfig;
import com.hack.hck.meili.Index.Genre;
import com.hack.hck.meili.Index.Party.Option;
import com.hack.hck.meili.Index.Party.Party;
import com.hack.hck.meili.Index.Word.Word;
import com.meilisearch.sdk.Index;
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

    public void getParty(String string) {
        List<String> strings = Arrays.asList(string.split(" "));
        List<Integer> matching_point = new ArrayList<>();

        //장르찾기
        List<Genre> genres = getGenre(strings);

        for (Genre g : genres) {
            matching_point.add(0);
        }

    }
}
