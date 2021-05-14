package com.comcast.orion.workorder.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.InclusionLevel;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.VisibleForTesting;
import com.sun.codemodel.JCodeModel;



/**
 * JsonObjectGenerator
 *
 */
public class JsonObjectGenerator {

	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(JsonObjectGenerator.class);
	

	/**
	 * JSON_SOURCE_FOLDER
	 */

	private static final String JSON_SOURCE_FOLDER = "\\src\\main\\resources\\json\\nWFX\\create";
	
	/**
	 * POJO_DOMAIN_FOLDER
	 */
	
	@VisibleForTesting

	//US1761689
	static final String POJO_DOMAIN_FOLDER = "com.comcast.orion.workorder.domain.nWFX.create";
	/**
	 * STR_DOT
	 */

	private static final String STR_DOT = ".";
	
	/**
	 * STR_BACKSLASH
	 */
	private static final String STR_BACKSLASH = "\\";

	public static void main(String[] args)  {
		
		/*
		 * In method getDomainPackagePath, set subDomainRequired to true/false according to requirements. 
		 * eg : If schema is segregated in multiple folders, which require respective domain packages, then variable will be set to true. 
		 * default set to false. 
		 * Update JSON_SOURCE_FOLDER and POJO_DOMAIN_FOLDER accordingly. 
		 * */
		
		JsonObjectGenerator builder = new JsonObjectGenerator();
		Path currentRelativePath = Paths.get("");
		String absolutePath = currentRelativePath.toAbsolutePath().toString();

		try (Stream<Path> paths = Files.walk(Paths.get(absolutePath + JSON_SOURCE_FOLDER))) {
			paths.filter(Files::isRegularFile).forEach(builder::generateJsonPogo);
		} catch (IOException e) {
			log.error("Exception Occurred in JsonObjectGenerator#main --- IOException - Message: "
					+ e);
		}
	}

	/**
	 * @param path
	 */
	 // This method generates jsonpogo
	@VisibleForTesting
	 void generateJsonPogo(Path path) {

		JCodeModel codeModel = new JCodeModel();
		
		try {
			URL url = path.toUri().toURL();
			String domainFolder = getDomainPackagePath(path);				
			GenerationConfig config = new DefaultGenerationConfig() {

			private  final Path CURRENT_RELATIVE_PATH = Paths.get("");
			private  final String ABSOLUTE_PATH = CURRENT_RELATIVE_PATH.toAbsolutePath().toString();				
				

				/* (non-Javadoc)
				 * @see org.jsonschema2pojo.DefaultGenerationConfig#getAnnotationStyle()
				 */
				@Override
				public AnnotationStyle getAnnotationStyle() {
					return AnnotationStyle.JACKSON;
				}
				
				/* (non-Javadoc)
				 * @see org.jsonschema2pojo.DefaultGenerationConfig#getTargetDirectory()
				 */
				@Override
				public File getTargetDirectory() {
					return new File(ABSOLUTE_PATH.concat("\\src\\main\\java"));
				}

				/* (non-Javadoc)
				 * @see org.jsonschema2pojo.DefaultGenerationConfig#isIncludeAdditionalProperties()
				 */
				@Override
				public boolean isIncludeAdditionalProperties() {
					return false;
				}

				/* (non-Javadoc)
				 * @see org.jsonschema2pojo.DefaultGenerationConfig#isIncludeJsr303Annotations()
				 */
				@Override
				public boolean isIncludeJsr303Annotations() {
					return true;
				}

				/* (non-Javadoc)
				 * @see org.jsonschema2pojo.DefaultGenerationConfig#isGenerateBuilders()
				 */
				@Override
				public boolean isGenerateBuilders() {
					return true;
				}
				
				/* (non-Javadoc)
				 * @see org.jsonschema2pojo.DefaultGenerationConfig#getInclusionLevel()
				 */
				@Override
				public InclusionLevel getInclusionLevel() {
					return InclusionLevel.NON_NULL;
				}				

				@Override
				public SourceType getSourceType() {
					return SourceType.JSONSCHEMA;
				}
			};
			SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new CustomAnnonator(), new SchemaStore()),new SchemaGenerator());
			
			mapper.generate(codeModel, path.getFileName().toString().split(".json")[0],domainFolder, url);

			codeModel.build(config.getTargetDirectory());
			
		} catch (IOException e) {
			log.error("Exception Occurred in JsonObjectGenerator#SchemaMapper --- IOException - Message: "
					+ e);
		}
	}
	
	/**
	 * @param path
	 * @return POJO_DOMAIN_FOLDER
	 */
	  // This method gets domain package path
	@VisibleForTesting
	 String getDomainPackagePath(Path path){
		String returnStr = POJO_DOMAIN_FOLDER;
		String jsonSourcePackagePath = Paths.get("").toAbsolutePath().toString()+JSON_SOURCE_FOLDER;
			//Retrieve subDomain package name from 
			String subDomainPackgePath = path.toAbsolutePath().toString().substring(jsonSourcePackagePath.length()).split(path.getFileName().toString())[0]; 		
			String str = subDomainPackgePath.replace(STR_BACKSLASH, STR_DOT);
			int index = str.lastIndexOf(STR_DOT);
			String subDomainPackage = str.subSequence(0, index).toString();
			returnStr+=subDomainPackage;
		return returnStr;
	}
}
