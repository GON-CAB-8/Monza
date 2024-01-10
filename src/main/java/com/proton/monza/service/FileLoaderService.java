package com.proton.monza.service;

import com.proton.monza.model.FileModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileLoaderService {

    public FileModel loadFile(MultipartFile file) {
        // Implementa la lógica para procesar el archivo y obtener los datos
        // Aquí es donde puedes realizar la lógica de procesamiento del archivo y crear un objeto FileModel

        String originalFileName = file.getOriginalFilename();
        List<String> content = new ArrayList<>();
        Integer referenceYear = 2022;
        Date uploadDate = new Date();

        //formato dd/mm/yyyy a la fecha de carga
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateStr  = dateFormat.format(uploadDate);

        Date uploadedDateFormatted;
        try {
            uploadedDateFormatted = dateFormat.parse(formattedDateStr);
        } catch (ParseException e) {
            // Manejar la excepción según sea necesario
            e.printStackTrace();
            uploadedDateFormatted = new Date();
        }


        FileModel fileModel = new FileModel(originalFileName, content, uploadedDateFormatted, referenceYear);

        return fileModel;
    }
}
