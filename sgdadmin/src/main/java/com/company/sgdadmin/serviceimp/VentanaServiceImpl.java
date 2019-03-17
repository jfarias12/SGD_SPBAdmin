/*
 *  ing_farias@live.com
 */

package com.company.sgdadmin.serviceimp;

import com.company.sgdadmin.dto.filemanager.FileManagerDTO;
import com.company.sgdadmin.entity.DocumentosActivosEntity;
import com.company.sgdadmin.repository.DocumentosActivosRepository;
import com.company.sgdadmin.service.FileManager;
import com.company.sgdadmin.service.VentanaServices;
import com.company.sgdadmin.util.ConstantsSGD;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jova_
 */
@Service
public class VentanaServiceImpl implements VentanaServices{
    
    @Value("${directorio}")
    private String dirPrincipal;
    @Value("${documentosunicos}")
    private String documentosunicos;
    @Value("${estadosfinacierosfolder}")
    private String estadosfinancieros;
    @Value("${doclegalfolder}")
    private String documentacionlegal;
    @Value("${asambleaordinariafolder}")
    private String asambleaordinaria;
    @Value("${avisoprivacidadfolder}")
    private String avisorpivacidad;
    @Value("${cumplimientooblifolder}")
    private String cumplimientoobligaciones;

    @Value("${escriturasfolder}")
    private String escrituras;
    
    @Value("${actaconstitutivafolder}")
    private String actaconstitutiva;
        @Value("${actaconstitutivafile}")
    private String actaconstitutivafile;
    
    @Value("${poderesfolder}")
    private String poderes;
    @Value("${poderesfile}")
    private String poderesfile;
    
    @Value("${reformaestatutosfolder}")
    private String reformaestatutos; 
    @Value("${reformaestatutosfile}")
    private String reformaestatutosfile;
    
    
    @Value("${inscripcionrfc}")
    private String inscripcionrfc;
     
     
     @Value("${rfcfoder}")
    private String rfc;        
     @Value("${rfcfile}")
    private String rfcfile;
     
       @Value("${fielfolder}")
    private String fiel;
        @Value("${fielfile}")
    private String fielfile;
        
      @Value("${sellodigitalfolder}")
    private String sellodigital;    
      
         @Value("${sellodigitalfile}")
    private String sellodigitalfile;  
      
          
      @Value("${avisoprivacidadfolder}")
    private String avisoprivacidadfolder;    
      
         @Value("${avisoprivacidadfile}")
    private String avisoprivacidadfile;  
         
            @Value("${cumplimientooblifolder}")
    private String cumplimientooblifolder;    
      
         @Value("${cumplimientooblifile}")
    private String cumplimientooblifile;  
         
           @Value("${comprobantedomicilio}")
    private String comprobantedomicilio;  
           
             @Value("${comprobantedomiciliofile}")
    private String comprobantedomiciliofile;  
      
       @Value("${asambleaordinariafolder}")
    private String asambleaordinariafolder;

    @Value("${asambleaordinariafile}")
    private String asambleaordinariafile;

    @Value("${prefijoestadosfinancieros}")
    private String prefijoestadosfinancieros;

    @Value("${contratosfirmadosfolder}")
    private String contratosfirmadosfolder;

    @Value("${contratosfirmadosfinancierosfolder}")
    private String contratosfirmadosfinancierosfolder;

    @Value("${cffinancierosfile}")
    private String cffinancierosfile;

    @Value("${contratosfirmadosprovedoresfolder}")
    private String contratosfirmadosprovedoresfolder;

    @Value("${cfprovedoresfile}")
    private String cfprovedoresfile;

    @Value("${contratosfirmadosclientesfolder}")
    private String contratosfirmadosclientesfolder;

    @Value("${cfclientesfile}")
    private String cfclientesfile;

    @Value("${contratosfirmadospersonalfolder}")
    private String contratosfirmadospersonalfolder;

    @Value("${cfpersonalfile}")
    private String cfpersonalfile;

    @Value("${sagarpafolder}")
    private String sagarpafolder;

    @Value("${comprobantepagosfolder}")
    private String comprobantepagosfolder;

    @Value("${comprobantepagosfile}")
    private String comprobantepagosfile;

    @Value("${depositofolder}")
    private String depositofolder;

    @Value("${depositofile}")
    private String depositofile;

    @Value("${documentosolifolder}")
    private String documentosolifolder;

    @Value("${documentosolifile}")
    private String documentosolifile;

    @Value("${presentacionescorpfolder}")
    private String presentacionescorpfolder;

    @Value("${presentacionescorpfile}")
    private String presentacionescorpfile;

    @Value("${gobiernocorporativofolder}")
    private String gobiernocorporativofolder;

    
    @Value("${asambleaacciofolder}")
    private String asambleaacciofolder;

    @Value("${convocatoriafolder}")
    private String convocatoriafolder;

    @Value("${convocatoriafile}")
    private String convocatoriafile;

    @Value("${minutafolder}")
    private String minutafolder;

    @Value("${minutafile}")
    private String minutafile;

    @Value("${ordendiafolder}")
    private String ordendiafolder;

    @Value("${ordendiafile}")
    private String ordendiafile;

    @Value("${presentacioninformacionfolder}")
    private String presentacioninformacionfolder;

    @Value("${presentacioninformacionfile}")
    private String presentacioninformacionfile;
    
    
        

                            
   
        @Autowired
    DocumentosActivosRepository repository;
        
        @Autowired
    FileManager fileManager;

    @Override
    public void getVentanas(MultipartFile file, String year, String month, String date,String direccion) {
        
        try {
            String HOME = ConstantsSGD.HOME;
            
           
            
            String path="";
            

            switch (direccion) {
                
                //INICIAMOS CON DOCUMENTACION LEGAL
                
                case "actaconstitutiva":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + escrituras + File.separator + actaconstitutiva + File.separator + actaconstitutivafile;
                    break;
                    
                       case "poderes":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + escrituras + File.separator + poderes + File.separator + poderesfile;
                    break;
                    
                       case "reformaestatutos":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + escrituras + File.separator + reformaestatutos + File.separator + reformaestatutosfile;
                    break;
                    
                        case "rfc":

                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + rfc + File.separator + rfcfile;
                    break;
                    
                        case "fiel":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + fiel + fielfile;
                    break;
                    
                        case "sellodigital":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + sellodigital + sellodigitalfile;
                    break;
                    
                       case "avisoprivacidad":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + avisoprivacidadfolder + avisoprivacidadfile;
                    break;
                    
                    case "cumplimientoobligaciones":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + cumplimientooblifolder + cumplimientooblifile;
                    break;
                    
                      case "comprobantedomicilio":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + comprobantedomicilio + comprobantedomiciliofile;
                    break;
                    
                        case "asambleaordinariafile":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + documentacionlegal
                            + File.separator + asambleaordinariafolder + asambleaordinariafile;
                    break;

                 //AQUI EMPIEZA EDOS FINANCIEROS
                        case "edosfinancieros":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + estadosfinancieros
                            + File.separator + year + File.separator + prefijoestadosfinancieros + month + "-" + year + ".pdf";
                    break;

                    //AQUI EMPIEZA CONTRATOS FIRMADOS
                    
                          case "financieros":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + contratosfirmadosfolder
                            + File.separator + contratosfirmadosfinancierosfolder + File.separator  + cffinancierosfile;
                    break;

                          case "proveedores":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + contratosfirmadosfolder
                            + File.separator + contratosfirmadosprovedoresfolder + File.separator  + cfprovedoresfile;
                    break;
                    
                        case "clientes":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + contratosfirmadosfolder
                            + File.separator + contratosfirmadosclientesfolder + File.separator  + cfclientesfile;
                    break;
                    
                        case "personal":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + contratosfirmadosfolder
                            + File.separator + contratosfirmadospersonalfolder + File.separator  + cfpersonalfile;
                    break;
                    
                    //AQUI EMPIEZA REPORTE DE VENTAS
                    //QUE NOMBRE LLEVAN LOS ARCHIVOS????
                    
                             case "reporteventas":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + estadosfinancieros
                            + File.separator + year + File.separator + prefijoestadosfinancieros + month + "-" + year + ".pdf";
                    break;
                    
                    //AQUI EMPIEZA SAGARPA
                    
                          case "documentosolicitud":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + sagarpafolder
                            + File.separator + documentosolifolder + File.separator + documentosolifile;
                    break;
                    
                      case "deposito":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + sagarpafolder
                            + File.separator + depositofolder + File.separator + depositofile;
                    break;
                    
                     case "comprobantepagos":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + sagarpafolder
                            + File.separator + comprobantepagosfolder + File.separator + comprobantepagosfile;
                    break;
                    
                    //AQUI EMPIEZA PRESENTACIONES COORPORATIVAS

                      case "presentacionescorporativas":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + presentacionescorpfolder
                            + File.separator + presentacionescorpfile + "-" + date + ".pdf" ;
                    break;
                    
                    
                    //AQUI EMPIEZA GOBIERNO CORPORATIVO
                    
                       //AQUI EMPIEZA ASAMBLEA DE ACCIONISTAS
                    
                    case "convocatoria":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + gobiernocorporativofolder
                            + File.separator + asambleaacciofolder + convocatoriafolder + convocatoriafile + "-" + date + ".pdf" ;
                    break;
                    
                    case "minuta":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + gobiernocorporativofolder
                            + File.separator + asambleaacciofolder + minutafolder + minutafile + "-" + date + ".pdf" ;
                    break;
                    
                    
                     case "ordendeldia":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + gobiernocorporativofolder
                            + File.separator + asambleaacciofolder + ordendiafolder + ordendiafile + "-" + date + ".pdf" ;
                    break;
                    
                      case "presentaciondeinformacion":
                    path = HOME + File.separator + dirPrincipal + File.separator + documentosunicos + File.separator + gobiernocorporativofolder
                            + File.separator + asambleaacciofolder + presentacioninformacionfolder + presentacioninformacionfile + "-" + date + ".pdf" ;
                    break;
   
                    
            }
            
               FileManagerDTO fileManagerDTO = new FileManagerDTO();
                    fileManagerDTO.setFile(file);
                    fileManagerDTO.setName(path);

                    fileManager.uploading(fileManagerDTO);
            
        } catch (IOException ex) {
            Logger.getLogger(VentanaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
        
        
        
    }
    
    
    
}