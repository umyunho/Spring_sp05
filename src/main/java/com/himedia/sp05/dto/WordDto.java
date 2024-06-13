package com.himedia.sp05.dto;

public class WordDto {
    public WordDto(){}
    private String wordKey;
    private String wordValue;

    public WordDto(String wordKey, String wordValue) {
        this.wordKey = wordKey;
        this.wordValue = wordValue;
    }

    public String getWordKey() {
        return wordKey;
    }

    public void setWordKey(String wordKey) {
        this.wordKey = wordKey;
    }

    public String getWordValue() {
        return wordValue;
    }

    public void setWordValue(String wordValue) {
        this.wordValue = wordValue;
    }
}
