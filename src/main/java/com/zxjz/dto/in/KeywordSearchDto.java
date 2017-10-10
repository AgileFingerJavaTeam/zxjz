package com.zxjz.dto.in;

public class KeywordSearchDto {
    private String key_word;

    public KeywordSearchDto(String key_word) {
        this.key_word = key_word;
    }

    public String getKey_word() {
        return key_word;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word;
    }

    @Override
    public String toString() {
        return "KeywordSearchDto{" +
                "key_word='" + key_word + '\'' +
                '}';
    }
}
