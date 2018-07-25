/**
 * Created by IntelliJ IDEA.
 * User: DatNH5
 * Date: 7/23/2018
 * Time: 1:47 PM
 **/
package com.example.demo;

import com.example.demo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello/hello");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("hello/login");
    }

    @RequestMapping(method = RequestMethod.GET, value = "user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("You are user", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("You are admin", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "login2")
    public ResponseEntity<Boolean> login2(@RequestParam("username") String username,
                                          @RequestParam("password") String password) {
        if (username.equals("admin") && password.equals("admin")) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(token);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else if (username.equals("user") && password.equals("user")) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(token);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }


}
