package com.cafe_management.Controllers;

import com.cafe_management.Model.MenuItem;
import com.cafe_management.Services.MenuService;
import com.cafe_management.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    // ========================================
    // DASHBOARD
    // ========================================
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("todayOrders", orderService.getTodayOrders());
        model.addAttribute("pendingOrders", orderService.getOrdersByStatus("PENDING"));
        model.addAttribute("totalItems", menuService.getAllMenuItems().size());
        return "admin/dashboard";
    }

    // ========================================
    // VIEW ALL MENU ITEMS
    // ========================================
    @GetMapping("/menu")
    public String viewAllItems(Model model) {
        model.addAttribute("menuItems", menuService.getAllMenuItems());
        model.addAttribute("menuItem", new MenuItem());
        model.addAttribute("isEdit", false);
        return "admin/menu-management";
    }

    // ========================================
    // ADD NEW ITEM - SHOW FORM
    // ========================================
    @GetMapping("/menu/add")
    public String showAddForm(Model model) {
        model.addAttribute("menuItem", new MenuItem());
        return "admin/add-item";
    }

    // ========================================
    // ADD NEW ITEM - SAVE
    // ========================================
    @PostMapping("/menu/add")
    public String addMenuItem(
            @ModelAttribute MenuItem item,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            RedirectAttributes redirectAttributes) {

        try {
            // Handle image upload if provided
            if (imageFile != null && !imageFile.isEmpty()) {
                String imageUrl = saveImage(imageFile);
                item.setImageUrl(imageUrl);
            } else {
                // Set default image if no image uploaded
                item.setImageUrl("/images/default-menu-item.jpg");
            }

            item.setAvailable(true); // Default available
            menuService.saveMenuItem(item);

            redirectAttributes.addFlashAttribute("success", "Menu item added successfully! ✅");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to add item: " + e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/admin/menu";
    }

    // ========================================
    // EDIT ITEM - SHOW FORM
    // ========================================
    @GetMapping("/menu/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            // Get the item to edit
            MenuItem menuItem = menuService.getMenuItemById(id);
            // Add to model for form binding
            model.addAttribute("menuItem", menuItem);
            // Add all items for the table
            model.addAttribute("menuItems", menuService.getAllMenuItems());
            // Set edit flag
            model.addAttribute("isEdit", true); // Flag to show it's edit mode
            // Return to same page (menu-management.html)
            return "admin/menu-management";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Item not found!");
            return "redirect:/admin/menu";
        }
    }

    // ========================================
    // EDIT ITEM - UPDATE
    // ========================================
    @PostMapping("/menu/edit/{id}")
    public String updateMenuItem(
            @PathVariable Long id,
            @ModelAttribute MenuItem menuItem,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            RedirectAttributes redirectAttributes) {

        try {
            // Get existing item from database
            MenuItem existingItem = menuService.getMenuItemById(id);

            // Update fields
            existingItem.setName(menuItem.getName());
            existingItem.setDescription(menuItem.getDescription());
            existingItem.setPrice(menuItem.getPrice());
            existingItem.setCategory(menuItem.getCategory());
            existingItem.setAvailable(menuItem.getAvailable() != null ? menuItem.getAvailable() : true);

            // Update image only if new image is uploaded
            if (imageFile != null && !imageFile.isEmpty()) {
                String imageUrl = saveImage(imageFile);
                existingItem.setImageUrl(imageUrl);
            }
            // Otherwise keep existing image

            // Save updated item
            menuService.saveMenuItem(existingItem);

            redirectAttributes.addFlashAttribute("success", "Menu item updated successfully! ✅");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to update item: " + e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/admin/menu";
    }

    // ========================================
    // DELETE ITEM
    // ========================================
    @GetMapping("/menu/delete/{id}")
    public String deleteMenuItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            menuService.deleteMenuItem(id);
            redirectAttributes.addFlashAttribute("success", "Menu item deleted successfully! 🗑️");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete item: " + e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/admin/menu";
    }

    // ========================================
    // TOGGLE AVAILABILITY
    // ========================================
    @GetMapping("/menu/toggle/{id}")
    public String toggleAvailability(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            MenuItem item = menuService.getMenuItemById(id);
            item.setAvailable(!item.getAvailable());
            menuService.saveMenuItem(item);

            String status = item.getAvailable() ? "available" : "unavailable";
            redirectAttributes.addFlashAttribute("success", "Item marked as " + status + "!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to toggle availability: " + e.getMessage());
        }

        return "redirect:/admin/menu";
    }

    // ========================================
    // HELPER METHOD - SAVE IMAGE
    // ========================================
    private String saveImage(MultipartFile file) throws IOException {
        // Define upload directory
        String uploadDir = "src/main/resources/static/images/menu/";
        Path uploadPath = Paths.get(uploadDir);

        // Create directory if it doesn't exist
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Get original filename and extension
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new IOException("Invalid file name");
        }

        // Extract file extension
        String fileExtension = "";
        int dotIndex = originalFilename.lastIndexOf('.');
        if (dotIndex > 0) {
            fileExtension = originalFilename.substring(dotIndex);
        }

        // Generate unique filename using UUID
        String newFilename = UUID.randomUUID().toString() + fileExtension;

        // Full file path
        Path filePath = uploadPath.resolve(newFilename);

        // Save file
        Files.copy(file.getInputStream(), filePath);

        // Return URL path (used in HTML)
        return "/images/menu/" + newFilename;
    }
}