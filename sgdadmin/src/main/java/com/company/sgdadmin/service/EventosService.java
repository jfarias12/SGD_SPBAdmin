/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.sgdadmin.service;

import com.company.sgdadmin.entity.CalendarioEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author the_d
 */
@Service
public interface EventosService {
    public boolean registro(CalendarioEntity cal);
    public void borrar(CalendarioEntity cal);
}
