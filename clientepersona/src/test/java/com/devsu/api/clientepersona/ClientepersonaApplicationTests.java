package com.devsu.api.clientepersona;

import com.devsu.api.clientepersona.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientepersonaApplicationTests {

	@Test
	void contextLoads() {
	}

	@ParameterizedTest
	@MethodSource("clientesProvider")
	public void testCrearCliente(Long clientId, String contrasena, String estado) {
		// Arrange
		Cliente cliente = new Cliente(clientId, contrasena, estado);

		// Act & Assert
		assertEquals(clientId, cliente.getClientId());
		assertEquals(contrasena, cliente.getContrasena());
		assertEquals(estado, cliente.getEstado());
	}

	// Método que proporciona diferentes casos de prueba
	private static Stream<Arguments> clientesProvider() {
		return Stream.of(
				Arguments.of(1L, "contrasena1", "activo"),
				Arguments.of(2L, "contrasena2", "inactivo"),
				Arguments.of(3L, "contrasena3", "suspendido")
				// Agrega más casos según sea necesario
		);
	}

}
