package io.github.lyxiangyu.mytreehole.controller;

import io.github.lyxiangyu.mytreehole.entity.Admins;
import io.github.lyxiangyu.mytreehole.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @PostMapping("/add")
    public void addAdmin(@RequestParam Integer userId) {
        adminsService.addAdmin(userId);
    }

    @DeleteMapping("/delete/{adminId}")
    public void deleteAdmin(@PathVariable Integer adminId) {
        adminsService.deleteAdmin(adminId);
    }

    @GetMapping("/all")
    public List<Admins> getAllAdmins() {
        return adminsService.getAllAdmins();
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Integer>> getStats() {
        return ResponseEntity.ok(adminsService.getStats());
    }
}
