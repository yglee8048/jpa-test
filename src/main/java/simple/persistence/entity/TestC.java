package simple.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestC {

    @Id
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "testP_id")
    private TestP testP;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestP getTestP() {
        return testP;
    }

    public void setTestP(TestP testP) {
        this.testP = testP;
    }
}
