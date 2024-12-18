package org.example.autobase.entity;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Trip {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private boolean isCompleted;


    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}

