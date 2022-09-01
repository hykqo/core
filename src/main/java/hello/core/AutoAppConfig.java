package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //특정 경로부터 스캔하도록 지정.
        basePackages = "hello.core.member",
        //해당 클래스가 포함된 패키지부터 지정.
        basePackageClasses = AutoAppConfig.class,
        //제외할 클래스 지정. AppConfig 클래스가 있으므로, Configuration어노테이션이 붙은 클래스는 제외시켜준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //만약 지정하지 않는다면, @ComponentScan이 붙은 클래스의 패키지가 시작위치가 된다.
)
public class AutoAppConfig {
}
