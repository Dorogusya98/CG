package vt41.cgc.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Substance")
public class Substance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="substance", fetch=FetchType.EAGER)
    private Set<Constant> constantSet;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "substanceSet")
    private Set<Task> taskSet;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return name; }

    public void setTitle(String name) { this.name = name; }

    public String getType() { return description; }

    public void setType(String description) { this.description = description; }

    public Set<Task> getTaskSet() { return taskSet; }

    public void setTaskSet(Set<Task> taskSet) { this.taskSet = taskSet; }
}
