package com.HotelBooking.app.auth.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/login")) {
            filterChain.doFilter(request, response);
        }else {
            String autorizationHeader = request.getHeader(AUTHORIZATION);
                if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")) {
                    try {


                        String token = autorizationHeader.substring("Bearer ".length());
                        log.info("Token: {}", token);
                       // Algorithm algorithm = Algorithm.HMAC512("secret");
                      //  JWTVerifier verifier = JWT.require(algorithm).build();
                        DecodedJWT decodedJWT = JWT.decode(token);
                        log.info("decodedJWT: {}", decodedJWT);
                        String userName = decodedJWT.getSubject();
                        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                        stream(roles).forEach(role -> {
                            authorities.add(new SimpleGrantedAuthority(role));

                        });
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userName, null, authorities);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);
                    } catch (Exception e) {
                        log.error("Error in authentication : {}", e.getMessage());

                        response.setHeader("error", e.getMessage());
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        //response.sendError(HttpServletResponse.SC_FORBIDDEN);
                        Map<String, String> error = new HashMap<>();
                        error.put("error_message", e.getMessage());

                        response.setContentType(APPLICATION_JSON_VALUE);
                        new ObjectMapper().writeValue(response.getOutputStream(), error);

                    }
                }else{
                    filterChain.doFilter(request, response);

                    }
                }
        }
    }

