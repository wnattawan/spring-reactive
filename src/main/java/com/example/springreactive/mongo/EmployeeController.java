package com.example.springreactive.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee e) {
        employeeService.create(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id) {
        Mono<Employee> employeeMono = employeeService.findById(id);
        HttpStatus status = employeeMono != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Employee>>(employeeMono, status);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Flux<Employee> findByName(@PathVariable("name") String name) {
        return employeeService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> findAll() {
        Flux<Employee> employeeFlux = employeeService.findAll();
        return employeeFlux;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> update(@RequestBody Employee e) {
        return employeeService.update(e);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        employeeService.delete(id).subscribe();
    }
}
