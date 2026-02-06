package com.cafe_management.Repository;

import com.cafe_management.Model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Long> {

    /**
     * Find items by category
     * Usage: menuRepository.findByCategory("Coffee")
     */
    List<MenuItem> findByCategory(String category);

    /**
     * Find only available items (available = true)
     * Usage: menuRepository.findByAvailableTrue()
     */
    List<MenuItem> findByAvailableTrue();

    /**
     * Find unavailable items (available = false)
     * Usage: menuRepository.findByAvailableFalse()
     */
    List<MenuItem> findByAvailableFalse();

    /**
     * Search items by name (case-insensitive, partial match)
     * Usage: menuRepository.findByNameContainingIgnoreCase("cappuccino")
     * Returns: Cappuccino, Iced Cappuccino, etc.
     */
    List<MenuItem> findByNameContainingIgnoreCase(String name);

    /**
     * Find items by category and availability
     * Usage: menuRepository.findByCategoryAndAvailable("Coffee", true)
     */
    List<MenuItem> findByCategoryAndAvailable(String category, Boolean available);

    /**
     * Find items with price less than specified amount
     * Usage: menuRepository.findByPriceLessThan(100.0)
     */
    List<MenuItem> findByPriceLessThan(Double price);

    /**
     * Find items with price between min and max
     * Usage: menuRepository.findByPriceBetween(50.0, 200.0)
     */
    List<MenuItem> findByPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Count items by category
     * Usage: menuRepository.countByCategory("Coffee")
     */
    long countByCategory(String category);

    /**
     * Count available items
     * Usage: menuRepository.countByAvailable(true)
     */
    long countByAvailable(Boolean available);

    /**
     * Custom query - Find items ordered by price ascending
     */
    @Query("SELECT m FROM MenuItem m ORDER BY m.price ASC")
    List<MenuItem> findAllOrderByPriceAsc();

    /**
     * Custom query - Find items ordered by price descending
     */
    @Query("SELECT m FROM MenuItem m ORDER BY m.price DESC")
    List<MenuItem> findAllOrderByPriceDesc();

    /**
     * Custom query - Find recently added items (last 10)
     */
    @Query("SELECT m FROM MenuItem m ORDER BY m.id DESC")
    List<MenuItem> findRecentItems();
}