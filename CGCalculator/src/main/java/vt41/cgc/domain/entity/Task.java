package vt41.cgc.domain.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(name = "TaskSubstanse",
            joinColumns = @JoinColumn(name="task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="substance_id", referencedColumnName="id"))
    private Set<Substance> substanceSet;

    public Set<Substance> getSubstanceSet() { return substanceSet; }

    public void setSubstanceSet(Set<Substance> substanceSet) { this.substanceSet = substanceSet; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
