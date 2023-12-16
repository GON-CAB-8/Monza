package com.proton.monza.service;

import com.proton.monza.model.FileModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileLoaderService {

    public FileModel loadFile(MultipartFile file) {
        // Implementa la lógica para procesar el archivo y obtener los datos
        // Puedes utilizar librerías como Apache POI para trabajar con archivos Excel o CSV
        // Aquí es donde puedes realizar la lógica de procesamiento del archivo y crear un objeto FileModel
        // ...

        FileModel fileModel = new FileModel();
        fileModel.setFileName(file.getOriginalFilename());
        // Puedes asignar el contenido del archivo a fileModel.content

        return fileModel;
    }
}
