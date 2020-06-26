package entities.persons;

import entities.constructions.ConstructionEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "worker")
public class WorkerEntity extends PersonEntity {

    private Set<ConstructionEntity> constructions;
    private Set<ConstructionEntity> bossOnConstructions;

    public WorkerEntity() {
        this.constructions = new HashSet<>();
        this.bossOnConstructions = new HashSet<>();
    }

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public Set<ConstructionEntity> getBossOnConstructions() {
        return bossOnConstructions;
    }

    public void setBossOnConstructions(Set<ConstructionEntity> bossOnConstructions) {
        this.bossOnConstructions = bossOnConstructions;
    }

    @ManyToMany(mappedBy = "workers")
    public Set<ConstructionEntity> getConstructions() {
        return constructions;
    }

    public void setConstructions(Set<ConstructionEntity> constructions) {
        this.constructions = constructions;
        for (ConstructionEntity constructionEntity : constructions)
            constructionEntity.addWorker(this);
    }

    public boolean addConstruction(ConstructionEntity constructionEntity) {
        if (constructions.contains(constructionEntity))
            return true;
        constructions.add(constructionEntity);
        return constructionEntity.addWorker(this);
    }

    @Override
    public String toString() {
        return getId() + ": " + getFirstName();
    }

    public String toStringLong() {
        StringBuilder sb = new StringBuilder();

        sb.append("Worker:\n")
                .append("\tName: ").append(getFirstName())
                .append("\n\tWorking on:\n");

        for (ConstructionEntity c : constructions)
            sb.append("\t\t").append(c.getName())
                    .append("\n");
        sb.append("\tIs Boss on:\n");
        for (ConstructionEntity c : bossOnConstructions)
            sb.append("\t\t")
                    .append(c.getName())
                    .append("\n");
        return sb.toString();
    }


    public ConstructionEntity removeConstruction(ConstructionEntity constructionEntity) {
        if (!constructions.contains(constructionEntity))
            return constructionEntity;
        constructions.remove(constructionEntity);
        constructionEntity.removeWorker(this);
        return constructionEntity;
    }
}
