package infl.spmvc1.svex2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Svex2Application {
	public static void main(String[] args) {
		SpringApplication.run(Svex2Application.class, args);
	}
}
