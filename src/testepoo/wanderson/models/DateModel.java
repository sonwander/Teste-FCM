/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testepoo.wanderson.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author vinic
 */
public class DateModel {

    public DateModel() {

    }

    public LocalDate formatarData(String data) {
        int mes, ano, dia;
        LocalDate dataFormat=null;
        String[] dataSplit = data.split("/");

        if (dataSplit.length == 2) {
            mes = Integer.parseInt(dataSplit[0]);
            ano = Integer.parseInt(dataSplit[1]);
            dataFormat = LocalDate.of(ano, mes, 1);
        } else {
            mes = Integer.parseInt(dataSplit[1]);
            ano = Integer.parseInt(dataSplit[2]);
            dia = Integer.parseInt(dataSplit[0]);
            dataFormat = LocalDate.of(ano, mes, dia);
        }
        return dataFormat;

    }

    public int getPeriodoTrabalho(String dataAd) {
        LocalDate dataAdFormat = formatarData(dataAd);
        Date dataAtual = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtualFormat = dateFormat.format(dataAtual);

        LocalDate dataAtualFormatLD = formatarData(dataAtualFormat);

        Period periodo = Period.between(dataAdFormat, dataAtualFormatLD);

        return periodo.getYears();

    }
}
