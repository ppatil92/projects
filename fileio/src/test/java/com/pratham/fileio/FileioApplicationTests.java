package com.pratham.fileio;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratham.fileio.model.LogVO;
import com.pratham.fileio.service.FileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
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

	@Test
	public void fileRead_filefound_NoException() {
		String fileName = "src/test/resources/sample.txt";
		Assert.assertEquals("Ok",fileService.readFile(fileName));
	}

	@Test
	public void fileRead_fileNotFound_IOException() {
		String fileName = "";
		Assert.assertEquals("ERROR",fileService.readFile(fileName));
	}

}
