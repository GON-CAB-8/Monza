package com.proton.monza.service;

import com.proton.monza.controller.FileLoaderController;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class FileLoaderServiceTest {


    private FileLoaderController controladorArchivo;
    private MockMvc mockMvc;

    @Test
    public void elUsuarioSoloDeberiaPoderSeleccionarYCargarArchivosPredefinidos() throws Exception {


        // Prueba específica
        mockMvc.perform(MockMvcRequestBuilders.get("/cargar-archivo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("archivo/cargar"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("archivoModel"));
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
