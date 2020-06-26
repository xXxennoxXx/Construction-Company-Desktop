package entities.constructions;

import entities.persons.ClientEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "House", schema = "dbo", catalog = "MAS")
public class HouseEntity {


    private int id;
    private String name;
    private List<RoomEntity> rooms;
    private HouseType type;
    private ConstructionEntity construction;
    private ClientEntity owner;
    private Double cost;


    @Id
    @Column(name = "ID", nullable = false)
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

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    @Enumerated
    public HouseType getType() {
        return type;
    }

    public void setType(HouseType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "constructionid", nullable = false)
    public ConstructionEntity getConstruction() {
        return construction;
    }

    public void setConstruction(ConstructionEntity construction) {
        this.construction = construction;
    }

    @ManyToOne
    @JoinColumn(name = "ownerid", nullable = false)
    public ClientEntity getOwner() {
        return owner;
    }

    public void setOwner(ClientEntity owner) {
        this.owner = owner;
    }


    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseEntity that = (HouseEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("HouseEntity:\n" +
                "\tid: " + id +
                "\n\tname: " + name +
                "\n\ttype: " + type +
                "\n\tRooms:");

        for (RoomEntity r : rooms)
            sb.append("\n\t\t" + r.toString());

        return sb.toString();
    }
}


