package ru.pavel2107.tests.suitablesoftdemo.service.processor;

/*
* Назначение класса  : чтение потока, в котором находится xlsx-фал и формирование массива чисел
* Единственный метод : read на вход получает поток xlsx и возвращает массив целых чисел
*
 */


import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class XlsProcessorImpl implements XlsProcessor{

    @Override
    public List<Integer> read(InputStream stream) throws Exception {
        List<Integer> arr = new ArrayList<>();

        try( Workbook wb = WorkbookFactory.create( stream)){
            Sheet sheet = wb.getSheetAt( 0);
            sheet.forEach( (row) ->{
                Cell cell = row.getCell( 0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if( cell != null && cell.getCellType() == CellType.NUMERIC){
                    int currentValue = (int) cell.getNumericCellValue();
                    arr.add( currentValue);
                }
            });
        }

        return arr;
    }
}
