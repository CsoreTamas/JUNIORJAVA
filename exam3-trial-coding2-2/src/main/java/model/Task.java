package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
    private long id;
    private String title;
    private String description;
}
