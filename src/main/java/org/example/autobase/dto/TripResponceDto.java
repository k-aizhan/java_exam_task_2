package org.example.autobase.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.autobase.entity.Trip;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TripResponceDto {
    private Long id;
    private String destination;
    private boolean isCompleted;

    public void TripResponceDto(Trip trip) {
        this.destination = trip.getDestination();
        this.isCompleted = trip.isCompleted();
    }
}
