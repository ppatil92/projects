package com.pratham.fileio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratham.fileio.model.LogVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    Logger log = LoggerFactory.getLogger(FileService.class);

    public String readFile(String fileName) {
        String fileOperationStatus = "Ok";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                LogVO logVo = parseLogVO(line);
                System.out.println(logVo.getHost());
            }
      } catch (IOException e) {
           log.error("Error while processing file "+e.getMessage());
           fileOperationStatus = "ERROR";
        }
        return fileOperationStatus;
    }

    public LogVO parseLogVO(String input) {
        LogVO logVO = null;
        try {
            logVO =  new ObjectMapper().readValue(input,LogVO.class);
        } catch (JsonProcessingException e) {
            log.error("error while parsing logvo "+e.getMessage());
        }
        return logVO;
    }
}
