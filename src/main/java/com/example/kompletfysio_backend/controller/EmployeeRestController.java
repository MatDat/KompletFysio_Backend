package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.JwtTokenManager;
import com.example.kompletfysio_backend.dto.dtoemployee.EmployeeDTO;
import com.example.kompletfysio_backend.model.JwtResponseModel;
import com.example.kompletfysio_backend.service.EmployeeService;
import com.example.kompletfysio_backend.service.JwtEmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtEmployeeDetailsService employeeDetailsService;
    @Autowired
    JwtTokenManager jwtTokenManager;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> signup(@RequestBody EmployeeDTO request){
//        System.out.println("signup: username:" + request.getUsername() + " password: " + request.getPassword() );
        return employeeService.signup(request);

    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseModel> login(@RequestBody EmployeeDTO request)throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(),
                            request.password())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new JwtResponseModel("bad credentials"));
        }
        final UserDetails userDetails = employeeDetailsService.loadUserByUsername(request.username());
        final String jwtToken = jwtTokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }

    @GetMapping("/getEmployeeByTreatmentId/{treatment_id}")
    public ResponseEntity<List<EmployeeDTO>> getShowingById(@PathVariable("treatment_id") int treatment_id){
        List<EmployeeDTO> EmployeeDTOList = employeeService.getEmployeesByTreatmentId(treatment_id);
        return new ResponseEntity<>(EmployeeDTOList, HttpStatus.OK);
    }
}
