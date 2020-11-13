package simple.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(MemberId.class)
public class Member implements Serializable {

    @Id
    private String uid;

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id1", referencedColumnName = "id1"),
            @JoinColumn(name = "id2", referencedColumnName = "id2")
    })
    private Team team;

    private String att1;

    private String att2;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getAtt1() {
        return att1;
    }

    public void setAtt1(String att1) {
        this.att1 = att1;
    }

    public String getAtt2() {
        return att2;
    }

    public void setAtt2(String att2) {
        this.att2 = att2;
    }
}
