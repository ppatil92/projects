package com.pratham.fileio;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratham.fileio.model.LogVO;
import com.pratham.fileio.repository.LogRepository;
import com.pratham.fileio.service.FileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RunWith(MockitoJUnitRunner.class)
public class FileioApplicationTests {

	@InjectMocks
	FileService fileService;

	@Mock
	LogRepository logRepository;

	@Test
	public void processFile_filefound_NoException() {

		Assert.assertEquals("Ok",fileService.processFile());
	}

}
