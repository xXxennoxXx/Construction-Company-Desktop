package entities.constructions;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Room", schema = "dbo", catalog = "MAS")
public class RoomEntity {
    private int id;

    private String description;
    private HouseEntity house;


    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "houseid", nullable = false)
    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomEntity)) return false;
        RoomEntity that = (RoomEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + id);
        return sb.toString();
    }
}
