/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.GregorianCalendar;

/**
 *
 * @author Airton Robson
 */
public class Data {
    
    public String dataAtualString(){
        String data = "";
        GregorianCalendar cal = new GregorianCalendar();
        // DIA
        if(GregorianCalendar.DAY_OF_WEEK == 1){
            data = "Domingo, ";
        }else if(GregorianCalendar.DAY_OF_WEEK == 2){
            data = "Segunda, ";
        }else if(GregorianCalendar.DAY_OF_WEEK == 3){
            data = "Terça, ";
        }else if(GregorianCalendar.DAY_OF_WEEK == 4){
            data = "Quarta, ";
        }else if(GregorianCalendar.DAY_OF_WEEK == 5){
            data = "Quinta, ";
        }else if(GregorianCalendar.DAY_OF_WEEK == 6){
            data = "Sexta, ";
        }else if(GregorianCalendar.DAY_OF_WEEK == 7){
            data = "Sábado, ";
        }
        // MÊS
        if(GregorianCalendar.MONTH == 0){
            data = data +"Janeiro de ";
        }else if(GregorianCalendar.MONTH == 1){
            data = data +"Fevereiro de ";
        }else if(GregorianCalendar.MONTH == 2){
            data = data +"Março de ";
        }else if(GregorianCalendar.MONTH == 3){
            data = data +"Abril de ";
        }else if(GregorianCalendar.MONTH == 4){
            data = data +"Maio de ";
        }else if(GregorianCalendar.MONTH == 5){
            data = data +"Junho de ";
        }else if(GregorianCalendar.MONTH == 6){
            data = data +"Juho de ";
        }else if(GregorianCalendar.MONTH == 7){
            data = data +"Agosto de ";
        }else if(GregorianCalendar.MONTH == 8){
            data = data +"Setembro de ";
        }else if(GregorianCalendar.MONTH == 9){
            data = data +"Outubro de ";
        }else if(GregorianCalendar.MONTH == 10){
            data = data +"Novembro de ";
        }else if(GregorianCalendar.MONTH == 11){
            data = data +"Dezembro de ";
        }
        
        data = data + GregorianCalendar.YEAR;
        
        return data;
        
        
    }
    
}
