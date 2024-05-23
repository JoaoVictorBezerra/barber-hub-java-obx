package tech.projects.barberhub.dto.barbershop;

public record CreateBarbershopDTO(
        String name,
        String description,
        String address,
        String imageUrl,
        String contact
) {
}
