package fr.brbt.learnrussian.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @Column(name = "id")
    Integer id;
    @Column(name = "word_id")
    Integer wordID;
    @Column(name = "position")
    Integer position;
    @Column(name = "translation")
    String translation;
    @Column(name = "example_ru")
    String exampleRU;
    @Column(name = "example_tl")
    String exampleTL;
    @Column(name = "info")
    String info;

    public Integer getId() {
        return id;
    }

    public Integer getWordID() {
        return wordID;
    }

    public Integer getPosition() {
        return position;
    }

    public String getTranslation() {
        return translation;
    }

    public String getExampleRU() {
        return exampleRU;
    }

    public String getExampleTL() {
        return exampleTL;
    }

    public String getInfo() {
        return info;
    }
}