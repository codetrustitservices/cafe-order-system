package com.cafe_management.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;
    private String description;
    private String imageUrl;
    private Boolean available;
// ========================================
    // HELPER METHODS
    // ========================================

    /**
     * Check if item is available
     */
    public boolean isAvailable() {
        return available != null && available;
    }

    /**
     * Get formatted price
     */
    public String getFormattedPrice() {
        return String.format("₹%.2f", price);
    }

    /**
     * Get badge color based on category
     */
    public String getCategoryBadgeClass() {
        if (category == null) return "badge-secondary";

        switch (category.toLowerCase()) {
            case "coffee":
                return "badge-coffee";
            case "snacks":
                return "badge-snacks";
            case "meals":
                return "badge-meals";
            default:
                return "badge-secondary";
        }
    }

    // ========================================
    // TOSTRING, EQUALS, HASHCODE
    // ========================================

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        return id != null ? id.equals(menuItem.id) : menuItem.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
