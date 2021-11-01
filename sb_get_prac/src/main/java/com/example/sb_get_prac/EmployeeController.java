package com.example.sb_get_prac;


import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController

@RequestMapping("employees")

public class EmployeeController {

    private static AtomicLong counterID = new AtomicLong();

    @GetMapping
    public String root(){
        return " Welcome to the Employee System ";
    }

    @GetMapping("dummy")
    public Employee dummy(){
        return new Employee(43000, "Jon", "Jonny");
    }


    @GetMapping("/{firstName}")
    public Employee getEmployee(@PathVariable(name = "firstName") String firstName)
                               {
        return new Employee(counterID.incrementAndGet(), firstName, "Benjamin");
    }

    @GetMapping("add")
    public Employee addEmployee(@RequestParam(name = "firstName", defaultValue = "No name") String firstName,
                                @RequestParam(name = "lastName", defaultValue = "No name") String lastName){
        return new Employee(counterID.incrementAndGet(), firstName, lastName);
    }

}
