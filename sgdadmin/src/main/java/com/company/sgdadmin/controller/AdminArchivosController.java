/*
 *say hello
 */
package com.company.sgdadmin.controller;

import com.company.sgdadmin.entity.DocumentosActivosEntity;
import com.company.sgdadmin.exceptions.DownloadException;
import com.company.sgdadmin.repository.DocumentosActivosRepository;
import com.company.sgdadmin.service.FileManager;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Allan Flores Rojas
 */
@Controller
public class AdminArchivosController {

    @Autowired
    private DocumentosActivosRepository doctosRepository;

    @Autowired
    FileManager fileManager;

    @GetMapping("/listaarchivos")
    public String getArchivos(Model model) {
        return "listaarchivos";
    }

    @PostMapping("/getDocto")
    @ResponseBody
    public void getDocument(@RequestParam("id") Integer id) {
        DocumentosActivosEntity activosEntity = doctosRepository.findByDocumentoid(id);
        try {
            if (activosEntity != null) {
                fileManager.downloadFile(activosEntity);
            } else {
                throw new DownloadException();
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminArchivosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GetMapping("/alldocuments")
    @ResponseBody
    public List<DocumentosActivosEntity> listaJSON() {
        return (List<DocumentosActivosEntity>) doctosRepository.findAll();
    }
}
