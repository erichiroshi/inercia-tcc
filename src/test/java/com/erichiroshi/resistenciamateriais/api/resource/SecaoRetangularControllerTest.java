package com.erichiroshi.resistenciamateriais.api.resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class SecaoRetangularControllerTest {

	@Autowired
	MockMvc mvc;
	
	@Test
	@DisplayName("Deve retornar as propriedades calculadas")
	public void calcularPropriedadesDaSecao() {
		
		
		
		
		
	}
	
	@Test
	@DisplayName("Deve retornar erro quando algum dado for errado")
	public void calcularComDadosInvalidos() {
		
	}
}
