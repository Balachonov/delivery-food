package balachonov.entities;

import balachonov.util.UserFoodPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "USER_FOOD")
@Entity(name = "UserFood")
@Where(clause = "CLOSED = 0")
public class UserFood {

    @EmbeddedId
    private UserFoodPK idOrder;

    @ManyToOne
    @MapsId("idUser")
    @JoinColumn (name = "ID_USER")
    private User user;

    @ManyToOne
    @MapsId("idFood")
    @JoinColumn (name = "ID_FOOD")
    private Food food;

    @Column(name = "FOOD_RATING")
    private Integer foodRating;

    @Column(name = "CLOSED")
    private Integer closed = 0;

    public void setClosed() {
        this.closed = 1;
    }
}
