package pl.kurs.java.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.kurs.java.StartAppExchange;
import pl.kurs.java.model.ExchangeRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartAppExchange.class)
@AutoConfigureMockMvc
class ExchangeControllerTest {
    @Autowired
    private MockMvc postman;

    @Test
    public void shouldGetGoodReturn() throws Exception {
        /**
         * Coś nie działa co mogę z tym zrobić
         */

        postman.perform(MockMvcRequestBuilders.get("/ex").content(new ObjectMapper()
                .writeValueAsString(ExchangeRequest.builder().currentTo("PLN").currentFrom("EUR").amount(10).build())))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("exchangeResultView"))
                .andExpect(view().name("exchangeResultView"))
                .andExpect(content().string(Matchers.containsString("price")))
                .andExpect(content().string(Matchers.containsString("value")))
                .andDo(print());


    }


    /*
    Tu piszemy test integracyjny
    cos tam dopisalismy
     */
}