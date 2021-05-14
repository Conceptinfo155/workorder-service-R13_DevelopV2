package com.comcast.orion.workorder.integration;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.store.MessageGroupStoreReaper;
import org.springframework.integration.store.SimpleMessageStore;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.comcast.orion.workorder.config.MdcTaskDecorator;


@Configuration
@ComponentScan({"com.comcast.orion.workorder.integration"})
public class ChannelConfiguration {
	
	@Value("${integration.threadPoolTaskExecutor.corePoolSize}")
	private int corePoolSize;
	
	@Value("${integration.threadPoolTaskExecutor.maxPoolSize}")
	private int maxPoolSize;
	
	@Value("${integration.threadPoolTaskExecutor.waitForJobsToCompleteOnShutdown}")
	private boolean waitForJobsToCompleteOnShutdown;

	@Value("${integration.messageGroupStoreReaper.timeout}")
	private long timeout;

	@Bean
    public MessageChannel splitterChannel() {
        return new DirectChannel();
    }
	
	@Bean
    public MessageChannel routerChannel() {
        return new DirectChannel();
    }
	
	
	@Bean
    public MessageChannel futureWorkOrderChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }
	
	@Bean
    public MessageChannel aggregatorChannel() {
		 return new DirectChannel();
	}
	
	@Bean
    public MessageChannel deviceIpOut() {
		 return new DirectChannel();
	}
	
	@Bean
    public MessageChannel errorChannel() {
		 return new ExecutorChannel(threadPoolTaskExecutor());
	}
	@Bean
    public MessageChannel installbaseOut() {
		 return new DirectChannel();
	}

    @Bean
    public MessageChannel installbaseSplitterChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel installbaseRouterChannel() {
        return new DirectChannel();
    }
    
    @Bean
    public MessageChannel vmsOut() {
		 return new DirectChannel();
	}

    @Bean
    public MessageChannel vmsSplitterChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel vmsRouterChannel() {
        return new DirectChannel();
    }
    
    @Bean
    public MessageChannel workOrderOut() {
		 return new DirectChannel();
	}
    @Bean
    public MessageChannel workOrderDetailsSplitterChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel workOrderDetailsRouterChannel() {
        return new DirectChannel();
    }
    
    @Bean
    public MessageChannel aggregatorWorkorderChannel() {
        return new DirectChannel();
    }


    @Bean
    public MessageChannel installbaseChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }
    
    @Bean
    public MessageChannel vmsChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }

    @Bean
    public MessageChannel aggregatorInstallbaseChannel() {
        return new DirectChannel();
    }
    
    @Bean
    public MessageChannel aggregatorVmsChannel() {
        return new DirectChannel();
    } 
    
    @Bean
    public MessageChannel workOrderDetailsChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }
    
    @Bean
    public MessageChannel productChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }
	
	@Bean
	public MessageChannel odsChannel() {
		return new ExecutorChannel(threadPoolTaskExecutor());
	}
	
	//*****CREATE WORKORDER CHANNEL STARTS*****//
	@Bean
    public MessageChannel createWorkorderSplitterChannel() {
        return new DirectChannel();
    }
	
	@Bean
    public MessageChannel createWorkorderRouterChannel() {
        return new DirectChannel();
    }
	
	@Bean
    public MessageChannel createworkorderAggregatorChannel() {
		 return new DirectChannel();
	}
	
	@Bean
    public MessageChannel createWorkorderOut() {
		 return new DirectChannel();
	}
	

    @Bean
    public MessageChannel locationChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }
    
    @Bean
    public MessageChannel siteChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }

    @Bean
    public MessageChannel wfxChannel() {
    	  return new ExecutorChannel(threadPoolTaskExecutor());
    }

    @Bean
    public MessageChannel scheduleWORouter() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel sqoScheduleWORouter() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel sqoScheduleWOSplitter() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel sqoScheduleWoSiteChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }

    @Bean
    public MessageChannel sqoScheduleWoCustomerChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }

    @Bean
    public MessageChannel sqoScheduleWoOrderChannel() {
        return new ExecutorChannel(threadPoolTaskExecutor());
    }

    @Bean
    public MessageChannel sqoScheduleWOResponse() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel createworkorderFilterIn() {
    	 return new ExecutorChannel(threadPoolTaskExecutor());
    } 
	//*****CREATE WORKORDER CHANNEL end*****//
	@Bean
    public Executor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);
	    executor.setTaskDecorator(new MdcTaskDecorator());
	    //executor.initialize();
		return executor;
	}
	
	@Bean
	public SimpleMessageStore messageGroupStore(){
		return new SimpleMessageStore();
	}
	
	@Bean
	public MessageGroupStoreReaper messageGroupStoreReaper() {
		MessageGroupStoreReaper MessageGroupStoreReaper = new MessageGroupStoreReaper();
		MessageGroupStoreReaper.setMessageGroupStore(messageGroupStore());
		MessageGroupStoreReaper.setTimeout(timeout);
		return MessageGroupStoreReaper;
	}
	

}