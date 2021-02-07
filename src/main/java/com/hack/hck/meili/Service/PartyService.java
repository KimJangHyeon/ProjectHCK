package com.hack.hck.meili.Service;

import com.hack.hck.meili.Config.MeiliConfig;
import com.hack.hck.meili.Index.Party.Party;
import com.meilisearch.sdk.Index;
import org.springframework.stereotype.Service;

@Service
public class PartyService {

    private final MeiliConfig meiliConfig;

    public PartyService(final MeiliConfig meiliConfig) {
        this.meiliConfig = meiliConfig;
    }

    public void postParty(Party party) throws Exception {
        String data = meiliConfig.objectToJson(party);
        Index index = meiliConfig.getIndex(party.getGenre().get());
        index.addDocuments(data);
    }
}
