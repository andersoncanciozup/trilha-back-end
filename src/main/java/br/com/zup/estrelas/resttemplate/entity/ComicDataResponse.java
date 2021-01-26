package br.com.zup.estrelas.resttemplate.entity;

import java.util.List;

public class ComicDataResponse {

    private List<Comic> results;

    public List<Comic> getResults() {
        return results;
    }

    public void setResults(List<Comic> results) {
        this.results = results;
    }
}