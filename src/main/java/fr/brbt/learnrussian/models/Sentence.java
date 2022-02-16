package fr.brbt.learnrussian.models;

import javax.persistence.*;

@Entity
@Table(name="sentences")
public class Sentence {
    public enum Level {
        A1,
        A2,
        B1,
        B2,
        C1,
        C2
    }
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ru")
    private String phrase_ru;
    @Column(name = "en")
    private String phrase_en;
    @Column(name = "level", columnDefinition = "TEXT")
    private String level;
    @Column(name = "audio_link")
    private String audiolink;


    public Integer getId() {
        return id;
    }

    public String getPhrase_ru() {
        return phrase_ru;
    }

    public String getPhrase_en() {
        return phrase_en;
    }

    public String getLevel() {
        return level.toString();
    }

    public String getAudiolink() {
        return audiolink;
    }
}