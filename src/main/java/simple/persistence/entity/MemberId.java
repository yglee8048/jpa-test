package simple.persistence.entity;

import java.io.Serializable;

public class MemberId implements Serializable {

    private String uid;

    private Team team;

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
}
