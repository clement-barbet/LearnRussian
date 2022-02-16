package fr.brbt.learnrussian.models;

import fr.brbt.learnrussian.db.RevisionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "revision")
public class Revision {

    public Revision(Integer id, Integer userID, Integer wordID) {

        this.id = id;
        this.userID = userID;
        this.wordID = wordID;
    }

    @Id
    @Column(nullable = false, name = "id")
    Integer id;

    @Column(nullable = false, name="user_id")
    Integer userID;

    @Column(nullable = false, name="word_id")
    Integer wordID;

    public Integer getId() {
        return id;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getWordID() {
        return wordID;
    }

    public Revision() {

    }
}
