package demo.example.blogspring1.aspect;

import demo.example.blogspring1.model.Post;
import demo.example.blogspring1.service.PostService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalTime;

@Aspect
@Component
public class WebConfigAspect {

    private  static Logger logger= LoggerFactory.getLogger(WebConfigAspect.class);
    private PostService postService;

    public WebConfigAspect(PostService postService) {
        this.postService = postService;
    }

    @Before("execution(* *.showAllPost(..))")
    public  void logging(JoinPoint joinPoint){



        Object[] objects=joinPoint.getArgs();

        logger.info("Cureent time:"+LocalTime.now()+" " +
            joinPoint.getSignature().getName() +"  called with:"+objects);
    }
   @Before("execution(* *.showDetails(..))")
    public  void notfoundAspect(JoinPoint joinPoint) {
       // Object[] objects =joinPoint.getArgs();
       // Long id=(Long) objects[0];
       // Post post =postService.findById( (Long) objects[0]);
        if(postService.findById((Long) joinPoint.getArgs()[1])==null){
            throw new EntityNotFoundException((Long) joinPoint.getArgs()[1]+" Not found");
        }


    }


}
