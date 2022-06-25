package com.helloworld.helloworld.model;

import javax.persistence.*;

@Entity
@Table(name = "helloworlds")
public class HelloWorld {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "language_code")
    private String langCode;
    @Column(name = "lang")
    private String lang;
    private String translation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public HelloWorld(){};

    public HelloWorld(String langCode, String lang, String translation) {
        this.langCode = langCode;
        this.lang = lang;
        this.translation = translation;
    }
}
