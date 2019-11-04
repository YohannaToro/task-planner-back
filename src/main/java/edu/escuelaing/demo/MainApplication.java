package edu.escuelaing.demo;

import com.mongodb.client.gridfs.model.GridFSFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.escuelaing.demo.config.AppConfiguration;
import edu.escuelaing.demo.config.JwtFilter;
import edu.escuelaing.demo.model.Task;
import edu.escuelaing.demo.model.User;
import edu.escuelaing.demo.repository.mongo.TaskRepository;
import edu.escuelaing.demo.repository.mongo.UserRepository;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
import java.net.URL;
@SpringBootApplication
@ComponentScan(basePackages = {"edu.escuelaing.demo"})
public class MainApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private TaskRepository taskRepository;
	@Autowired
    GridFsTemplate gridFsTemplate;

    public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		/*String updtaeDate = "2018-12-18 15:30";
        String dueDate1 = "2018";
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
		userRepository.deleteAll();
		userRepository.save(new User("yowis", "yohanna", "web UI", "123"));
		taskRepository.deleteAll();
		taskRepository.save(new Task("hacer ...","1",null,updtaeDate,false,dueDate1));
		System.out.println("User found with findAll():");
        System.out.println("-------------------------------");
        for (User customer : userRepository.findAll()) {
            System.out.println(customer.getName());
        }
		System.out.println();
		System.out.println("Task found with findAll():");
        System.out.println("-------------------------------");
        for (Task customer : taskRepository.findAll()) {
            System.out.println(customer.getName());
        }
		System.out.println();
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("yohanna"));

   		User customer = mongoOperation.findOne(query, User.class);
		System.out.println("name:"+customer.getName());*/
		

	}


}
