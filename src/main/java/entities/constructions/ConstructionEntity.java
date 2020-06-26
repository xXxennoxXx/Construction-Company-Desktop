package entities.constructions;

import entities.persons.WorkerEntity;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Currency;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "construction")
@Table(name = "Construction", schema = "dbo", catalog = "MAS")
public class ConstructionEntity {
    private int id;
    private String name;
    private Set<HouseEntity> houses;
    private Set<WorkerEntity> workers;
    private WorkerEntity boss;

    {
        //TODO
            /*
            Jun 25, 2020 1:10:58 PM org.hibernate.engine.jdbc.spi.SqlExceptionHelper logExceptions
        WARN: SQL Error: 207, SQLState: S0001
        Jun 25, 2020 1:10:58 PM org.hibernate.engine.jdbc.spi.SqlExceptionHelper logExceptions
        ERROR: Invalid column name 'cost'.
             */
//            @Formula("(select sum(h.cost) from house h where h.ConstructionID = id )")
        //    private Currency cost;
        //
        //
        //    public Currency getCost() {
        //        return cost;
        //    }
        //
        //    public void setCost(Currency cost) {
        //        this.cost = cost;
        //    }
    }

    public ConstructionEntity() {
        houses = new HashSet<>();
        workers = new HashSet<>();

    }

    public ConstructionEntity(String name, WorkerEntity boss) {
        this();
        this.name = name;
        this.boss = boss;
    }

    //TODO Jak sprowadzać koszt, get* hibernate nie puszcza
    public Double cost() {

        return houses.stream().mapToDouble(e -> e.getCost()).sum();

    }

    @Transient
    public Double getCost2() {

        return houses.stream().mapToDouble(e -> e.getCost()).sum();

    }

    @ManyToOne
    @JoinColumn(name = "BossID")
    public WorkerEntity getBoss() {
        return boss;
    }

    public void setBoss(WorkerEntity boss) {
        this.boss = boss;
    }


    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "construction", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public Set<HouseEntity> getHouses() {
        return houses;
    }

    public void setHouses(Set<HouseEntity> houses) {
        this.houses = houses;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Construction_Worker",
            joinColumns = {@JoinColumn(name = "IDConstruction")},
            inverseJoinColumns = @JoinColumn(name = "IDWorker")
    )
    public Set<WorkerEntity> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<WorkerEntity> workers) {
        this.workers = workers;
        for (WorkerEntity workerEntity : workers)
            workerEntity.addConstruction(this);
    }

    public boolean addWorker(WorkerEntity workerEntity) {
        if (workers.contains(workerEntity))
            return true;
        workers.add(workerEntity);
        return workerEntity.addConstruction(this);
    }

    public WorkerEntity removeWorker(WorkerEntity workerEntity) {
        if (!workers.contains(workerEntity))
            return workerEntity;
        workers.remove(workerEntity);
        workerEntity.removeConstruction(this);
        return workerEntity;

    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    public String toStringLong() {

        StringBuilder sb = new StringBuilder();

        sb.append("Construction:\n")
                .append("\tName: " + name)
                .append("\n\tHouses: ");
        for (HouseEntity h : houses) {
            for (String s : h.toString().split("\n"))
                sb.append("\n\t\t" + s);
            sb.append("\n\t\t,");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionEntity that = (ConstructionEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
