package com.proton.monza.service;

import com.proton.monza.controller.FileLoaderController;
import com.proton.monza.model.FileModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FileLoaderServiceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    private FileLoaderController controladorArchivo;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void deberiaCargarseUnArchivoYSetearseUnNombre(){
        MultipartFile mockFile = mock(MultipartFile.class);
        when(mockFile.getOriginalFilename()).thenReturn("testFile.txt");

        FileLoaderService fileLoaderService = new FileLoaderService();

        FileModel result = fileLoaderService.loadFile(mockFile);

        verify(mockFile, times(1)).getOriginalFilename();

        assertThat(result.getFileName(), is("testFile.txt"));
    }

    @Test
    public void deberiaMostrarseFormularioDeCargaDeArchivo() throws Exception {
        // Prueba específica
        mockMvc.perform(MockMvcRequestBuilders.get("/cargar-archivo"))
                .andExpect(status().isOk())
                .andExpect(view().name("archivo-carga"));
    }

    @Test
    public void deberiaMostrarMensajeDespuesDeEnviarFormulario() throws Exception {
        MockMultipartFile file = new MockMultipartFile("archivo", "test.txt", "text/plain", "contenido de prueba".getBytes());

        mockMvc.perform(multipart("/cargar-archivo").file(file))
                .andExpect(status().isOk())
                .andExpect(view().name("archivo-carga"))
                .andExpect(model().attributeExists("mensaje"));
    }


    @Test
    public void laVistaDeberiaMostrarQueColumnasContieneElArchivoConSusRespectivosNombres() {
        // Implementar esta prueba para verificar la previsualización de columnas.
    }

    @Test
    public void LaVistaDeberiaMostrarLaCantidadDeEntradasEnElArchivoASubir() {
        // Implementar esta prueba para verificar la previsualización de la cantidad de entradas.
    }

    @Test
    public void queCuandoSeHaceLaCargaDelArchivoLaVistaMuestreUnMensajeDeExitoSiEsteSeCargoCorrectamente(){

    }
}
