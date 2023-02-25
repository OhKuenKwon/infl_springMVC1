package infl.spmvc1.svex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan   //서블릿 자동 등록을 위한 tag
@SpringBootApplication
public class Svex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Svex1Application.class, args);
	}
}
