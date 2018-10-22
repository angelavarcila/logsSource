/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.SystemEventsJpaController;
import control.util.GestionArchivo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.SystemEvents;

/**
 *
 * @author angela
 */
public class ConsultasLogAnalyzer {

    private static Scanner scanner;
    private static final String ARCHIVO = "resultado.txt";
    private static GestionArchivo gestionArchivo;
    private static String[] datos;


    private static SystemEventsJpaController systemEventsJpaController;

    public static void main(String[] args) {

        systemEventsJpaController = new SystemEventsJpaController();
        gestionArchivo = new GestionArchivo();

        scanner = new Scanner(System.in);
        gestionArchivo.leerArchivo(ARCHIVO);

        int opc;
        do {
            System.out.println("Elija una opción:");
            System.out.println("1. logs por host");
            System.out.println("5. salir");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Escriba el nombre del host"); //algunos host registran los logs por ip
                    String host = scanner.next();
                    getSystemEventsByHost(host);
                    break;
                case 5:
                    System.out.println("ADIOS!!!");
                    break;
                default:
                    System.out.println("\n Elija nuevamente \n");
                    break;
            }
        } while (opc != 5);

    }

    /**
     * Obtiene funciones por el nombre de host que se escribe como parámetro
     *
     * @param host el nombre del host
     */
    public static void getSystemEventsByHost(String host) {
        List<SystemEvents> lista = systemEventsJpaController.getSystemEventsByHost(host);

        String encabezado = "1_receiveat,2_device_reported_time,3_facility,4_priority,5_message,"
                + "6_info_unid_id,7_syslog_tag,8_process_id,9_checksum";
        gestionArchivo.escrbir(encabezado, false);

        for (SystemEvents se : lista) {
            gestionArchivo.escrbir(getLineInstance(se), true);
        }

    }

    public static String getLineInstance(SystemEvents systemEvents) {
        StringBuilder escriba = new StringBuilder();

        //INFORMACIÓN DEL LOG
        escriba.append(systemEvents.getReceivedAt() + ","); //momento en que se recive el log
        escriba.append(systemEvents.getDeviceReportedTime()+ ","); //momento en que el dispositivo genera el log 
        escriba.append(systemEvents.getFacility() + ","); //???
        escriba.append(systemEvents.getPriority()+ ","); //??
        escriba.append(systemEvents.getMessage().replaceAll(","," ") + ","); //log
        escriba.append(systemEvents.getInfoUnitID() + ","); //??
        escriba.append(systemEvents.getSysLogTag() + ","); //??
        escriba.append(systemEvents.getProcessid() + ","); //??
        escriba.append(systemEvents.getChecksum()); //??
             
        return escriba.toString();
    }

    /**
     * Obtiene los datos del archivo para su lectura de acuerdo a los parámetros
     *
     * @param lectura es el dato que se obtiene del método leerArchivo de la
     * clase GestionArchivo
     * @param numeroColumnas el número de columnas que tendrá el documento a
     * escribir
     *
     * @return la lista de cadenas de texto con el contenido del archivo que se
     * lee
     */
   /* public static List<String> obtenerDatosArchivo(String[] lectura, int numeroColumnas) {
        String textoArchivo = lectura[0];
        Integer tamanioArchivo = Integer.parseInt(lectura[1]);
        String[] datosPorLinea = textoArchivo.split("\n");

        List<String> lista = new ArrayList<>();
        for (int i = 0; i < tamanioArchivo; i++) {
            String[] texto = datosPorLinea[i].split(",");
            for (int j = 0; j < numeroColumnas; j++) {
                lista.add(texto[j]);
            }
        }
        return lista;
    }*/
    
}
