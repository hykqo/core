package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링컨테이너라고 보면 된다.
        //스프링이 AppConfig에 있는 환경설정정보(Bean으로 어노테이션되어있는것들)들을 스프링컨테이너에다가 객체 생성해서 관리해준다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //꺼내야되는 메소드명과 반환타입을 적어주자.
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
