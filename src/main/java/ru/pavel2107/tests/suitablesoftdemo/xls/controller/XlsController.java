package ru.pavel2107.tests.suitablesoftdemo.xls.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.pavel2107.tests.suitablesoftdemo.service.finder.ElementFinder;
import ru.pavel2107.tests.suitablesoftdemo.service.processor.XlsProcessor;

import java.util.List;

@RestController
public class XlsController {

    private final XlsProcessor processor;
    private final ElementFinder elementFinder;

    @Autowired
    public XlsController(XlsProcessor processor, ElementFinder elementFinder){
        this.processor = processor;
        this.elementFinder = elementFinder;
    }

    @PostMapping( value = "/loadfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> LoadFile( @RequestParam( "file")MultipartFile file, @RequestParam( "n") int n){
        int result = -1;

        try{
            List<Integer> arr = processor.read( file.getInputStream());
            result = elementFinder.findLargest( arr.stream().mapToInt( i -> i).toArray(), n);
        }
        catch (Exception e) {
            return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>( "" + result, HttpStatus.OK);
    }

}
