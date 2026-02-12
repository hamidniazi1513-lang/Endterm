package com.hamidniazi.endterm_project.service;

import com.hamidniazi.endterm_project.model.User;
import com.hamidniazi.endterm_project.repository.UserRepository;
import com.hamidniazi.endterm_project.patterns.SimpleCache; // Import the new cache
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    // Get the Cache Instance
    private final SimpleCache cache = SimpleCache.getInstance();
    private final String CACHE_KEY = "all_users";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // --- MODIFIED: Uses Cache ---
    public List<User> getAllUsers() {
        // 1. Check Cache First
        List<User> cachedUsers = (List<User>) cache.get(CACHE_KEY);
        if (cachedUsers != null) {
            return cachedUsers; // Return fast from memory!
        }

        // 2. If not in cache, query DB
        List<User> users = userRepository.findAll();

        // 3. Save to cache for next time
        cache.put(CACHE_KEY, users);
        return users;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // --- MODIFIED: Clears Cache on Change ---
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        cache.clear(CACHE_KEY); // Clear cache so new user appears in list
        return savedUser;
    }

    public User updateUser(Long id, User userDetails) {
        User existingUser = getUserById(id);
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setRole(userDetails.getRole());

        User updatedUser = userRepository.save(existingUser);
        cache.clear(CACHE_KEY); // Invalidate cache
        return updatedUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        cache.clear(CACHE_KEY); // Invalidate cache
    }
}