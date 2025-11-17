package tables;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @NonNull
    private Course course;
}
