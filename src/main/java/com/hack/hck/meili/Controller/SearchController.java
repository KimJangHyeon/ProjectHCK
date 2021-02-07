package com.hack.hck.meili.Controller;

import com.hack.hck.meili.Index.Party.Party;
import com.hack.hck.meili.Service.SearchService;
import org.springframework.web.bind.annotation.*;

@RestController("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PutMapping()
    public void dataFeeding(@RequestBody Party party) throws Exception {
        searchService.feeding(party);
    }

    @GetMapping
    public String getParty(@RequestParam String string) {
        return searchService.getParty(string);
    }
}
