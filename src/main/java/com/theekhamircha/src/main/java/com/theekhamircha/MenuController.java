package com.theekhamircha;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class MenuController {

    @GetMapping("/menu")
    public List<MenuItem> getMenu() {
        return Arrays.asList(
            new MenuItem(1L, "Chicken Hot Garlic", 279, "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
            new MenuItem(2L, "Mushroom Chilly", 220, "https://images.unsplash.com/photo-1626074353765-517a681e40be"),
            new MenuItem(3L, "Paneer Chowmein", 190, "https://images.unsplash.com/photo-1617093727343-374698b1b08d")
        );
    }
}
