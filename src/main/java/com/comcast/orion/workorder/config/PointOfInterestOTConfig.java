package com.comcast.orion.workorder.config;


import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.comcast.orion.logging.interceptor.CXFLoggingInFaultInterceptor;
import com.comcast.orion.logging.interceptor.CXFLoggingOutFaultInterceptor;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

import services.web.trackem.WebServicesSoap;



@Configuration
public class PointOfInterestOTConfig {

	@Value("${officetrack.pointofdelete.username}")
	String officeTrackUserName;
	
	@Value("${officetrack.pointofdelete.endpoint}")
	String endpoint;
	
	@Value("${officetrack.pointofdelete.password}")
	String officeTrackPassword;
	
	@Value("${officetrack.pointofdelete.connectiontimeout}")
	String connectionTimeout;
	
	@Value("${officetrack.pointofdelete.receivetimeout}")
	String receiveTimeOut;
	/** The Constant LOGGER. */
	private static final Logger log = LoggerFactory.getLogger(PointOfInterestOTConfig.class);
					
	@Bean(name = "getOTServicePort")
	public WebServicesSoap getOTServicePort() throws OrionMiddlewareServiceException {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(WebServicesSoap.class);
		jaxWsProxyFactoryBean.setAddress(endpoint);		
		jaxWsProxyFactoryBean.getInFaultInterceptors().add(new CXFLoggingInFaultInterceptor());
		jaxWsProxyFactoryBean.getOutFaultInterceptors().add(new CXFLoggingOutFaultInterceptor());
		jaxWsProxyFactoryBean.getInInterceptors().add(new SoapInAuditHandler());
		jaxWsProxyFactoryBean.getOutInterceptors().add(new SoapOutAuditHandler());		
		//jaxWsProxyFactoryBean.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
		jaxWsProxyFactoryBean.setBindingId(SOAPBinding.SOAP12HTTP_BINDING);		
		return (WebServicesSoap) jaxWsProxyFactoryBean.create();
	}
	
	@Bean
	public Client getESPGetBillClientProxy3() throws OrionMiddlewareServiceException {
		return ClientProxy.getClient(getOTServicePort());
	}
	
	@Bean
	public HTTPConduit comcastNotificationStatusConduit1() throws OrionMiddlewareServiceException {
		HTTPConduit httpConduit3 = (HTTPConduit) getESPGetBillClientProxy3().getConduit();
		httpConduit3.getClient().setConnectionTimeout(Long.valueOf(connectionTimeout));
		httpConduit3.getClient().setReceiveTimeout(Long.valueOf(connectionTimeout));
		return httpConduit3;
	}
	}



