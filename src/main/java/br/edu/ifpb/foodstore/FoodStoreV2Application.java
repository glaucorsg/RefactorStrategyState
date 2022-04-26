package br.edu.ifpb.foodstore;

import br.edu.ifpb.foodstore.repository.LogRegisterRepository;
import br.edu.ifpb.foodstore.service.log.LogHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class FoodStoreV2Application {

	public static void main(String[] args) {
		SpringApplication.run(FoodStoreV2Application.class, args);
	}

	@Bean("logHandler")
	@Primary
	public LogHandler getLogHandlerDatabase(final LogRegisterRepository logRegisterRepository) {
		return new LogHandler(logRegisterRepository, LogHandler.LogHandlerType.DATABASE);
	}

	@Bean("logHandlerFile")
	public LogHandler getLogHandlerFile() {
		return new LogHandler(null, LogHandler.LogHandlerType.FILE);
	}

}
