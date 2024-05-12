package tech.projects.barberhub.dto.barbershop;

public record CreateBarberShopDTO(
        String name,
        String description,
        String address,
        String contact
) {
}
