package am.basic.springTest.controller;

import am.basic.springTest.model.Car;
import am.basic.springTest.model.exceptions.DuplicateDataException;
import am.basic.springTest.service.CarSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarSerivce carSerivce;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/test1", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Car> getAllByBody() {
        return carSerivce.getAll();
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(carSerivce.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.of(carSerivce.findById(id));
    }

    @PostMapping(/*spasum a back@ */consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@Valid @RequestBody Car car) throws DuplicateDataException {

        return ResponseEntity.ok(carSerivce.save(car));

    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Car car) throws DuplicateDataException {
        car.setId(id);
        return ResponseEntity.ok(carSerivce.update(car));
    }
}

