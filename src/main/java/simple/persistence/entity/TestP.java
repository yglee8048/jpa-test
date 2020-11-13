package simple.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestP {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "testP", fetch = FetchType.EAGER)
    private List<TestC> children = new ArrayList<TestC>();

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

    public List<TestC> getChildren() {
        return children;
    }

    public void setChildren(List<TestC> children) {
        this.children = children;
    }
}
