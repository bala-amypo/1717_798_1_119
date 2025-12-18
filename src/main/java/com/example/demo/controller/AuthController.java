// package com.example.demo.controller;

// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.LoginRequest;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication", description = "APIs for user authentication")
// public class AuthController {
    
//     private final AuthenticationManager authenticationManager;
//     private final UserDetailsService userDetailsService;
//     private final JwtUtil jwtUtil;
//     private final UserService userService;
//     private final PasswordEncoder passwordEncoder;
    
//     public AuthController(
//             AuthenticationManager authenticationManager,
//             UserDetailsService userDetailsService,
//             JwtUtil jwtUtil,
//             UserService userService,
//             PasswordEncoder passwordEncoder) {
//         this.authenticationManager = authenticationManager;
//         this.userDetailsService = userDetailsService;
//         this.jwtUtil = jwtUtil;
//         this.userService = userService;
//         this.passwordEncoder = passwordEncoder;
//     }
    
//     @PostMapping("/register")
//     @Operation(summary = "Register a new user")
//     public ResponseEntity<AuthResponse> register(@RequestBody User user) {
//         User registeredUser = userService.register(user);
        
//         UserDetails userDetails = userDetailsService.loadUserByUsername(registeredUser.getEmail());
//         String token = jwtUtil.generateToken(userDetails);
        
//         AuthResponse response = new AuthResponse(token, registeredUser.getId(), registeredUser.getEmail(), registeredUser.getRole());
//         return ResponseEntity.ok(response);
//     }
    
//     @PostMapping("/login")
//     @Operation(summary = "Login user")
//     public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
//         Authentication authentication = authenticationManager.authenticate(
//             new UsernamePasswordAuthenticationToken(
//                 loginRequest.getEmail(),
//                 loginRequest.getPassword()
//             )
//         );
        
//         UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//         String token = jwtUtil.generateToken(userDetails);
        
//         User user = userService.findByEmail(loginRequest.getEmail());
        
//         AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
//         return ResponseEntity.ok(response);
//     }
// }