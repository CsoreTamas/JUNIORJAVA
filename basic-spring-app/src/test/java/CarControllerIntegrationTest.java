import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.CarController;
import dto.CarPatchDTO;
import dto.CarResponseDTO;
import dto.CarSaveDTO;
import exception.GlobalExceptionHandler;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import repository.CarRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:test-spring-servlet.xml")
public class CarControllerIntegrationTest {

    @Autowired
    private CarController controller;

    @Autowired
    private CarRepository carRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        carRepository.deleteAll();
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldReturnEmptyLostWhenNoCars() throws Exception {
        mockMvc.perform(get("/car"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void shouldCreateAndReturnACar() throws Exception {
        CarSaveDTO carSaveDTO = new CarSaveDTO("Mazda", "3", 2013);
        mockMvc.perform(post("/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(carSaveDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.model").value("Mazda"))
                .andExpect(jsonPath("$.brand").value("3"))
                .andExpect(jsonPath("$.year").value(2013));
    }

    @Test
    void shouldReturn404WhenCarNotFound() throws Exception {
        mockMvc.perform(get("/car/123123"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldGetCarById() throws Exception {
        Long id = createCarAndGetId();

        mockMvc.perform(get("/car/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("Mazda"))
                .andExpect(jsonPath("$.brand").value("3"))
                .andExpect(jsonPath("$.year").value(2013));
    }

    @Test
    void shouldGetAllCars() throws Exception {
        CarSaveDTO saveDTO = new CarSaveDTO("Mazda", "3", 2013);
        mockMvc.perform(post("/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saveDTO)))
                .andReturn().getResponse().getContentAsString();

        mockMvc.perform(get("/car"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void shouldReplaceCarById() throws Exception {
        Long id = createCarAndGetId();

        CarSaveDTO updateDTO = new CarSaveDTO("Astra H", "Opel", 2006);

        mockMvc.perform(put("/car/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Opel"))
                .andExpect(jsonPath("$.model").value("Astra H"))
                .andExpect(jsonPath("$.year").value(2006));
    }

    @Test
    void shouldPatchCarById() throws Exception {
        Long id = createCarAndGetId();

        CarPatchDTO patchDTO = new CarPatchDTO();
        patchDTO.setYear(2025);

        mockMvc.perform(patch("/car/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patchDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.year").value(2025));
    }

    @Test
    void shouldDeleteCarById() throws Exception {
        Long id = createCarAndGetId();
        mockMvc.perform(delete("/car/{id}", id))
                .andExpect(status().isNoContent());
    }

    private Long createCarAndGetId() throws Exception {
        CarSaveDTO saveDTO = new CarSaveDTO("Mazda", "3", 2013);
        String response = mockMvc.perform(post("/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saveDTO)))
                .andReturn().getResponse().getContentAsString();

        return new ObjectMapper().readTree(response).get("id").asLong();
    }
}
