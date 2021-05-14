package com.comcast.orion.workorder.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




import java.net.MalformedURLException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonObjectGeneratorTest {
	
	
	JsonObjectGenerator jsonObjectGenerator = new JsonObjectGenerator();
	private String path = "\\src\\main\\resources\\json\\UpdateStatus\\UpdateResponse.json";
	private String dirPath = "\\src\\main\\resources\\json\\UpdateStatus";
	
	
	
	@Before
	public void setUp() {
		Path currentRelativePath = Paths.get("");
		String absolutePath = currentRelativePath.toAbsolutePath().toString();
		path = absolutePath + path;
		dirPath = absolutePath + dirPath;
	}

	@Test
	public void testMain() throws Exception {
		String[] args = new String[] {};
		JsonObjectGenerator.main(args);
		assertNotNull("returns nothing & no exception", "Success");
	}
	
	@Test
	public void testGenerateJsonPogo() throws MalformedURLException {
		Path testPath = Paths.get(path);
		if (Files.isRegularFile(testPath)) {
			jsonObjectGenerator.generateJsonPogo(testPath);
			assertNotNull("returns nothing & no exception", "Success");
		}
		
	}

	
	@Test
	public void testGetDomainPackagePath() throws MalformedURLException {
		Path testPkgPath = Paths.get(path);
		if (Files.isRegularFile(testPkgPath)) {
			assertEquals("pkgPath value returned as expected", JsonObjectGenerator.POJO_DOMAIN_FOLDER,
					jsonObjectGenerator.getDomainPackagePath(testPkgPath));
		}
	}
	
	
}
