package dto;

public record CarResponseDTO(
        Long id,
        String brand,
        String model,
        Integer year
) {
}
