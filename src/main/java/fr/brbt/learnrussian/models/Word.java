package fr.brbt.learnrussian.models;

import javax.persistence.*;

@Entity
@Table(name="words")
public class Word {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ru_word")
    private String ruword;

    @Column(name="rank")
    private Integer rank;
    @Column(name = "level", columnDefinition = "TEXT")
    private String level;

    @Column(name = "type", columnDefinition = "TEXT")
    private String type;

    @Column(name = "usage")
    private String usage;


    public Integer getId() {
        return id;
    }

    public String getRuword() {
        return ruword;
    }

    public int getRank() {
        return rank;
    }

    public String getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public String getUsage() {
        if (usage == null) {
            return "No usage registered";
        }
        return usage;
    }
}
