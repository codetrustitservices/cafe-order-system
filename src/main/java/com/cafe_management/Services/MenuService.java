package com.cafe_management.Services;

import com.cafe_management.Model.MenuItem;
import com.cafe_management.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * Get all menu items
     */
    public List<MenuItem> getAllMenuItems() {
        return menuRepository.findAll();
    }

    /**
     * Get only available menu items (for customers)
     */
    public List<MenuItem> getAvailableMenuItems() {
        return menuRepository.findByAvailableTrue();
    }

    /**
     * Get menu items by category
     */
    public List<MenuItem> getMenuItemsByCategory(String category) {
        return menuRepository.findByCategory(category);
    }

    /**
     * Get single menu item by ID
     * Throws exception if not found
     */
    public MenuItem getMenuItemById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found with id: " + id));
    }

    /**
     * Get single menu item by ID (Optional)
     * Returns Optional - good for checking existence
     */
    public Optional<MenuItem> findMenuItemById(Long id) {
        return menuRepository.findById(id);
    }

    /**
     * Save new menu item or update existing
     */
    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuRepository.save(menuItem);
    }

    /**
     * Delete menu item by ID
     */
    public void deleteMenuItem(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete - Menu item not found with id: " + id);
        }
        menuRepository.deleteById(id);
    }

    /**
     * Check if menu item exists
     */
    public boolean existsById(Long id) {
        return menuRepository.existsById(id);
    }

    /**
     * Search menu items by name (case-insensitive)
     */
    public List<MenuItem> searchMenuItems(String keyword) {
        return menuRepository.findByNameContainingIgnoreCase(keyword);
    }

    /**
     * Toggle availability of a menu item
     */
    public void toggleAvailability(Long id) {
        MenuItem item = getMenuItemById(id);
        item.setAvailable(!item.getAvailable());
        menuRepository.save(item);
    }

    /**
     * Count total menu items
     */
    public long countMenuItems() {
        return menuRepository.count();
    }

    /**
     * Count menu items by category
     */
    public long countByCategory(String category) {
        return menuRepository.findByCategory(category).size();
    }

    /**
     * Update menu item price
     */
    public void updatePrice(Long id, Double newPrice) {
        MenuItem item = getMenuItemById(id);
        item.setPrice(newPrice);
        menuRepository.save(item);
    }

    /**
     * Bulk delete menu items
     */
    public void deleteMenuItems(List<Long> ids) {
        menuRepository.deleteAllById(ids);
    }
}