package com.HotelBooking.app.controller;

import com.HotelBooking.app.model.Staff;
import com.HotelBooking.app.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class AuthController {



/*
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}


    /* @Autowired
    StaffRepository staffRepository;



    private final BCryptPasswordEncoder encoder;
    private final JwtConfig jwtConfig;

    public AuthController(BCryptPasswordEncoder encoder, JwtConfig jwtConfig) {
        this.encoder = encoder;
        this.jwtConfig = jwtConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginInput creditentials) {
        // check if username is match
        Staff staff = staffRepository.findByUsername(creditentials.getUsername());

        // check if password is match
        if(encoder.matches(creditentials.getPassword(), staff.getPassword())){
            *//**** generate token****//*
            //1- get roles
            Role staffRole = staff.getRole();
            SimpleGrantedAuthority grant = new SimpleGrantedAuthority(staffRole.getName());
            List<GrantedAuthority> grandAuthorities = Arrays.asList(grant);
            //2-get current date to attach token
            long now = System.currentTimeMillis();
            //3- generate token
            String token = Jwts.builder()
                    .setSubject(staff.getUsername())
                    .setIssuedAt(new Date(now))
                    .setExpiration(new Date(now + jwtConfig.getExpiration() * 1000L))  // in milliseconds
                    .claim("authorities", grandAuthorities.stream()
                            .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .claim("id",staff.getId())
                    .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())

                    .compact();

            // 4- return token
            var tokenInfo = new TokenResponse();
            tokenInfo.access_token = token;
            tokenInfo.token_type = jwtConfig.getPrefix();
            tokenInfo.expires_in = jwtConfig.getExpiration();
            return new ResponseEntity<>(tokenInfo, HttpStatus.OK);
        }
        throw new RuntimeException("Invalid username or password");

    }
*/
}
