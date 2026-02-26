package com.example.spring_boot_practice;

import com.example.spring_boot_practice.dto.CarSaveDTO;
import com.example.spring_boot_practice.model.Car;
import com.example.spring_boot_practice.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CarControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CarRepository carRepository;

    private Long car1Id;
    private Long car2Id;
    private Long car3Id;

    @BeforeEach
    void setup() {
        carRepository.deleteAll();

        Car car1 = new Car(null, "Mazda", "3", 2015);
        Car car2 = new Car(null, "Opel", "Astra H", 2006);
        Car car3 = new Car(null, "Opel", "Astra J", 2007);

        Car saved1 = carRepository.save(car1);
        Car saved2 = carRepository.save(car2);
        Car saved3 = carRepository.save(car3);

        car1Id = saved1.getId();
        car2Id = saved2.getId();
        car3Id = saved3.getId();
    }

    @Test
    void shouldCreateCar() throws Exception {
        CarSaveDTO dto = new CarSaveDTO();
        dto.setBrand("Mazda");
        dto.setModel("3");
        dto.setYear(2015);

        mockMvc.perform(post("/car")
                        .contentType(MediaType.APPLICATION_JSON) //Json
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.brand").value("Mazda"))
                .andExpect(jsonPath("$.model").value("3"))
                .andExpect(jsonPath("$.year").value(2015));
    }

    @Test
    void shouldGetCarByID() throws Exception {
        mockMvc.perform(get("/car/{id}", car1Id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Mazda"))
                .andExpect(jsonPath("$.model").value("3"))
                .andExpect(jsonPath("$.year").value(2015));
    }

    @Test
    void shouldGetAllCars() throws Exception {
        mockMvc.perform(get("/car"))
                .andExpect(status().isOk()) // HTTP 200
                .andExpect(jsonPath("$").isArray()) // going to be an array
                .andExpect(jsonPath("$.length()").value(3)); // array length 2
    }

    @Test
    void shouldReplaceCarWithPut() throws Exception {
        CarSaveDTO updated = new CarSaveDTO();
        updated.setBrand("Opel");
        updated.setModel("Astra K");
        updated.setYear(2014);

        mockMvc.perform(put("/car/{id}", car3Id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Opel"))
                .andExpect(jsonPath("$.model").value("Astra K"))
                .andExpect(jsonPath("$.year").value(2014));
    }

    @Test
    void shouldPatchCar() throws Exception {

        String patch = """
                {
                    "model": "Astra GGG"
                }
                """;

        mockMvc.perform(patch("/car/{id}", car2Id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(patch))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Opel"))
                .andExpect(jsonPath("$.model").value("Astra GGG"))
                .andExpect(jsonPath("$.year").value(2006));
    }

    @Test
    void shouldDeleteById() throws Exception {
        mockMvc.perform(delete("/car/{id}", car1Id))
                .andExpect(status().isNoContent());
    }
}
