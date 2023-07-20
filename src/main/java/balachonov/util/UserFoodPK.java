package balachonov.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserFoodPK implements Serializable {

    @Column(name = "ID_USER")
    private String idUser;

    @Column(name = "ID_FOOD")
    private String idFood;
}
