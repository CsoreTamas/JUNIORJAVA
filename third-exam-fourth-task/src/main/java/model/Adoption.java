package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(exclude = "animal") //Avoid infinite loop in toSting
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "adopter_name", nullable = false)
    private String adopterName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
}
