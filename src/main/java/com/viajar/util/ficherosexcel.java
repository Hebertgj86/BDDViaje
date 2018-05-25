package com.viajar.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ficherosexcel {
    String nombreArchivo="ResultadosVuelosDespegar.xlsx";
    String rutaArchivo= "C:\\Ficheros-Excel\\"+nombreArchivo;
    String hoja="Hoja1";

    XSSFWorkbook libro= new XSSFWorkbook();
    XSSFSheet hoja1 = libro.createSheet(hoja);

    public void Excel (String [][] document) {

        //cabecera de la hoja de excel
        String [] header= new String[]{"Aerolínea", "Precio"};


        //generar los datos para el documento
        for (int i = 0; i <= document.length; i++) {
            XSSFRow row=hoja1.createRow(i);//se crea las filas
            for (int j = 0; j <header.length; j++) {
                if (i==0) {//para la cabecera
                    XSSFCell cell= row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellValue(header[j]);//se añade el contenido
                }else{//para el contenido
                    XSSFCell cell= row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    cell.setCellValue(document[i-1][j]); //se añade el contenido
                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)){
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
