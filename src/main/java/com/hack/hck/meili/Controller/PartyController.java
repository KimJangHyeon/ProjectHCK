package com.hack.hck.meili.Controller;

import com.hack.hck.meili.Config.MeiliConfig;
import com.hack.hck.meili.Index.Party.Party;
import com.hack.hck.meili.Service.PartyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/party")
public class PartyController {
    private final PartyService partyService;

    public PartyController(final PartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping
    boolean postParty(@RequestBody Party party) {
        try {
            partyService.postParty(party);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}