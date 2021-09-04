package com.pratham.fileio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratham.fileio.constants.Constants;
import com.pratham.fileio.entity.LogEntity;
import com.pratham.fileio.model.LogVO;
import com.pratham.fileio.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class FileService {
    Logger log = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private LogRepository logRepository;

    @Value("${file.path}")
    String fileName ="src/main/resources/sample.txt";

    public String processFile() {
        String fileOperationStatus = "Ok";
        HashSet<String>  processed = new HashSet<>();
        HashMap<String,LogVO> tempMap = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileOperationStatus = processLogs(tempMap,processed,line);
            }
      } catch (IOException e) {
           log.error("Error while processing file "+e.getMessage());
           fileOperationStatus = "ERROR";
        }
        return fileOperationStatus;
    }

    private String processLogs(HashMap<String,LogVO> map,HashSet<String> processed,String line) {
        LogVO logVo = parseLogVO(line);
        LogVO alreadyFoundLog = map.get(logVo.getId());
        long diff = 0;
        if(logVo !=null && !processed.contains(logVo.getId())) {
            // found both started and finished
            if(alreadyFoundLog != null) {
                if(Constants.STARTED.equals(alreadyFoundLog.getState())) {
                    diff = logVo.getTimestamp() - alreadyFoundLog.getTimestamp();
                } else {
                    diff = alreadyFoundLog.getTimestamp() - logVo.getTimestamp();
                }
                addLogEntry(logVo,diff);
                //after processing add to processed set
                processed.add(logVo.getId());
            } else {
                // found either started or finished
                map.put(logVo.getId(),logVo);
            }
        }
        return "Ok";
    }

    @Transactional
    private void addLogEntry(LogVO logVO,long difference) {
      try{
          LogEntity log = new LogEntity();
          log.setId(logVO.getId());
          log.setDuration(difference);
          log.setType(logVO.getType());
          log.setHost(logVO.getHost());
          if(difference > 4 ) {
              log.setAlert(true);
          } else {
              log.setAlert(false);
          }
          logRepository.save(log);
      } catch (Exception e) {
          log.error("error while savind log "+logVO.getId());
      }

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
