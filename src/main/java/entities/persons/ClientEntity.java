package entities.persons;

import entities.constructions.HouseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "client")
public class ClientEntity extends PersonEntity {

    private String accountNumber;
    private Set<HouseEntity> houses;

    @Column(name = "accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public Set<HouseEntity> getHouses() {
        return houses;
    }

    public void setHouses(Set<HouseEntity> houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Client:\n")
                .append("\tID: ").append(getId())
                .append("\n\tFirst Name: ").append(getFirstName())
                .append("\n\tAccount Number: ");
        for (int i = 0; i < accountNumber.length(); i++) {
            if (i % 4 == 0)
                builder.append(" ");
            builder.append(accountNumber.charAt(i));
        }
        builder.append("\n\tHouses:\n");
        for (HouseEntity h : houses)
            builder.append("\t\t")
                    .append(h.getName())
                    .append("\n");
        return builder.toString();
    }
}
