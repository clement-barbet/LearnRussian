package fr.brbt.learnrussian.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sentences_words")
public class Sentence2Word {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "sentence_id")
    private int sentenceid;
    @Column(name = "word_id")
    private int wordid;
    @Column(name = "start")
    private int start;
    @Column(name= "length")
    private int length;

    public int getId() {
        return id;
    }

    public int getSentence_id() {
        return sentenceid;
    }

    public int getWordid() {
        return wordid;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }
}